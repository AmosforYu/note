package com.yyb.learn.jarea.controller;

import com.alibaba.fastjson.JSONObject;
import com.yyb.common.dtos.error.Error;
import com.yyb.common.dtos.error.MyException;
import com.yyb.learn.jarea.service.AreaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * @author Yamos
 * @description AreaController
 * @date 2020/12/24 0024 14:47
 */
@RestController
public class AreaController {

    private static final Logger LOG = LoggerFactory.getLogger(AreaController.class);

    @Autowired
    private AreaService areaService;

    private static final long TIME_OUT = 10 * 1000L;

    private <T> DeferredResult<T> getDeferredResultWithTimeout() {
        final DeferredResult<T> deferredResult = new DeferredResult<>(TIME_OUT);
        deferredResult.onTimeout(new Runnable() {
            @Override
            public void run() {
                LOG.error("deferredResult timeout: {}s", TIME_OUT);
                deferredResult.setErrorResult(new MyException(Error.PARAM_ERROR, "请求超时，请重试"));
            }
        });
        return deferredResult;
    }

    /**
     * 根据手机号获取归属地信息
     * @param phone
     * @return
     */
    @RequestMapping(value ="/phone/area", method = RequestMethod.GET)
    public DeferredResult<JSONObject> getAreaInfoByPhone(@RequestParam("phone") String phone) {
        LOG.info("[{}] Enter get area info by phone ", phone);

        final DeferredResult<JSONObject> deferredResult = getDeferredResultWithTimeout();

        areaService.getAreaInfoByPhone(deferredResult, phone);

        return deferredResult;
    }


}
