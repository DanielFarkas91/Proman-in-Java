package com.codecool.proman.service;

import com.codecool.proman.model.Task;
import com.codecool.proman.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public void save(Task entity) {
        taskRepository.save(entity);
    }

    public Task getTaskById(int taskId) {
        return taskRepository.findOne(taskId);
    }
}
