package com.antran.demo.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    // Pointcut to match all methods in CustomerService
    //package com.antran.demo.Service.impl;
    @Pointcut("execution(*  com.antran.demo.Service.CustomerService.*(..))")
    public void customerServiceMethods() {

    }

    // Before advice to log before method execution
    @Before("customerServiceMethods()")
    public void logBefore(JoinPoint joinPoint) {
        logger.info("Method execution started: " + joinPoint.getSignature().toShortString());
        logger.info("Arguments: " + Arrays.toString(joinPoint.getArgs()));
    }

    // After returning advice to log after successful method execution
    @AfterReturning(pointcut = "customerServiceMethods()", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        logger.info("Method executed successfully: " + joinPoint.getSignature().toShortString() + "User:" );
        logger.info("Return value: " + result);
    }

    // After throwing advice to log when a method throws an exception
    @AfterThrowing(pointcut = "customerServiceMethods()", throwing = "error")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {
        logger.error("Method execution failed: " + joinPoint.getSignature().toShortString());
        logger.error("Exception: " + error.getMessage());
    }
}
