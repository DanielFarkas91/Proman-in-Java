package com.codecool.proman.model;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String projectName;

    private String projectDescription;

    private String projectUserNotes;

    private Date projectStartDate;

    private Date projectEndDate;

    @OneToMany(mappedBy = "project")
    private List<Task> tasks = new ArrayList<>();

    @ManyToMany
    private List<Users> users = new ArrayList<>();

    public Project() {
    }

    public Project(String projectName, Users user) {
        this.projectName = projectName;
        addUserToProject(user);
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public String getProjectUserNotes() {
        return projectUserNotes;
    }

    public void setProjectUserNotes(String projectUserNotes) {
        this.projectUserNotes = projectUserNotes;
    }

    public Date getProjectStartDate() {
        return projectStartDate;
    }

    public void setProjectStartDate(Date projectStartDate) {
        this.projectStartDate = projectStartDate;
    }

    public Date getProjectEndDate() {
        return projectEndDate;
    }

    public void setProjectEndDate(Date projectEndDate) {
        this.projectEndDate = projectEndDate;
    }

    public void addUserToProject(Users user) {
        users.add(user);
    }

    public void addTaskToProject(Task task) {
        tasks.add(task);
    }

}
