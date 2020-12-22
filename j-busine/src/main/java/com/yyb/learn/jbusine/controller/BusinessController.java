package com.yyb.learn.jbusine.controller;

import com.yyb.learn.jbusine.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @description: 表现层controller
 * @author: Mr.Yu
 * @date: 2020-08-14 15:37
 **/
@RestController
public class BusinessController {

    @Autowired
    private BusinessService businessService;

    @RequestMapping(path = "/health", method = RequestMethod.GET)
    public String health() {
        return "OK";
    }

    @RequestMapping(path = "/getHealthInfo", method = RequestMethod.GET)
    public Map<Object, Object> helloWorld(@RequestParam("errorNum") Integer errorNum,
                                          @RequestParam(value = "version", required = false) String version) {
        return businessService.getHealthInfoFromBasics(errorNum, version);
    }

}
