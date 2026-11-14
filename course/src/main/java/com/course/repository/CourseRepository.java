package com.course.repository;

import java.io.Serializable;

import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

import com.course.binding.Course;

@Repository
public interface  CourseRepository  extends JpaRepository<Course,Integer>
{
	
	
	

}
