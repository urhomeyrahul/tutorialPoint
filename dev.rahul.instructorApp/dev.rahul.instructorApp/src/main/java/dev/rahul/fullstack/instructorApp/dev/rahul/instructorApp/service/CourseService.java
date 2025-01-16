package dev.rahul.fullstack.instructorApp.dev.rahul.instructorApp.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import dev.rahul.fullstack.instructorApp.dev.rahul.instructorApp.entity.Course;
@Service
public interface CourseService {

	List<Course> findAll();

	public Optional<Course> getCourseById(Long id);

	public Optional<Course> deleteById(Long id);

	public int updateCourse(Long id, String username, String description);

	// public Course addNewCourse(CourseModel courseModel);

}
