package com.example;

import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author dorra
 * @date 2021/9/29 16:50
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MainApplication.class)
@AutoConfigureMockMvc
public class AuthCheckTest {
}
