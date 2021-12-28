package com.trkj.balance.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 *
 * 跨域配置类
 */
@Configuration
@Slf4j
public class AppCorsConfiguration {
    private CorsConfiguration buildConfig() {
        log.debug("开始设置");
        CorsConfiguration appCorsConfiguration = new CorsConfiguration();
        appCorsConfiguration.addAllowedOrigin("http://localhost:3000");
        appCorsConfiguration.addAllowedOrigin("http://127.0.0.1:3000");
        appCorsConfiguration.addAllowedHeader("*"); // 2允许任何头
        appCorsConfiguration.addAllowedMethod("OPTIONS");
        appCorsConfiguration.addAllowedMethod("HEAD");
        appCorsConfiguration.addAllowedMethod("GET");
        appCorsConfiguration.addAllowedMethod("PUT");
        appCorsConfiguration.addAllowedMethod("POST");
        appCorsConfiguration.addAllowedMethod("DELETE");
        appCorsConfiguration.addAllowedMethod("PATCH");
        appCorsConfiguration.setAllowCredentials(true);//这两句不加不能跨域上传文件，
        appCorsConfiguration.setMaxAge(60L);//加上去就可
        return appCorsConfiguration;
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", buildConfig()); // 4
        return new CorsFilter(source);
    }
}