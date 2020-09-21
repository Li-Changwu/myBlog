package com.licw.blog.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Pointcut("execution(* com.licw.blog.controller.*.*(..))")
    public void log(){}

    @Before(value = "log()")
    public void doBefore(){
        logger.info("___________________________doBefore____________________");
    }
    @After("log()")
    public void doAfter(){
        logger.info("_______________doAfter___________________");
    }
}
