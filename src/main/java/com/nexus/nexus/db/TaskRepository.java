package com.nexus.nexus.db;

import com.nexus.nexus.model.Task;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TaskRepository {
    public static void add(Task task){
        String sql = """
            INSERT INTO tasks (title, subject, notes, 
            estimated_pomodoros, completed_pomodoros, 
            deadline, created_at, priority, status)
            VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)
            """;
        try (Connection conn = DatabaseManager.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql,
                     Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, task.getTitle());
            pstmt.setString(2, task.getSubject());
            pstmt.setString(3, task.getNotes());
            pstmt.setInt(4, task.getEstimatedPomodoros());
            pstmt.setInt(5, task.getCompletedPomodoros());
            pstmt.setString(6, task.getDeadline() != null ?
                    task.getDeadline().toString() : null);
            pstmt.setString(7, task.getCreatedAt().toString());
            pstmt.setString(8, task.getPriority().name());
            pstmt.setString(9, task.getStatus().name());

            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                task.setId(rs.getLong(1));
            }

            System.out.println("Task saved: " + task.getTitle());

        } catch (SQLException e) {
            System.out.println("Error saving task: " + e.getMessage());
        }
    }
}