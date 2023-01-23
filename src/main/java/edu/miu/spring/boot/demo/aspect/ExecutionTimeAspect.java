package edu.miu.spring.boot.demo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExecutionTimeAspect {
    @Pointcut("@annotation(edu.miu.spring.boot.demo.aspect.annotation.ExecutionTime)")
    public void executionTimeAnnotation(){
    }

    @Around("executionTimeAnnotation()")
    public Object executionTimeAnnotationAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println(("======================================================="));
        long start = System.nanoTime();
        var result = proceedingJoinPoint.proceed();
        long finish = System.nanoTime();
        System.out.println(proceedingJoinPoint.getSignature().getName() + " takes ns: " + (finish - start));
        System.out.println(("======================================================="));
        return result;
    }
}
