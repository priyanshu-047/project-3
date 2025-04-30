package com.techcom.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.techcom.entity.user;


@Component
public interface dbrepo extends CrudRepository<user, Long>{

	 user findByemail(String email);
	 
}
