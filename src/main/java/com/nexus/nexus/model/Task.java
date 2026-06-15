package com.nexus.nexus.model;
import java.time.LocalDateTime;

public class Task {

    public enum Priority {
        HIGH, NORMAL, LOW
    }

    public enum Status {
        TODO, IN_PROGRESS, DONE
    }

    private long id;
    private String title;
    private String subject;
    private String notes;
    private int estimatedPomodoros;
    private int completedPomodoros;
    private LocalDateTime deadline;
    private LocalDateTime createdAt;
    private Priority priority;
    private Status status;

    // Constructor which used to create an new task,
    // when ever a new task are created they put status as TODO and it also set current time in createddAt
    public Task(String title,String subject,Priority priority){
        this.title = title;
        this.subject = subject;
        this.priority = priority;
        this.status = Status.TODO;
        this.createdAt = LocalDateTime.now();
    }



    //this section are for all getters and setters methods fpr every variable
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }

    public int getEstimatedPomodoros() { return estimatedPomodoros; }
    public void setEstimatedPomodoros(int estimatedPomodoros) { this.estimatedPomodoros = estimatedPomodoros; }

    public int getCompletedPomodoros() { return completedPomodoros; }
    public void setCompletedPomodoros(int completedPomodoros) { this.completedPomodoros = completedPomodoros; }

    public LocalDateTime getDeadline() { return deadline; }
    public void setDeadline(LocalDateTime deadline) { this.deadline = deadline; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public Priority getPriority() { return priority; }
    public void setPriority(Priority priority) { this.priority = priority; }

    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }





}

