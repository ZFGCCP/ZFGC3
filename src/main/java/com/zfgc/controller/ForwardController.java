package com.zfgc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ForwardController{

	//ignore paths starting with /ws - websockets should not pass through here
    @RequestMapping(value = "/{^(ws)**}/{[path:[^\\.]*}")
    public String redirect() {
        // Forward to home page so that route is preserved.
        return "forward:/";
    }
} 