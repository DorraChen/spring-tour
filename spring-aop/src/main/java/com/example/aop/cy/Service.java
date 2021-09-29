package com.example.aop.cy;

import org.springframework.stereotype.Component;

/**
 * @author cy
 * @className Service
 * @description TODO
 * @date 2021/9/27 10:23
 */
@Component
public class Service {

    @LogExecutionTime
    public void server() throws InterruptedException {
//        Thread.sleep(2000);
//        if(AopContext.currentProxy() instanceof Service)
//        {
//            ((Service)AopContext.currentProxy()).doServer(2000);
//        }
        this.doServer(2000);
    }

//    @LogExecutionTime
    public void doServer(long mills) throws InterruptedException {
        Thread.sleep(mills);
    }
}
