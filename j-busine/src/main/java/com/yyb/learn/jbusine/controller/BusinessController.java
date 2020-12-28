package com.yyb.learn.jbusine.controller;

import com.alibaba.fastjson.JSONObject;
import com.yyb.learn.jbusine.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 表现层controller
 * @author: Mr.Yu
 * @date: 2020-08-14 15:37
 **/
@RestController
public class BusinessController {

    @Autowired
    private BusinessService businessService;

    /**
     * 根据手机号获取归属地信息
     * @param phone
     * @return
     */
    @RequestMapping(path = "/area/info", method = RequestMethod.GET)
    public JSONObject getAreaInfoFromArea(@RequestParam("phone") String phone) {
        return businessService.getAreaInfoFromArea(phone);
    }

    /**
     * feign fallback demo
     * @param phone
     * @return
     */
    @RequestMapping(path = "/area/demo", method = RequestMethod.GET)
    public JSONObject feignFallBack(@RequestParam("phone") String phone) {
        return businessService.getAreaDemo(phone);
    }

}
