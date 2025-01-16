package dev.rahul.fullstack.instructorApp.dev.rahul.instructorApp.repository;


import org.springframework.stereotype.Repository;
import dev.rahul.fullstack.instructorApp.dev.rahul.instructorApp.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{
		int updateCourse(Long id, String username, String description);
        
    @Transactional
    @Modifying
    @Query("INSERT INTO Course (id, username, description) VALUES (:id, :username, :description)")
    int addCourse(@Param("id") Long id, @Param("username") String username, @Param("description") String description);

}
