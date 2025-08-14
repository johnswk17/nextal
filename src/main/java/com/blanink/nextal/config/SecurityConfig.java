package com.blanink.nextal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            // 启用并配置CORS
            .cors(cors -> cors.configurationSource(corsConfigurationSource()))
            // 禁用CSRF
            .csrf(csrf -> csrf.disable())
            // 配置授权规则
            .authorizeHttpRequests(authorize -> authorize
                // 对所有请求都无条件允许
                .anyRequest().permitAll()
            )
            // 配置头部信息
            .headers(headers -> headers
                .frameOptions(frameOptions -> frameOptions.sameOrigin()) // 允许同源下的 frame
                .contentSecurityPolicy(csp -> csp
                    .policyDirectives("script-src 'self' 'unsafe-inline' 'unsafe-eval'; style-src 'self' 'unsafe-inline' https://cdn.bootcdn.net; font-src 'self' https://cdn.bootcdn.net; connect-src 'self' http://192.168.0.168:8080; default-src 'self'")
                )
            );

        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:8080", "http://192.168.0.168:8080")); // 允许的源
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS")); // 允许的方法
        configuration.setAllowedHeaders(Arrays.asList("*")); // 允许所有头
        configuration.setAllowCredentials(true); // 允许凭证

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration); // 对所有路径应用这个配置
        return source;
    }
}