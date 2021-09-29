package com.example.aop.authcheck;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Dorra
 * @date 2021/9/29 16:45
 * @description
 */
@RestController
public class DemoController {

    @PostMapping("/aop/http/alive")
    public String alive() {
        return "服务一切正常";
    }
    @PostMapping("/aop/http/user_info")
    public String callSomeInterface() {
        return "调用了 user_info 接口.";
    }
}
