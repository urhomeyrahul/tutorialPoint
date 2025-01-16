package dev.rahul.fullstack.instructorApp.dev.rahul.instructorApp.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.rahul.fullstack.instructorApp.dev.rahul.instructorApp.service.CourseService;
import dev.rahul.fullstack.instructorApp.dev.rahul.instructorApp.entity.Course;
import dev.rahul.fullstack.instructorApp.dev.rahul.instructorApp.repository.CourseRepository;
import org.springframework.web.bind.annotation.PostMapping;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200" })
@RestController
public class CourseController {

	@Autowired
	public CourseService courseService;

	@Autowired
	public CourseRepository courseRepository;

	public CourseController(CourseRepository courseRepository, CourseService courseService) {
		// Default Controller
		this.courseRepository = courseRepository;
		this.courseService = courseService;
	}

	// DISPLAYING ALL COURSES

	@GetMapping("/{username}/courses")
	public List<Course> getAllCourses(@PathVariable String username) {
		return courseService.findAll();
	}

	// UPDATING THE COURSE CONTENTS OF COURSE

	@PutMapping("/{username}/courses/{id}")
	public ResponseEntity<String> updateCourse(@PathVariable String username,
			@PathVariable Long id, @RequestBody Course course) {
		int updateCount = courseService.updateCourse(id, course.getUsername(), course.getDescription());
		if (updateCount == 1) {
			return ResponseEntity.ok("Course Updated Successfully");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Course not found");
		}
	}

	// Adding a new Course to the database
	@PostMapping("/{username}/courses/add/{id}")
	public ResponseEntity<String> addCourse(@PathVariable String username, @PathVariable Long id,
			@RequestBody Course course) {
		courseService.addCourse(id, course.getUsername(), course.getDescription());
		return ResponseEntity.ok("Course Added Successfully");
	}

	// GETTING A COURSE BY IT'S ID
	@GetMapping("/{username}/courses/{id}")
	public ResponseEntity<Course> getCourseById(
			@PathVariable String username, @PathVariable Long id) {
		return courseService.getCourseById(id)
				.map(course -> new ResponseEntity<>(course, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	// DELETEING A COURSE FROM ITS LIST

	@DeleteMapping("/{username}/courses/delete/{id}")
	public ResponseEntity<String> deleteCourse(@PathVariable String username, @PathVariable Long id) {
		courseService.deleteCourse(id);
		return ResponseEntity.ok("Course Deleted Successfully");
	}

}