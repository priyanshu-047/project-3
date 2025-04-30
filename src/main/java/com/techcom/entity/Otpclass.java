package com.techcom.entity;

import org.springframework.stereotype.Component;

@Component
public class Otpclass {
       private String otpString;

	public String getOtpString() {
		return otpString;
	}

	public void setOtpString(String otpString) {
		this.otpString = otpString;
	}
       
}
