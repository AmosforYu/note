package com.yyb.learn.jarea.service;

import com.alibaba.fastjson.JSONObject;
import com.yyb.common.dtos.response.RespBody;
import com.yyb.common.utils.HttpUtil;
import com.yyb.learn.jarea.dao.AreaDao;
import com.yyb.learn.jarea.entity.AreaInfoDto;
import org.apache.commons.lang.StringUtils;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.HashMap;
import java.util.Map;


/**
 * @author Yamos
 * @description AreaService
 * @date 2020/12/24 0024 14:46
 */
@Service
public class AreaService {

    private static final Logger LOG = LoggerFactory.getLogger(AreaService.class);

    private static final String REDIS_KEY_AREA_PREFIX = "hy:area:phone:";

    private static final String ALIYUN_URL = "https://api04.aliyun.venuscn.com/mobile?mobile=%s";

    private static final String ALIYUN_AUTHORIZATION = "APPCODE cb94a6a8613549a4905b9667e769f922";

    private static final CloseableHttpClient HTTP_CLIENT = HttpUtil.newHttpClient();

    @Autowired
    private AreaDao areaDao;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Async("area-executor")
    public void getAreaInfoByPhone(DeferredResult<JSONObject> deferredResult, String phone) {
        try {
            JSONObject result = getAreaInfoResult(phone);
            deferredResult.setResult(result);
        } catch (Exception e) {
            deferredResult.setErrorResult(e);
        }
    }

    private JSONObject getAreaInfoResult(String phone) {
        if (isNotPhone(phone)) {
            return RespBody.failCodeMsg(10001, "请传入正确手机号");
        }

        String phonePre = formatPhonePre(phone);

        String cacheValue = getAreaInfoFromCache(phonePre);
        if (StringUtils.isNotEmpty(cacheValue)) {
            return RespBody.successData(parseCacheToAreaInfo(cacheValue));
        }

        AreaInfoDto areaInfo = getAreaInfoFromDB(phonePre);

        if (null == areaInfo) {
            areaInfo = getAreaFromAliyun(phone);
        }

        if (null == areaInfo) {
            return RespBody.failCodeMsg(10002, "未查到对应的归属地信息");
        }

        storeAreaToCache(phonePre, areaInfo);

        return RespBody.successData(areaInfo);
    }

    //将号段信息保存到缓存中
    private void storeAreaToCache(String phonePre, AreaInfoDto areaInfo) {
        String key = REDIS_KEY_AREA_PREFIX + phonePre;;
        String province = areaInfo.getProvinceName();
        String provinceCode = areaInfo.getProvinceCode();
        String area = areaInfo.getCityName();
        String areaCode = areaInfo.getCityCode();
        String isp = areaInfo.getIsp();

        StringBuilder builder = new StringBuilder();
        builder.append(provinceCode).append(":").append(province).append(":")
                .append(areaCode).append(":").append(area).append(":").append(isp);
        String value = builder.toString();
        stringRedisTemplate.opsForValue().set(key, value);
    }

    //缺失号段信息可通过其他平台获取补充
    private AreaInfoDto getAreaFromAliyun(String phone) {
        String url = String.format(ALIYUN_URL, phone);

        HashMap header = new HashMap();

        header.put("Authorization", ALIYUN_AUTHORIZATION);

        try {
            String response = HttpUtil.doRequest(HTTP_CLIENT, HttpGet.METHOD_NAME, url, header, null, phone);

            if (StringUtils.isEmpty(response)) {
                LOG.error("get phone: {} from net error: response is empty", phone);
                return null;
            }

            JSONObject respJSON = JSONObject.parseObject(response);

            int ret = respJSON.getIntValue("ret");
            if (ret == 200) {
                JSONObject data = respJSON.getJSONObject("data");

                String phonePre = data.getString("num");
                String province = data.getString("prov");
                String city = data.getString("city");
                String isp = data.getString("types");
                String areaCode = data.getString("city_code");
                String postCode = data.getString("zip_code");

                String provinceCode = areaDao.getProvinceCode(areaCode);

                areaDao.insertArea(phonePre, province, city, isp, areaCode, postCode, provinceCode);

                AreaInfoDto area = new AreaInfoDto();
                area.setProvinceName(province);
                area.setProvinceCode(provinceCode);
                area.setCityName(city);
                area.setCityCode(areaCode);
                area.setIsp(isp);

                return area;
            }

        } catch (Exception e) {
            LOG.error(String.format("get area info by phone: %s from aliyun error: ", phone), e);
            return null;
        }
        return null;
    }

    private AreaInfoDto getAreaInfoFromDB(String phonePre) {
        return areaDao.getAreaInfoByPhone(phonePre);
    }

    //缓存取出的数据格式化成封装对象
    private AreaInfoDto parseCacheToAreaInfo(String cacheValue) {
        String[] field = cacheValue.split(":");
        if (field.length != 5) {
            return null;
        }

        AreaInfoDto area = new AreaInfoDto();
        area.setProvinceCode(field[0]);
        area.setProvinceName(field[1]);
        area.setCityCode(field[2]);
        area.setCityName(field[3]);
        area.setIsp(field[4]);

        return area;
    }

    private String getAreaInfoFromCache(String phonePre) {
        String key = REDIS_KEY_AREA_PREFIX + phonePre;
        String value = stringRedisTemplate.opsForValue().get(key);
        return value;
    }

    private String formatPhonePre(String phone) {
        return phone.substring(0, 7);
    }

    private boolean isNotPhone(String phone) {
        return StringUtils.isEmpty(phone)
                || "-1".equals(phone)
                || phone.length() < 7
                || !phone.startsWith("1")
                || phone.startsWith("10")
                || phone.startsWith("11")
                || phone.startsWith("12");
    }
}
