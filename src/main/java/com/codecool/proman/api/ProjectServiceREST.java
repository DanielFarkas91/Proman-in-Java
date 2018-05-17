package com.codecool.proman.api;

import com.codecool.proman.model.Project;
import com.codecool.proman.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProjectServiceREST {

    @Autowired
    ProjectService projectService;

    public ProjectServiceREST(ProjectService projectService) {
        this.projectService = projectService;
    }

    //TODO CHANGE USERID to session id
    @GetMapping("/api/rentals")
    public ResponseEntity<List<Project>> getAllRental() {
        return new ResponseEntity(HttpStatus.OK);
    }
}
