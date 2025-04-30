package com.techcom.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.techcom.entity.Course;

@Component
public interface courserepo extends CrudRepository<Course, Long> {
    
	public List<Course> findByTitleContainingIgnoreCase(String title);
	
	public List<Course> findByprice(int price);
	
	public Course findByid(int id);
	
}
