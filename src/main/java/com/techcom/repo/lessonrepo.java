package com.techcom.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.techcom.entity.lessons;

@Component
public interface lessonrepo extends CrudRepository<lessons, Long> {

}
