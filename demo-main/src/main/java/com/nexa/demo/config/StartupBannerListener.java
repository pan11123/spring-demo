package com.nexa.demo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 应用启动完成后的 Banner 输出监听器
 *
 * @Author: Nexa
 * @Date: 2025/7/23 17:37
 */
@Component
public class StartupBannerListener {

    private static final Logger log = LoggerFactory.getLogger(StartupBannerListener.class);

    @EventListener
    public void onApplicationReady(ApplicationReadyEvent event) {
        Environment env = event.getApplicationContext().getEnvironment();
        String port = env.getProperty("server.port", "8080");
        String contextPath = env.getProperty("server.servlet.context-path", "");

        printNexaBanner(port, contextPath);
    }

    private void printNexaBanner(String port, String contextPath) {
        String banner = generateNexaBanner(port, contextPath);
        // 输出到控制台
        System.out.println(banner);
    }

    private String generateNexaBanner(String port, String contextPath) {
        StringBuilder banner = new StringBuilder();

        String baseUrl = "http://localhost:" + port + contextPath;

        banner.append("\n");
        banner.append("███╗   ██╗███████╗██╗  ██╗ █████╗ \n");
        banner.append("████╗  ██║██╔════╝╚██╗██╔╝██╔══██╗\n");
        banner.append("██╔██╗ ██║█████╗   ╚███╔╝ ███████║\n");
        banner.append("██║╚██╗██║██╔══╝   ██╔██╗ ██╔══██║\n");
        banner.append("██║ ╚████║███████╗██╔╝ ██╗██║  ██║\n");
        banner.append("╚═╝  ╚═══╝╚══════╝╚═╝  ╚═╝╚═╝  ╚═╝\n");
        banner.append("\n");
        banner.append("📖 Knife4j API文档: ").append(baseUrl).append("/doc.html\n");
        banner.append("📋 Swagger UI:      ").append(baseUrl).append("/swagger-ui.html\n");
        banner.append("📄 OpenAPI JSON:    ").append(baseUrl).append("/v3/api-docs\n");
        banner.append("\n");

        return banner.toString();
    }

}
