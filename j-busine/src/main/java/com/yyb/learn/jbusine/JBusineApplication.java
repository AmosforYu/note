package com.yyb.learn.jbusine;

import com.yyb.common.annotations.EnableControllerAdvice;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableControllerAdvice
@SpringBootApplication
@EnableFeignClients
public class JBusineApplication {

    public static void main(String[] args) {
        SpringApplication.run(JBusineApplication.class, args);
    }

    /**
     * Feign调用服务时修改负载均衡策略方法①
     */
//    @Bean
//    public IRule getRule() {
//        return new BestAvailableRule();
//    }

}
