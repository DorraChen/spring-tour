使用注解装配AOP--------- @LogExecutionTime

```java
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface LogExecutionTime {
}

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
```

使用代码如下:

```java
@Component
public class Service {
    public void server() throws InterruptedException {
        doServer(2000);
    }
    
    @LogExecutionTime
    public void doServer(long mills) throws InterruptedException {
        Thread.sleep(mills);
    }
}
```

AOP切入记录日志失效!

解决方案:

- 第一种: 将被调用的方法 doServer 抽出来，重新声明一个类，并且该类交由 Spring 管理控制;
- 第二种: 在server()方法上添加注解;
- 第三种: 使用((Service) AopContext.currentProxy()).doServer(2000); 并在启动类上加上@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)

参考文章:

- [@Transactional失效——同一个类中方法调用导致，解决方案！](https://blog.csdn.net/zhangkaixuan456/article/details/109082645)
- [spring同一个类中，一个方法调用另外一个注解(@Transactional)方法时，注解失效](https://wsk1103.github.io/2018/11/09/spring-%E5%90%8C%E4%B8%80%E4%B8%AA%E7%B1%BB%E4%B8%AD-%E4%B8%80%E4%B8%AA%E6%96%B9%E6%B3%95%E8%B0%83%E7%94%A8%E5%8F%A6%E5%A4%96%E4%B8%80%E4%B8%AA%E6%B3%A8%E8%A7%A3%28@Transactional%29%E6%96%B9%E6%B3%95%E6%97%B6-%E6%B3%A8%E8%A7%A3%E5%A4%B1%E6%95%88/)
- [AopContext.currentProxy()的使用](https://blog.csdn.net/u014788227/article/details/90111662)

