package com.yyb.learn.jbasics.controller;

import com.yyb.common.dtos.error.Error;
import com.yyb.common.dtos.error.MyException;
import com.yyb.learn.jbasics.service.WebService;
import org.apache.ibatis.annotations.Param;
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
}
