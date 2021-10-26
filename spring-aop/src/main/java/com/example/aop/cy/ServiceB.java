package com.example.aop.cy;

import org.springframework.stereotype.Component;

/**
 * @author cy
 * @className Service
 * @description TODO
 * @date 2021/9/27 10:23
 */
@Component
public class ServiceB {
    @LogExecutionTime
    public void doServer(long mills) throws InterruptedException {
        Thread.sleep(mills);
    }
}
