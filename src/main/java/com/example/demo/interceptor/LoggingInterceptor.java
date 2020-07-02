package com.example.demo.interceptor;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;

@Aspect
@Component
public class LoggingInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(LoggingInterceptor.class);

    @Before(value = "execution(* com.example.demo.controller.UserController.getUsersInternal(..))")
    public void addCommandDetailsToMessage() throws Throwable {
        logger.info("User controller getUsers method called at {}", ZonedDateTime.now(ZoneOffset.UTC));
    }
}