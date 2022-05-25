package com.example.springspel;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

/**
 * @author dorra
 * @date 2022/5/25 11:29
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringSpelApplication.class)
public class WorkersHolderTests {
    @Autowired
    private WorkersHolder workersHolder;
    @Test
    public void workersHolderTest() {
        workersHolder.getWorkers().forEach(System.out::println);
        System.out.println("==============================");
        Optional.ofNullable(workersHolder.getFirstWorker()).ifPresent(System.out::println);
        Optional.ofNullable(workersHolder.getLastWorker()).ifPresent(System.out::println);
        Optional.ofNullable(workersHolder.getGeorgeSalary()).ifPresent(System.out::println);
    }
}
