package dev.rahul.fullstack.instructorApp.dev.rahul.instructorApp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Iterator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.rahul.fullstack.instructorApp.dev.rahul.instructorApp.entity.Course;
import dev.rahul.fullstack.instructorApp.dev.rahul.instructorApp.model.*;
import dev.rahul.fullstack.instructorApp.dev.rahul.instructorApp.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepository courseRepository;

	private static List<Course> courses = new ArrayList<Course>();
	private static long idCounter = 0;

	// FINDING BY A PARTICULAR ID

	public Optional<Course> getCourseById(Long id) {
		return courseRepository.findById(id);
	}
	// Creating a new course

	public Course addNewCourse(CourseModel courseModel) {

		Course course = new Course(null, null, null);
		course.setDescription(courseModel.getDescription());
		course.setId(courseModel.getId());
		course.setUsername(courseModel.getUsername());
		courseRepository.save(course);
		return course;
	}

	// DISPLAYING ALL THE COURSES IN 1 GO

	public List<Course> findAll() {
		return courseRepository.findAll();
	}

	// DELETING A COURSE FROM LIST

	public Optional<Course> deleteById(Long id) {

		Iterator<Course> iterator = courses.iterator();
		while (iterator.hasNext()) {
			Course course = iterator.next();
			if (course.getId() == id) {
				iterator.remove();
				return Optional.of(course);
			}
		}
		return Optional.empty();
	}

	// DOING A ADD FEATURE IN COURSE LIST

	public Course save(Course course) {
		if (course.getId() <= 0) {
			course.setId(++idCounter);
		} else {
			deleteById(course.getId());
		}
		courses.add(course);
		return course;
	}
}
