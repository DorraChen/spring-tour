package com.example.aop.cy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author cy
 * @className ExampleAspect
 * @description TODO
 * @date 2021/9/27 10:20
 */
@Aspect
@Component
public class ExampleAspect {

    private final Logger logger = LoggerFactory.getLogger(ExampleAspect.class);


    @Around("@annotation(com.example.aop.cy.LogExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        final long start = System.currentTimeMillis();

        final Object proceed = joinPoint.proceed();

        final long executionTime = System.currentTimeMillis() - start;

        Object[] args = joinPoint.getArgs();
        Arrays.stream(args).forEach(arg -> logger.info("**** " + arg));

        logger.info("*********** " + joinPoint.getSignature() + " executed in " + executionTime + "ms");

        return proceed;
    }

}
