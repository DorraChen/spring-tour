package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.servlet.http.Cookie;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author dorra
 * @date 2021/9/29 16:50
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MainApplication.class)
@AutoConfigureMockMvc
public class AuthCheckTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void test() throws Exception {
        MockHttpServletRequestBuilder mockMvcRequestBuilders = MockMvcRequestBuilders
                .post("/aop/http/user_info")
                .cookie(new Cookie("user_token", "123456"));
        mockMvc.perform(mockMvcRequestBuilders)
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }
}
