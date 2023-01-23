package edu.miu.spring.boot.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggerAspect {
    // Match the methods
    @Pointcut("execution( * edu.miu.spring.boot.demo.controller.*.*(..))")
    public void log(){
    }

    // Where to apply aspect
    @AfterReturning("log()")
    public void logAfterReturning(JoinPoint joinPoint){ // matched method
        System.out.println(("======================================================="));
        System.out.println("Log after the method: " + joinPoint.getSignature().getName());
        System.out.println(joinPoint.getKind());
        System.out.println(Arrays.toString(joinPoint.getArgs()));
        System.out.println(joinPoint.getTarget());
        System.out.println(joinPoint.getThis());
        System.out.println(joinPoint.getSourceLocation());
        System.out.println(joinPoint.getClass());
        System.out.println(joinPoint.getStaticPart());
        System.out.println(("======================================================="));
    }
}
