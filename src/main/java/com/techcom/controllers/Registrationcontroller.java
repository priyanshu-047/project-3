package com.techcom.controllers;

import com.techcom.entity.Otpclass;
import com.techcom.entity.emailerholder;
import com.techcom.entity.user;
import com.techcom.service.Mailsenderservie;
import com.techcom.service.serviceprovider;

import jakarta.servlet.http.HttpSession;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class Registrationcontroller {

    @Autowired
    private Otpclass otpclass;

    @Autowired
    private serviceprovider serviceservices;

  
    @Autowired
    private Mailsenderservie mailsenderservie;

    @GetMapping("/registration")
    public String redirect() {
        return "verification";
    }

    @PostMapping("/verification")
    @ResponseBody
    public ResponseEntity<Otpclass> postMethodName(@RequestBody emailerholder obj, HttpSession session) {
        System.out.println(obj.getEmail());
        String otpString = mailsenderservie.send(obj.getEmail());
        otpclass.setOtpString(otpString);
        session.setAttribute("user", "old");
        if (otpString == null) {
            return new ResponseEntity<>(otpclass, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(otpclass, HttpStatus.OK);
    }

    @PostMapping("/Adduser")
    public String Adduser(@RequestParam("email") String email,
                          @RequestParam("username") String username,
                          @RequestParam("password") String password,
                          @RequestParam("role") String role,
                          @RequestParam("name") String name,
                          @RequestParam("bio") String bio,
                          @RequestParam("profilePicture") MultipartFile profilePicture,
                          HttpSession session) {
    user user =new user();
      
            user.setEmail(email);
            user.setUsername(username);
            user.setPassword("{noop}" + password);
            user.setRole(role);
            user.setName(name);
            user.setBio(bio);

            if (!profilePicture.isEmpty()) {
                try {
                	String pathString = new ClassPathResource("static/uploads").getFile().getAbsolutePath();
                    File destinationFile = new File(pathString + File.separator + profilePicture.getOriginalFilename());
                    profilePicture.transferTo(destinationFile);
                    user.setProfilePicture(profilePicture.getOriginalFilename());
                } catch (IOException e) {
                    System.out.println(e.getLocalizedMessage());
                    return "verification";
                }
            }

            user.setCourses(null);
         
            serviceservices.adduser(user);
        
        return "susess";
    }
}
