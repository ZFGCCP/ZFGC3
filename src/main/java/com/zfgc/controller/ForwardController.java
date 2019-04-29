package com.zfgc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ForwardController{
	
    @RequestMapping(value = "/zfgcui/**/{path:[^\\.]*}")
    public String redirect(@PathVariable("path") String path) {
        // Forward to home page so that route is preserved.
        return "forward:/";
    }
} 