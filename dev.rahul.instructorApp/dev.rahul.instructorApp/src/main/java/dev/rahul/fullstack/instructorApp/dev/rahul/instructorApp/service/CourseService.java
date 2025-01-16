package dev.rahul.fullstack.instructorApp.dev.rahul.instructorApp.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import dev.rahul.fullstack.instructorApp.dev.rahul.instructorApp.entity.Course;

@Service
public interface CourseService {

	List<Course> findAll();

	Optional<Course> getCourseById(Long id);

	void deleteCourse(Long id);

	int updateCourse(Long id, String username, String description);

	int addCourse(Long id, String username, String description);
}
