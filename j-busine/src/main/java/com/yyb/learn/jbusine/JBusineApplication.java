package com.yyb.learn.jbusine;

import com.yyb.common.annotations.EnableControllerAdvice;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableControllerAdvice
@SpringBootApplication
@EnableFeignClients
//@MapperScan(value = "com.yyb.learn.jbusine.dao")
public class JBusineApplication {

    public static void main(String[] args) {
        SpringApplication.run(JBusineApplication.class, args);
    }

}
