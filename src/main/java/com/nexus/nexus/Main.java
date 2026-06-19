package com.nexus.nexus;

import com.nexus.nexus.db.DatabaseManager;
import com.nexus.nexus.db.TaskRepository;
import com.nexus.nexus.model.Task;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DatabaseManager.createTables();

        List<Task> tasks = TaskRepository.getAll();

        System.out.println("Total tasks in database: " + tasks.size());

        for (Task t : tasks) {
            System.out.println(
                    "id=" + t.getId() +
                            " | title=" + t.getTitle() +
                            " | subject=" + t.getSubject() +
                            " | status=" + t.getStatus()
            );
        }
    }
}