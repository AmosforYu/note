package com.yyb.learn.jbasic.service;

import com.yyb.learn.jbasic.dao.WebDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description: 表现层service
 * @author: Mr.Yu
 * @date: 2020-08-14 15:36
 **/
@Service
public class WebService {
    @Autowired
    private WebDao webDao;
}
