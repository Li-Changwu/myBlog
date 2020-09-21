package com.licw.blog.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;


@ControllerAdvice
public class ControllerExceptionHandler {

    private final Logger logger =  LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(Exception.class)
    public ModelAndView exceptionHandler(HttpServletRequest request, Exception e) throws Exception {

        String url = request.getRequestURL().toString();
        logger.error("Request URL:{}, Exception:{}",url,e);
        //如果是标有ResponseStatus的异常直接抛出，会跳转到相应页面
        if(AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null){
            throw e;
        }
        ModelAndView mv = new ModelAndView();
        mv.addObject("url",url);
        mv.addObject("exception",e);
        mv.setViewName("error/error");

        return mv;
    }
}
