package com.codecool.proman.repository;

import com.codecool.proman.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Integer> {

  //  List<Project> findAllByUserId(Integer userId);
}
