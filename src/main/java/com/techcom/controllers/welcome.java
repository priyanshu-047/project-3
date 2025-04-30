package com.techcom.controllers;

import java.io.IOException;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.techcom.entity.user;
import com.techcom.service.serviceprovider;

import jakarta.servlet.http.HttpSession;





@Controller
public class welcome {
	
	

	@Autowired
	private serviceprovider serviceprovider;
	
	 @GetMapping("/user/lessionpage")
	    public String addLesson() {
	        return "lession.html";
	    }
	@GetMapping("/")
	public String indexpage() {
		return "index";
	}
	
	
	@GetMapping("/about")
	public String about() {
		return "about";
	}
	
	 
	
       @GetMapping("/user/dashboard")
		public String userdashboard(Principal principal, Model model,HttpSession session) throws IOException {
    	   user user = serviceprovider.getdata(principal.getName());
    	   model.addAttribute("user", user);
    	   session.setAttribute("user", user);
    	   model.addAttribute("absolutePath", new ClassPathResource("static/uploads").getFile().getAbsolutePath());
    	   System.out.println(session.getAttribute("user").toString());
			if (user.getRole().equals("TEACHER")) 
				model.addAttribute("check",true);
			 else 
					model.addAttribute("check", false);
				System.out.println(user.getRole());
				System.out.println(principal.getName());
				return "userdashboard";
			}

			@PostMapping("/user/dashboard")
			public String userdashboard2(Principal principal, Model model,HttpSession session) {
				user user = serviceprovider.getdata(principal.getName());
				model.addAttribute("user", user);
				session.setAttribute("user", user);
		    	   System.out.println(session.getAttribute("user").toString());

				if (user.getRole().equals("TEACHER"))
			System.out.println(principal.getName());
    	     return "userdashboard";
            }
       
       @GetMapping("/user/dashboard/addcource")
       public String userprofile(Principal principal, Model model) {
    	   user user = serviceprovider.getdata(principal.getName());
    	   model.addAttribute("user", user);
    	   System.out.println(principal.getName());
    	   return "profile";
    	            }
       
       @GetMapping("/user/dashboard/courses")
       public String  courcString(Model model) {
    	   return "courses";
       }
       
       @GetMapping("/user/courcepage")
		public String courcepage() {
			return "addcource";
		}
       
		@GetMapping("/user/dashboard/faq")
		public String faq() {
			return "faq";
		}

		@GetMapping("/user/dashboard/contact")
		public String contact() {
			return "contact";
		}

		@GetMapping("/user/dashboard/logout")
		public String logout(HttpSession session) {
			session.invalidate();
			return "redirect:/";
		}

		
	
}
