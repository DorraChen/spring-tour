package com.example.aop.cy;

import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author cy
 * @className Service
 * @description TODO
 * @date 2021/9/27 10:23
 */
@Component
public class Service {
    @Autowired
    private ServiceB serviceB;

    //    @LogExecutionTime
    public void server() throws InterruptedException {
            ((Service) AopContext.currentProxy()).doServer(2000);
//        this.doServer(2000);
    }

    @LogExecutionTime
    public void doServer(long mills) throws InterruptedException {
        Thread.sleep(mills);
    }

    public void serverB() throws InterruptedException {
        serviceB.doServer(2000);
    }
}
