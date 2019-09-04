package com.zfgc.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zfgc.services.users.UsersService;

/**
 * TODO REMOVE ME
 * @author Christopher
 *
 */
@RestController
class GreetingController {

	@Autowired
	UsersService usersService;
	
    @RequestMapping("/hello/{name}")
    String hello(@PathVariable String name) {
        return "Hello, " + name + "!";
    }
} 