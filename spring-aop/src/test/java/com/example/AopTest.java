package com.example;

import com.example.aop.cy.Service;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author dorra
 * @date 2021/9/27 11:26
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MainApplication.class)
public class AopTest {
    @Autowired
    private Service service;
    @Test
    public void aopTest() throws InterruptedException {
        service.server();
    }
}
