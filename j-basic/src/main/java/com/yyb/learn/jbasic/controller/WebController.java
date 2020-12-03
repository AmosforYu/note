package com.yyb.learn.jbasic.controller;

import com.yyb.learn.jbasic.service.WebService;
import org.springframework.beans.factory.annotation.Autowired;
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
}
