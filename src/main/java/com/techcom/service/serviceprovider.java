package com.techcom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.techcom.entity.Course;
import com.techcom.entity.user;
import com.techcom.repo.courserepo;
import com.techcom.repo.dbrepo;

@Component
public class serviceprovider {

	@Autowired
	private dbrepo dbrepo;
	
	@Autowired
	private courserepo crepo;
	

	public Course addcourse(Course course) {
	 Course course2=	crepo.save(course);
	 return course2;

	}
	
	public user getdata(String email) {
        return dbrepo.findByemail(email);
		
	}
	
	public user updateUser(user user) {
		user user2 = dbrepo.save(user);
		return user2;
	}
	
	public void adduser(user user) {
		dbrepo.save(user);

	}
	
	public  List<Course> getcourse() {
	 List<Course> courses= 	(List<Course>) crepo.findAll();
	 return courses;

	}
	

	public List<Course> getcourse(Course course) {
		return (List<Course>) crepo.findAll();

	}
	
	public List<Course> getspecifiCoursecource(String name) {
		return crepo.findByTitleContainingIgnoreCase(name);

	}
	
	public List<Course> getbyprice(int id) {
		return crepo.findByprice(id);

	}
	
	public user getuser(String email) {
		user user = dbrepo.findByemail(email);
        return user;
	}
}
