package com.techcom.helper;

import org.springframework.stereotype.Component;
import java.util.Random;

@Component
public class OTPGenerator {
    public  String generateOTP() {
        Random random = new Random();
        return ""+random.nextInt(9000); 
    }
}
