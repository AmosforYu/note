package com.yyb.learn.jgateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Yamos
 * @description TokenFilter
 * @date 2021/1/29 0029 17:13
 */
@Component
public class TokenFilter extends ZuulFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(TokenFilter.class);
    @Override
    public boolean shouldFilter() {
        boolean shouldFilter = true;
        return shouldFilter;
    }

    @Override
    public String filterType() {
        //过滤器的类型，它决定过滤器在请求的哪个生命周期中执行。这里定义为pre，表示在请求被路由之前执行。
        return "pre";
    }

    @Override
    public int filterOrder() {
        //过滤器的顺序。当请求在一个阶段中存在多个过滤器时，需要根据该方法返回的值来依次执行。
        return 0;
    }

    @Override
    public Object run() {
        //todo: 过滤逻辑实现
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        LOGGER.info("[TokenFilter] send {} request to {}", request.getMethod(), request.getRequestURL().toString());

        Object accessToken = request.getParameter("accessToken");
        if(accessToken == null) {
            LOGGER.warn("[TokenFilter]  access token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(333);
            return null;
        }
        LOGGER.info("[TokenFilter]  access token ok");

        return null;
    }
}
