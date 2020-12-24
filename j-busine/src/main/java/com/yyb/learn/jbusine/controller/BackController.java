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
 * @date: 2020-12-22 17:27
 **/
@RestController
public class BackController {

    @RequestMapping(path = "/health", method = RequestMethod.GET)
    public String health() {
        return "<h1>OK</h1>";
    }

    @RequestMapping(path = "/error", method = RequestMethod.GET)
    public String error() {
        return "[error]";
    }


}
