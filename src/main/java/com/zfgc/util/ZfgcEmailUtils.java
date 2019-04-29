package com.zfgc.util;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.mail.internet.InternetAddress;

import org.apache.commons.collections.CollectionUtils;
import org.assertj.core.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import it.ozimov.springboot.mail.model.Email;
import it.ozimov.springboot.mail.model.defaultimpl.DefaultEmail;
import it.ozimov.springboot.mail.service.EmailService;

@Component
public class ZfgcEmailUtils{
	@Autowired
	private EmailService emailService;
	
	@Value("${spring.mail.username}") String fromEmail;
	public void testSendEmail() throws UnsupportedEncodingException { 

        List<InternetAddress> address = new ArrayList<>();
        address.add(new InternetAddress(
                "onisephiroth@gmail.com", "zfgc"));
        final Email email = DefaultEmail.builder() 
            .from(new InternetAddress(fromEmail, "From Name"))
            .to(address) 
            .subject("Testing email")
            .body("Testing body ...")
            .encoding("UTF-8").build();
        emailService.send(email); 
    }
	
	public void sendEmail(String subject, String body, InternetAddress ... to) throws UnsupportedEncodingException{
		List<InternetAddress> toList = new ArrayList<>();
		CollectionUtils.addAll(toList, to);
		InternetAddress from = new InternetAddress(fromEmail, "ZFGC");
		
		final Email email = DefaultEmail.builder() 
	            .from(from)
	            .to(toList) 
	            .subject(subject)
	            .body(body)
	            .encoding("UTF-8").build();
	        emailService.send(email); 
	}
}