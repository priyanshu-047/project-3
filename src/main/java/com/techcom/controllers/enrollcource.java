package com.techcom.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.mysql.cj.Session;
import com.techcom.entity.Course;
import com.techcom.entity.user;
import com.techcom.repo.courserepo;
import com.techcom.repo.dbrepo;

import jakarta.servlet.http.HttpSession;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class enrollcource {
	
	@Autowired
	private dbrepo dbrepo;
	
	@Autowired
	private courserepo courserepo;
	
	@GetMapping("/user/enroll/{courseId}")
	public ResponseEntity<String> getMethodName(@PathVariable long courseId  , HttpSession session) {
		System.out.println("enroll course");
		System.out.println(courseId);
		user user = (user) session.getAttribute("user");
		System.out.println("session user :"+user.toString());
		Course course = courserepo.findById(courseId).orElse(null);
		System.out.println(course.toString());
	    List<Course> courses = user.getCourses();
			if (!courses.contains(course)) {
				courses.add(course);
				user.setCourses(courses);
				System.out.println("after adding course" +user.toString());
				List<user> users = course.getUsers();
				users.add(user);
	            course.setUsers(users);
	        	courserepo.save(course);
				dbrepo.save(user);
			
				
				System.out.println(dbrepo.findByemail(user.getEmail()).toString());
				return new  ResponseEntity<String>("sucess",HttpStatus.OK) ;
			}
			else {
				return new ResponseEntity<String>("already enrolled", HttpStatus.OK);
			}
	}
	
	

}
