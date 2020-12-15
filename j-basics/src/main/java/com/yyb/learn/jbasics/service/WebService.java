package com.yyb.learn.jbasics.service;

import com.yyb.learn.jbasics.dao.WebDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description: 表现层service
 * @author: Mr.Yu
 * @date: 2020-08-14 15:36
 **/
@Service
public class WebService {
    private static final Logger LOG = LoggerFactory.getLogger(WebService.class);

    @Autowired
    private WebDao webDao;

    public String helloWorld() {
        return "HELLO WORLD !";
    }

}
