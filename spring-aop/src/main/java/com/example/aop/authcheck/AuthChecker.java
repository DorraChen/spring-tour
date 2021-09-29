package com.example.aop.authcheck;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author dorra
 * @date 2021/9/29 16:22
 * @description 自定义注解用于接口鉴权(只是为了学习aop才这样做的,鉴权不一定是通过aop实现)
 */
@Target(ElementType.METHOD)  // 注解的作用目标:方法
@Retention(RetentionPolicy.RUNTIME) // 注解会在class字节码中存在,在运行时可以通过反射获取到
public @interface AuthChecker {
}
