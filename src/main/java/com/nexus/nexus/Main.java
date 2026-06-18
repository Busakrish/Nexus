package com.nexus.nexus;
import com.nexus.nexus.db.DatabaseManager;
import com.nexus.nexus.db.TaskRepository;
import com.nexus.nexus.model.Task;
import java.time.LocalDateTime;
public class Main {
    public static void main(String[] args){
        DatabaseManager.createTables();
        Task task = new Task("Math Exam", "Mathamatics" , Task.Priority.HIGH);
        task.setDeadline(LocalDateTime.now().plusDays(3));
        task.setEstimatedPomodoros(4);

        TaskRepository.add(task);
        System.out.println("Task ID from database "+ task.getId());
    }
}
