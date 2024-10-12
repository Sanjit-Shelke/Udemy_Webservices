package com.jdbc_hibernet.springboot.learn_jpa_hibernate.course.jdbc;

import org.hibernate.sql.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcReository {
	
	@Autowired
	private JdbcTemplate springJdbcTemplate;
	
	private static String INSERT_QUERY = "insert into course (id, name, author) values(1,'LearnSpringBoot','UdemyCourse');";
	
	public void insert()
	{
		springJdbcTemplate.update(INSERT_QUERY);
	}
}
