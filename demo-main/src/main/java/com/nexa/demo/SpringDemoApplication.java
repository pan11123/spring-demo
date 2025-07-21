package com.nexa.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: nexa
 * @Date: 2025/6/29 14:19
 */
@SpringBootApplication
@MapperScan("com.nexa.demo.mapper")
public class SpringDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringDemoApplication.class, args);
        System.out.println("项目启动成功");
    }
}
