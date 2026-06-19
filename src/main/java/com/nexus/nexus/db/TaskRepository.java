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
    public static List<Task> getAll(){
        List<Task> tasks = new ArrayList<>();
        String sql = "SELECT * FROM tasks";

        try(Connection conn = DatabaseManager.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){

            while(rs.next()){
                Task task = new Task(rs.getString("title"),rs.getString("subject"),Task.Priority.valueOf(rs.getString("priority")));

                task.setId(rs.getLong("id"));
                task.setNotes(rs.getString("notes"));
                task.setEstimatedPomodoros(rs.getInt("estimated_pomodoros"));
                task.setCompletedPomodoros(rs.getInt("completed_pomodoros"));
                task.setStatus(Task.Status.valueOf(rs.getString("status")));

                String deadlineStr = rs.getString("deadline");
                if (deadlineStr != null) {
                    task.setDeadline(LocalDateTime.parse(deadlineStr));
                }

                task.setCreatedAt(LocalDateTime.parse(rs.getString("created_at")));

                tasks.add(task);
            }


        } catch (SQLException e) {
            System.out.println("Error reading task:" + e.getMessage());
        }

        return tasks;
    }

    public static void update(Task task) {
        String sql = """
            UPDATE tasks SET 
                title = ?, subject = ?, notes = ?, 
                estimated_pomodoros = ?, completed_pomodoros = ?, 
                deadline = ?, priority = ?, status = ?
            WHERE id = ?
            """;

        try (Connection conn = DatabaseManager.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, task.getTitle());
            pstmt.setString(2, task.getSubject());
            pstmt.setString(3, task.getNotes());
            pstmt.setInt(4, task.getEstimatedPomodoros());
            pstmt.setInt(5, task.getCompletedPomodoros());
            pstmt.setString(6, task.getDeadline() != null ?
                    task.getDeadline().toString() : null);
            pstmt.setString(7, task.getPriority().name());
            pstmt.setString(8, task.getStatus().name());
            pstmt.setLong(9, task.getId());

            int rowsChanged = pstmt.executeUpdate();
            System.out.println("Rows updated: " + rowsChanged);

        } catch (SQLException e) {
            System.out.println("Error updating task: " + e.getMessage());
        }
    }

    public static void delete(long id) {
        String sql = "DELETE FROM tasks WHERE id = ?";

        try (Connection conn = DatabaseManager.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setLong(1, id);
            int rowsChanged = pstmt.executeUpdate();
            System.out.println("Rows deleted: " + rowsChanged);

        } catch (SQLException e) {
            System.out.println("Error deleting task: " + e.getMessage());
        }
    }
}