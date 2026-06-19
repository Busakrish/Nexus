package com.nexus.nexus;

import com.nexus.nexus.db.DatabaseManager;
import com.nexus.nexus.db.TaskRepository;
import com.nexus.nexus.model.Task;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DatabaseManager.createTables();

        // Get the first task and update it
        List<Task> tasks = TaskRepository.getAll();
        Task firstTask = tasks.get(0);

        System.out.println("Before update: " + firstTask.getStatus());

        firstTask.setStatus(Task.Status.DONE);
        TaskRepository.update(firstTask);

        // Read again to confirm the change saved
        List<Task> updatedTasks = TaskRepository.getAll();
        for (Task t : updatedTasks) {
            System.out.println("id=" + t.getId() + " status=" + t.getStatus());
        }

        // Delete the last task
        Task lastTask = updatedTasks.get(updatedTasks.size() - 1);
        TaskRepository.delete(lastTask.getId());

        // Read again to confirm deletion
        List<Task> finalTasks = TaskRepository.getAll();
        System.out.println("Total tasks after delete: " + finalTasks.size());
    }
}