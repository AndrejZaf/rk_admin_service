package com.rarekickz.rk_admin_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class RkAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(RkAdminApplication.class, args);
    }

}
