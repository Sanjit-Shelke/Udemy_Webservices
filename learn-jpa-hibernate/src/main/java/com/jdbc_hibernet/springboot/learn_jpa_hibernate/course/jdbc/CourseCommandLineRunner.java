package com.jdbc_hibernet.springboot.learn_jpa_hibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.jdbc_hibernet.springboot.learn_jpa_hibernate.course.Course;
import com.jdbc_hibernet.springboot.learn_jpa_hibernate.course.jpa.CourseJpaRepository;

@Component
public class CourseCommandLineRunner implements CommandLineRunner{
	
	@Autowired
	private CourseJpaRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		repository.insert(new Course(1, "Spring", "UdemyCourse"));
		repository.insert(new Course(2, "JAVA", "UdemyCourse2"));
		repository.insert(new Course(3, "JEE", "UdemyCourse3"));
		
		repository.deleteById(1);
		
		System.out.println(repository.findById(2));
		System.out.println(repository.findById(3));
	}

}
