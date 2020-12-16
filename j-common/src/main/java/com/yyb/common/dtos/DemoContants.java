package com.yyb.common.dtos;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @description: demo
 * @author: Mr.Yu
 * @date: 2020-07-27 18:05
 **/
@Configuration
@PropertySource(value = {"classpath:DemoContants.properties"})
public class DemoContants {

    @Value("${demo.name}")
    public String demoName;

    @Value("${demo.age}")
    public String demoAge;

    @Value("${demo.sex}")
    public String demoSex;

    @Value("${test.name}")
    public String testName;

    @Value("${test.age}")
    public String testAge;

    @Value("${test.sex}")
    public String testSex;

}
