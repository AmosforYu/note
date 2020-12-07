package com.yyb.common.utils;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.conn.ssl.AllowAllHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import javax.net.ssl.SSLContext;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Map;

public final class HttpUtil {
    private static final Logger LOG = LoggerFactory.getLogger(HttpUtil.class);


    private HttpUtil() {
    }

    public static CloseableHttpClient newHttpClient() {
        SSLConnectionSocketFactory sslsf = null;
        try {
            SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null,
                    new TrustStrategy() {
                        // 信任所有
                        public boolean isTrusted(X509Certificate[] chain,
                                                 String authType) throws CertificateException {
                            return true;
                        }
                    }).build();

            sslsf = new SSLConnectionSocketFactory(sslContext,
                    new String[]{"TLSv1", "TLSv1.1", "TLSv1.2"},
                    null,
                    new AllowAllHostnameVerifier());

        } catch (Exception e) {
            LOG.error("init http client error: ", e);
        }
        CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(sslsf).setMaxConnTotal(200).setMaxConnPerRoute(100).build();

        return httpClient;
    }

    public static String doRequest(CloseableHttpClient httpClient, String method, String url, final Map<String, Object> head, String body, String logTrace) throws Exception {
        if (StringUtils.isEmpty(logTrace)) {
            logTrace = String.valueOf(System.currentTimeMillis());
        }
        if (httpClient == null || StringUtils.isEmpty(method) || StringUtils.isEmpty(url)) {
            LOG.error("[{}] request param empty. method: {}, url: {}", logTrace, method, url);
            return null;
        }

        HttpRequestBase reqBase = null;
        CloseableHttpResponse response = null;
        InputStream responseStream = null;

        try {
            LOG.info("[{}] start to execute task. method: {} url: {}, head: {}, body: {}", logTrace, method, url, head, body);

            int timeout = 15000;
            RequestConfig reqConfig = RequestConfig.custom().
                    setConnectTimeout(timeout). //连接超时时间,单位毫秒
                    setConnectionRequestTimeout(timeout). //设置从connect Manager获取Connection 超时时间,单位毫秒
                    setSocketTimeout(timeout).build(); //请求获取数据的超时时间，单位毫秒

            if (HttpPost.METHOD_NAME.equalsIgnoreCase(method)) {
                HttpPost httpPost = new HttpPost(url);
                if (!StringUtils.isEmpty(body)) {
                    httpPost.setEntity(new StringEntity(body, StandardCharsets.UTF_8));
                }
                reqBase = httpPost;
            } else if (HttpGet.METHOD_NAME.equalsIgnoreCase(method)) {
                reqBase = new HttpGet(url);
            } else if (HttpPut.METHOD_NAME.equalsIgnoreCase(method)) {
                HttpPut httpPut = new HttpPut(url);
                if (!StringUtils.isEmpty(body)) {

                    httpPut.setEntity(new StringEntity(body, StandardCharsets.UTF_8));
                }
                reqBase = httpPut;
            } else if (HttpDelete.METHOD_NAME.equalsIgnoreCase(method)) {
                reqBase = new HttpDelete(url);
            } else {
                return null;
            }
            reqBase.setConfig(reqConfig);

            if (head != null) {
                for (Map.Entry<String, Object> entry : head.entrySet()) {
                    reqBase.setHeader(entry.getKey(), String.valueOf(entry.getValue()));
                }
            }

            response = httpClient.execute(reqBase);
            HttpEntity entity = response.getEntity();
            responseStream = entity.getContent();
            String responseContent = EntityUtils.toString(entity, StandardCharsets.UTF_8);
            int statusCode = response.getStatusLine().getStatusCode();
            LOG.info("[{}] execute task completed. status code: {}, response: {} ", logTrace, statusCode, responseContent);

            return responseContent;
        } catch (Exception e) {
            LOG.error(String.format("[%s] execute task error!", logTrace), e);
            throw e;
        } finally {
            try {
                if (response != null) {
                    if (responseStream != null) {
                        responseStream.close();
                    }
                    response.close();
                }
                if (reqBase != null) {
                    reqBase.releaseConnection();
                }
            } catch (Exception ignore) {
                LOG.warn(String.format("[%s] execute task error when release connection", logTrace), ignore);
            }
        }
    }


    public static String get(CloseableHttpClient httpClient, String url, final Map<String, String> header) {
        int timeout = 15000;
        return getTimeout(httpClient, url, header, timeout);
    }

    public static String getTimeout(CloseableHttpClient httpClient, String url, final Map<String, String> header, int timeout) {
        long currentTime = System.currentTimeMillis();

        HttpGet get = null;
        CloseableHttpResponse response = null;
        InputStream responseStream = null;
        try {
            LOG.info("[{}] start to execute task. url: {}", currentTime, url);

            RequestConfig reqConfig = RequestConfig.custom().
                    setConnectTimeout(timeout). //连接超时时间,单位毫秒
                    setConnectionRequestTimeout(timeout). //设置从connect Manager获取Connection 超时时间,单位毫秒
                    setSocketTimeout(timeout).build(); //请求获取数据的超时时间，单位毫秒

            get = new HttpGet(url);
            get.setConfig(reqConfig);

            for (Map.Entry<String, String> entry : header.entrySet()) {
                get.setHeader(entry.getKey(), entry.getValue());
            }

            response = httpClient.execute(get);
            HttpEntity entity = response.getEntity();
            responseStream = entity.getContent();
            String responseContent = EntityUtils.toString(entity, StandardCharsets.UTF_8);
            int statusCode = response.getStatusLine().getStatusCode();
            LOG.info("[{}] execute task completed. status code: {}, response: {} ", currentTime, statusCode, responseContent);

            return responseContent;
        } catch (Exception e) {
            LOG.error(String.format("[%s] execute task error!", currentTime), e);
        } finally {
            try {
                if (response != null) {
                    if (responseStream != null) {
                        responseStream.close();
                    }
                    response.close();
                }
                if (get != null) {
                    get.releaseConnection();
                }
            } catch (Exception ignore) {
                LOG.warn(String.format("[%s] execute task error when release connection", currentTime), ignore);
            }
        }
        return null;
    }
}
