package com.yyb.learn.jdashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringCloudApplication
@EnableHystrixDashboard
public class JDashboardApp {

    public static void main(String[] args) {
        SpringApplication.run(JDashboardApp.class, args);
    }

}
