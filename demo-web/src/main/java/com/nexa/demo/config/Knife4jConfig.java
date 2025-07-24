package com.nexa.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Knife4j配置类
 * 用于配置API文档的基本信息和分组
 *
 * @Author: Nexa
 * @Date: 2025/7/21
 */
@Configuration
public class Knife4jConfig {

    /**
     * 配置OpenAPI基本信息
     */
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Spring Demo API文档")
                        .description("基于Spring Boot 3.x + MyBatis + Sa-Token的演示项目API文档")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Nexa")
                                .email("3269406098@qq.com")
                                .url("https://github.com/pan11123/spring-demo"))
                        .license(new License()
                                .name("MIT License")
                                .url("https://opensource.org/licenses/MIT")));
    }
}
