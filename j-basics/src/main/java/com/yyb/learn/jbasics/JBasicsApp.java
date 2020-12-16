package com.yyb.learn.jbasics;

import com.yyb.common.annotations.EnableControllerAdvice;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableControllerAdvice //第二种其他服务模块实现子模块全局处理异常方式,在其他模块启动类添加该注解
@SpringBootApplication
public class JBasicsApp {

    public static void main(String[] args) {
        SpringApplication.run(JBasicsApp.class, args);
    }
}
