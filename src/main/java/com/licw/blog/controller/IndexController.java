package com.licw.blog.controller;

import com.licw.blog.Exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author 123
 */

@Controller
public class IndexController {
    @GetMapping("/")
    public String index(){
        //int a = 9/0;
        String blog = null;
        if(blog == null){
            throw new NotFoundException("博客找不到");
        }
        return "index";
    }
}
