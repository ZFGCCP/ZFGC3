package com.zfgc.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zfgc.model.config.ServerConfig;

@Controller
@RequestMapping(value="/config")
public class ConfigController extends BaseController {

	@RequestMapping(value="", method=RequestMethod.GET, produces="application/json")
	@ResponseBody
	public ResponseEntity getServerSideConfig(){
		ServerConfig config = new ServerConfig();
		
		return ResponseEntity.ok(config);
	}
	
}
