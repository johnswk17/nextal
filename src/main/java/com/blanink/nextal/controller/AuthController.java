package com.blanink.nextal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AuthController {

    private final RestTemplate restTemplate = new RestTemplate();

    // 每10分钟执行一次 (cron = "0 */10 * * * ?")
    @Scheduled(cron = "0 */10 * * * ?")
    public void checkApiStatus() {
        String apiUrl = "http://your-api-endpoint/check"; // 请替换为您的API地址
        try {
            String result = restTemplate.getForObject(apiUrl, String.class);
            if ("0".equals(result)) {
                System.out.println("API astatus is 0, shutting down application...");
                System.exit(0);
            } else {
                System.out.println("API status is 1, application continues to run.");
            }
        } catch (Exception e) {
            System.err.println("Error calling API: " + e.getMessage());
            // 根据您的需求，您可能希望在API调用失败时也关闭应用程序
            // System.exit(1);
        }
    }
}