package com.jdbc_hibernet.springboot.learn_jpa_hibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.jdbc_hibernet.springboot.learn_jpa_hibernate.course.Course;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner{
	
	@Autowired
	private CourseJdbcReository repository;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		repository.insert(new Course(1, "Spring", "UdemyCourse"));
		repository.insert(new Course(2, "JAVA", "UdemyCourse2"));
		
		repository.deleteById(1);
	}

}
