package com.techcom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.techcom.helper.EmailServiceImpl;
import com.techcom.helper.OTPGenerator;

@Component
public class Mailsenderservie {
	
	 @Autowired
	 private EmailServiceImpl emailService;
	 
	 @Autowired
	 private OTPGenerator otpGenerator;
	
	public String send(String to) {
		String otp = otpGenerator.generateOTP();
		int n= emailService.sendSimpleMail(to, "verification otp", otp);
		if(n>0) return null;
		return otp;
	}

}
