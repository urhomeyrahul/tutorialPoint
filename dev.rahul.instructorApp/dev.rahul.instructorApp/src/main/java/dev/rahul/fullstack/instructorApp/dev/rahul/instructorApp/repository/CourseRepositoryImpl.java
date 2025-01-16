package dev.rahul.fullstack.instructorApp.dev.rahul.instructorApp.repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;

import org.springframework.beans.factory.annotation.Autowired;

public class CourseRepositoryImpl {

    @Autowired
    private DataSource dataSource;

    public int updateCourse(Long id, String username, String description) {

        String sql = "UPDATE courses SET username = ?, description =? WHERE id = ?";
        int rowsUpdates = 0;

        try (Connection conn = dataSource.getConnection();
                PreparedStatement pStatement = conn.prepareStatement(sql)) {
            pStatement.setString(1, username);
            pStatement.setString(2, description);
            pStatement.setLong(3, id);
            rowsUpdates = pStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error updating course with ID" + id, e);
        }
        return rowsUpdates;
    }
}
