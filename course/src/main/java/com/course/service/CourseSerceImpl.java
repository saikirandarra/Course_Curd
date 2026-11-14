package com.course.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.binding.Course;
import com.course.controller.CourseController;
import com.course.repository.CourseRepository;

@Service
public class CourseSerceImpl implements CourseService
{

	private static final Logger logger = LogManager.getLogger(CourseSerceImpl.class);
	
	@Autowired(required=true)
	CourseRepository cr;
	
	
	@Override
	public String upsert(Course course) {
		// TODO Auto-generated method stub
		 cr.save(course);
		 
		 return "Success";
	}

	@Override
	public Course getById(Integer cid) {
		// TODO Auto-generated method stub
		Optional<Course> findById=cr.findById(cid);
		
		if(findById.isPresent()) {
		
		return findById.get();} return null;
	}

	@Override
	public List<Course> getallCourse() {
		// TODO Auto-generated method stub
		List<Course> all_course=cr.findAll();
		
		return all_course;
	}

	@Override
	public String  deleteById(Integer cid)
	{
		// TODO Auto-generated method stub
		if(cr.existsById(cid))
		{
			  cr.deleteById(cid);
			  return "Data Deleted Sicessfully";
		}
		else {return "No Data found";}
		
		
	}

	

}
