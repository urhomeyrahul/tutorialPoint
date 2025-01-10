package dev.rahul.fullstack.instructorApp.dev.rahul.instructorApp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
// import jakarta.validation.constrains.Size;

import jakarta.persistence.Id;

@Entity
@Table(name = "courses")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String description;

	// @Size(min = 3, max = 50)
	private String username;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Course(Long id, String description, String userName) {
		super();
		this.id = id;
		this.description = description;
		this.username = userName;
	}

}