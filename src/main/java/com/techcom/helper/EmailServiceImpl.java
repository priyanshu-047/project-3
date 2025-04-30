package com.techcom.helper;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceImpl {
	@Autowired 
	private JavaMailSender javaMailSender;
	public int sendSimpleMail(String to,String subjString,String body)
    {
        try {
         
            SimpleMailMessage mailMessage
                = new SimpleMailMessage();

            mailMessage.setTo(to);
            mailMessage.setFrom("*****************");
            mailMessage.setText(body);
            mailMessage.setSubject(subjString);
            javaMailSender.send(mailMessage);
            return 0;
        }catch (Exception e) {
        	System.out.println(e.getLocalizedMessage());
            return 1;
        }
}
}
