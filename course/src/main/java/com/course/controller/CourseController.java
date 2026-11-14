package com.course.controller;

import org.springframework.web.bind.annotation.RestController;

import com.course.binding.Course;
import com.course.service.CourseService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
public class CourseController
{
	
	private static final Logger logger = LogManager.getLogger(CourseController.class);
	
	@Autowired(required=true)
	CourseService cs;
	
	@PostMapping("/course")
	public ResponseEntity<String> createCourse(@RequestBody Course course)
	{
		System.out.println("Course=====>"+course.toString());
		String status=cs.upsert(course);
		return new ResponseEntity<>(status,HttpStatus.CREATED);
		
	}
	@GetMapping("/course/{cid}")
	public ResponseEntity<Course> getCourse(@PathVariable Integer cid)
	{
		Course course=cs.getById(cid);
		return  new ResponseEntity<>(course,HttpStatus.OK);
	}
   @GetMapping("/courses")
   public  ResponseEntity<List<Course>> getallCoourse()
   {
	   List<Course> allcourse=cs.getallCourse();
	   return new ResponseEntity<>(allcourse,HttpStatus.OK);
   }
   @PutMapping("/course")
   public ResponseEntity<String> updateCourse( @RequestBody Course course) {
       //TODO: process PUT request
       String status=cs.upsert(course);
       return new ResponseEntity<>(status,HttpStatus.OK);
   }
   
   @DeleteMapping("/course/{cid}")
   public ResponseEntity<String> deleteCourse(@PathVariable Integer cid)
   {
	   String status=cs.deleteById(cid);
	   
	   return new ResponseEntity<>(status,HttpStatus.OK);
	   
   }
}
   
	


