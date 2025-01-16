package dev.rahul.fullstack.instructorApp.dev.rahul.instructorApp.repository;


import org.springframework.stereotype.Repository;
import dev.rahul.fullstack.instructorApp.dev.rahul.instructorApp.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{
	
	Course getCourseById(Long Id);
	
}