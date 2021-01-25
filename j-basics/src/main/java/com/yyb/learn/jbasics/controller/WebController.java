package com.yyb.learn.jbasics.controller;

import com.alibaba.fastjson.JSONObject;
import com.yyb.common.dtos.error.Error;
import com.yyb.common.dtos.error.MyException;
import com.yyb.learn.jbasics.service.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 表现层controller
 * @author: Mr.Yu
 * @date: 2020-08-14 15:37
 **/
@RestController
public class WebController {

    @Autowired
    private WebService webService;

    @RequestMapping(path = "/hello", method = RequestMethod.GET)
    public String helloWorld() {
        return webService.helloWorld();
    }

    @RequestMapping(path = "/myException", method = RequestMethod.POST)
    public String throwMyException() throws MyException {
        throw new MyException(Error.ALREADY_UPD, "controller 抛出异常，controller层错误类型是ALREADY_UPD");
    }

    @RequestMapping(path = "/paramException", method = RequestMethod.GET)
    public Integer throwParamException(@RequestParam("wrongParam") Integer param,
                                       @RequestParam(value = "xxx") Integer xxx) {
        return param + xxx;
    }

    @RequestMapping(path = "/basicsHealth", method = RequestMethod.GET)
    public Map<Object, Object> basicsHealth(@RequestParam("errorNum") Integer errorNum,
                  @RequestParam(value = "version", required = false) String version) {
        Map<Object, Object> map = new HashMap<>();
        map.put("errorNum", errorNum);

        if (version != null && !"".equals(version)) {
            map.put("version", version);
        }
        return map;
    }

    @RequestMapping(value = "/getAreaInfo/phonePre", method = RequestMethod.GET)
    public Map<String, String> getAreaInfoByPhonePre(@RequestParam("phone") String phone) {
        return webService.getAreaInfoByPhonePre(phone);
    }

    /**
     * feign fallback demo
     * @param phone
     * @return
     */
    @RequestMapping(path = "/area/demo", method = RequestMethod.GET)
    public JSONObject feignFallBack(@RequestParam("phone") String phone) {
        return webService.getAreaDemo(phone);
    }


}
