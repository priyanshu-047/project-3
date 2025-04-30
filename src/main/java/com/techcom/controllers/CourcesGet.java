package com.techcom.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.techcom.entity.Course;
import com.techcom.repo.courserepo;
import com.techcom.service.serviceprovider;


@RestController
public class CourcesGet {
	
	
	@Autowired
	private serviceprovider serviceprovider;
	
	@GetMapping("user/getallcourse")
	public ResponseEntity<List<Course>> getCourses() {
		List<Course> courses = serviceprovider.getcourse();
		if (courses.isEmpty()) return null;
		return new ResponseEntity<List<Course>>(courses, HttpStatus.OK) ;
	}
	
	@GetMapping("user/getbyname/{name}")
	public ResponseEntity<List<Course>> getCourses1(@PathVariable("name") String name) {
		List<Course> courses = serviceprovider.getspecifiCoursecource(name);
		if (courses.isEmpty()) return null;
		return new ResponseEntity<List<Course>>(courses, HttpStatus.OK) ;
	}
	
	@GetMapping("user/getbyId/{id}")
	public ResponseEntity<List<Course>> getCourses2(@PathVariable("id") int price) {
		List<Course> courses = serviceprovider.getbyprice(price);
		if (courses.isEmpty()) return null;
		return new ResponseEntity<List<Course>>(courses, HttpStatus.OK);
	}

}
