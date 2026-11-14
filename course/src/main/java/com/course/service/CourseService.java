package com.course.service;

import java.util.List;

import com.course.binding.Course;

public interface CourseService 
{
	
	public String  upsert(Course course);
	
	public Course getById(Integer cid);
	
	public List<Course> getallCourse();
	
	public String deleteById(Integer cid);
	
	
	

}
