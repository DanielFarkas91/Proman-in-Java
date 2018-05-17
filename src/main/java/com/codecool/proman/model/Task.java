package com.codecool.proman.model;

import org.hibernate.annotations.Target;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String taskName;

    private String taskDescription;

    private String taskUserNotes;

    private Date taskStartDate;

    private Date taskFinishDate;

    @ManyToOne
    private Project project;

    @ManyToMany
    List<Users> users = new ArrayList<>();

    public Task() {
    }

    public Task(String taskName, Users user, Project project) {
        this.taskName = taskName;
        addUserToTask(user);
        this.project = project;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public String getTaskUserNotes() {
        return taskUserNotes;
    }

    public void setTaskUserNotes(String taskUserNotes) {
        this.taskUserNotes = taskUserNotes;
    }

    public Date getTaskStartDate() {
        return taskStartDate;
    }

    public void setTaskStartDate(Date taskStartDate) {
        this.taskStartDate = taskStartDate;
    }

    public Date getTaskFinishDate() {
        return taskFinishDate;
    }

    public void setTaskFinishDate(Date taskFinishDate) {
        this.taskFinishDate = taskFinishDate;
    }

    public List<Users> getUsers() {
        return users;
    }

    public void addUserToTask (Users user) {
        users.add(user);
    }
}

