package com.yyb.learn.jbasics.controller;

import com.yyb.learn.jbasics.service.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
        return "HELLO WORLD !";
    }
}
