package com.codecool.proman.service;

import com.codecool.proman.model.Project;
import com.codecool.proman.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;


    public void save(Project entity) {
        projectRepository.save(entity);
    }

    public Project getProjectById(int projectId) {
        return projectRepository.findOne(projectId);
    }
/*
    public List<Project> getAllProjects(int userId) {
        return projectRepository.findAllByUserId(userId);
    }
*/
}
