package com.zfgc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.zfgc.services.saml.OauthUsersDetailsServiceImpl;

@Component
public class AuthSuccessHandler implements ApplicationListener<AuthenticationSuccessEvent>
{
	@Autowired
	OauthUsersDetailsServiceImpl userDetailsService;

    @Override
    public void onApplicationEvent(AuthenticationSuccessEvent event) 
    {
       
    }
	
}