package dev.rahul.fullstack.instructorApp.dev.rahul.instructorApp.repository;


import org.springframework.stereotype.Repository;
import dev.rahul.fullstack.instructorApp.dev.rahul.instructorApp.entity.Course;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{
	
	//Optional<Course> getCourseById(Long Id);
	
}