package com.jdbc_hibernet.springboot.learn_jpa_hibernate.course.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.jdbc_hibernet.springboot.learn_jpa_hibernate.course.Course;

@Repository
@Transactional
public class CourseJpaRepository {

	@PersistenceContext
	private EntityManager entityManager; 
	
	public void insert(Course course)
	{
		entityManager.merge(course);
	}
	
	public Course findById(long id)
	{
		return entityManager.find(Course.class, id);
	}
	
	public void deleteById(long id)
	{	Course course = entityManager.find(Course.class,id);
		entityManager.remove(course);
	}
	
	
}
