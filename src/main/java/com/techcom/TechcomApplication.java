package com.techcom;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.techcom.entity.Course;
import com.techcom.entity.lessons;
import com.techcom.entity.user;
import com.techcom.helper.EmailServiceImpl;
import com.techcom.repo.courserepo;
import com.techcom.repo.lessonrepo;

@SpringBootApplication
public class TechcomApplication implements CommandLineRunner{

	@Autowired
	private courserepo courserepo;
	
	@Autowired
	private EmailServiceImpl emailServiceImpl;
	
	public courserepo getCourserepo() {
		return courserepo;
	}

	public void setCourserepo(courserepo courserepo) {
		this.courserepo = courserepo;
	}

	public lessonrepo getLessonrepo() {
		return lessonrepo;
	}

	public void setLessonrepo(lessonrepo lessonrepo) {
		this.lessonrepo = lessonrepo;
	}

	@Autowired
	private lessonrepo lessonrepo;
	public static void main(String[] args) {
		SpringApplication.run(TechcomApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		Course c1=new Course();
//		c1.setDescription("this is java course");
//		c1.setPrice(4000);
//		c1.setTitle("web developer");
//		
//		
//		user u1=new user();
//		List<Course> c=new ArrayList<>();
//		c.add(c1);
//		u1.setBio("teacher");
//		u1.setEmail("thakur00000@gmail.com");
//		u1.setName("rahul");
//		u1.setPassword("1256");
//		u1.setProfilePicture("hy");
//		u1.setRole("teacher");
//		u1.setUsername("@rahul");
//		u1.setCourses(c);
//		List<user> u=new ArrayList<>();
//		u.add(u1);
//		c1.setUsers(u);
//		
//		
//		lessons lessons= new lessons();
//		lessons.setContent("hiiiiii");
//		lessons.setCourse(c1);
//		lessons.setTitle("lecture 1");
//		lessonrepo.save(lessons);
//		List<lessons> lessons2=new ArrayList<>();
//		c1.setLessons(lessons2);
//		courserepo.save(c1);
//		emailServiceImpl.sendSimpleMail("thakurpriyanshusingh44@gmail.com", "tester", "hy msg");
		
	}

	public EmailServiceImpl getEmailServiceImpl() {
		return emailServiceImpl;
	}

	public void setEmailServiceImpl(EmailServiceImpl emailServiceImpl) {
		this.emailServiceImpl = emailServiceImpl;
	}

}
