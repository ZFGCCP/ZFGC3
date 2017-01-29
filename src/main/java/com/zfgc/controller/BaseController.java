package com.zfgc.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.zfgc.model.users.Users;

public abstract class BaseController {
	@Autowired
	Users zfgcUser;
}
