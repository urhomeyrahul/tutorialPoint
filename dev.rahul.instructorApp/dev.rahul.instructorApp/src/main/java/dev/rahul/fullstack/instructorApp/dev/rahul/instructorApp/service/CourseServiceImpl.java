package dev.rahul.fullstack.instructorApp.dev.rahul.instructorApp.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.rahul.fullstack.instructorApp.dev.rahul.instructorApp.entity.Course;
import dev.rahul.fullstack.instructorApp.dev.rahul.instructorApp.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepository courseRepository;

	// FINDING BY A PARTICULAR ID

	public Optional<Course> getCourseById(Long id) {
		return courseRepository.findById(id);
	}

	// DISPLAYING ALL THE COURSES IN 1 GO

	public List<Course> findAll() {
		return courseRepository.findAll();
	}

	// DELETING A COURSE FROM LIST

	public void deleteCourse(Long id) {
		courseRepository.deleteById(id);
	}

	// Updating the course contents

	public int updateCourse(Long id, String username, String description) {
		return courseRepository.updateCourse(id, username, description);
	}

	// Adding a new course
	public int addCourse(Long id, String username, String description){
		return courseRepository.addCourse(id, username, description);
	}
}
