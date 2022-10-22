package com.springrest.springrest.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

import com.springrest.springrest.entities.Course;

@Service
public class CourseServiceimpl implements CourseService {

	List<Course> list;	
	
	public  CourseServiceimpl()
	{
		list=new ArrayList<>();
		list.add(new Course(131,"java core Courses","This course contains basic of java"));
		list.add(new Course(141,"python courses","This course contains basic + adavance of python"));
	}
	@Override
	public List<Course> getCourses() {
		// TODO Auto-generated method stub
		return list;
	}
	@Override
	public Course getCourse(long courseId) {
		// TODO Auto-generated method stub
		Course c=null;
		for(Course course:list)
		{
			if(course.getId()==courseId)
			{
				c=course;
				break;
			}
		}
		return c;
	}
	@Override
	public Course addCourse(Course course) {
		
		list.add(course);
		
		return course;
	}
	@Override
	public Course updateCourse(Course course) {
		list.forEach(e ->
		{
			if(e.getId() ==course.getId()) {
				e.setTitle(course.getTitle());
				e.setDescription(course.getDescription());
			}
		});
		
		return course;
	}
	
	@Override
	public void deleteCourse(long parseLong) {
		list=(List<Course>) this.list.stream().filter(e->e.getId()!=parseLong).collect(Collectors.toList());
		
	}

}
