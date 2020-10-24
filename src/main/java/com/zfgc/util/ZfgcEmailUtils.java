package com.zfgc.util;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import it.ozimov.springboot.mail.model.Email;
import it.ozimov.springboot.mail.model.defaultimpl.DefaultEmail;
import it.ozimov.springboot.mail.service.EmailService;

@Component
public class ZfgcEmailUtils{
	
	@Autowired
    private JavaMailSender javaMailSender;
	
	@Value("${spring.mail.username}") String fromEmail;
	
	public void sendEmail(String subject, String body, InternetAddress ... to) throws UnsupportedEncodingException{
		List<InternetAddress> toList = new ArrayList<>();
		CollectionUtils.addAll(toList, to);
		InternetAddress from = new InternetAddress(fromEmail, "ZFGC");
		
		MimeMessage mail = javaMailSender.createMimeMessage();
        MimeMessageHelper helper;
		try {
			helper = new MimeMessageHelper(mail, true);
			helper.setTo(to);
	        helper.setSubject(subject);
	        helper.setText(body, true);
	        helper.setFrom(from);
	        javaMailSender.send(mail);
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
        
        
		
		/*final Email email = DefaultEmail.builder() 
	            .from(from)
	            .to(toList) 
	            .subject(subject)
	            .body(body)
	            
	            .encoding("UTF-8").build();
	        emailService.send(email);*/
	}
}