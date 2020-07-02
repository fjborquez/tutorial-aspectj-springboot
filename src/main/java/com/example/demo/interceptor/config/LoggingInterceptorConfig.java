package com.example.demo.interceptor.config;

import com.example.demo.interceptor.LoggingInterceptor;
import org.aspectj.lang.Aspects;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoggingInterceptorConfig {

    @Bean
    public LoggingInterceptor getAutowireCapableLoggingInterceptor() {
        return Aspects.aspectOf(LoggingInterceptor.class);
    }
}