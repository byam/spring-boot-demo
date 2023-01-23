package edu.miu.spring.boot.demo.aspect;

import edu.miu.spring.boot.demo.entity.Exception;
import edu.miu.spring.boot.demo.entity.Logger;
import edu.miu.spring.boot.demo.repo.ExceptionRepo;
import edu.miu.spring.boot.demo.repo.LoggerRepo;
import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.security.Principal;
import java.time.LocalDateTime;

@Aspect
@Component
public class LoggerAspect {

    @Autowired
    LoggerRepo loggerRepo;
    @Autowired
    ExceptionRepo exceptionRepo;

    // Match the methods
    @Pointcut("execution( * edu.miu.spring.boot.demo.controller.*.*(..))")
    public void log(){
    }

    // Where to apply aspect
    @Around("log()")
    public Object logAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable { // matched method
        System.out.println(("======================================================="));

        // proceed
        Object result = proceedingJoinPoint.proceed();

        // request info
        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();

        // attributes
        String userName = "staticUser";
        Principal authUser = request.getUserPrincipal();
        if (authUser != null) userName = authUser.getName();
        String operation = String.format("%s.%s",
                proceedingJoinPoint.getSignature().getDeclaringTypeName(),
                proceedingJoinPoint.getSignature().getName());

        // save
        Logger logger = new Logger();
        logger.setTransactionId(request.getHeader("transactionId"));
        logger.setDateTime(LocalDateTime.now()); // current datetime
        logger.setPrinciple(userName);
        logger.setOperation(operation);
        loggerRepo.save(logger);

        System.out.println("Saved Logger to DB: Logger");
        System.out.println(("======================================================="));
        return result;
    }

    @AfterThrowing(pointcut = "log()", throwing = "ex")
    public void logAfterThrowing(Throwable ex){
        System.out.println(("======================================================="));

        // request info
        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder
                .currentRequestAttributes())
                .getRequest();

        // attributes
        String userName = "staticUser";
        Principal authUser = request.getUserPrincipal();
        if (authUser != null) userName = authUser.getName();
        String operation = "";
        String exceptionType = ex.getClass().getName();

        // save
        Exception exception = new Exception();
        exception.setTransactionId(request.getHeader("transactionId"));
        exception.setDateTime(LocalDateTime.now()); // current datetime
        exception.setPrinciple(userName);
        exception.setOperation(operation);
        exception.setExceptionType(exceptionType);
        exceptionRepo.save(exception);

        System.out.println("Saved Logger to DB: Exception");
        System.out.println(("======================================================="));
    }
}
