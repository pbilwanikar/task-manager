package com.example.github.projects.service;

import com.example.github.projects.model.Task;
import com.example.github.projects.repositiory.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    public Task createTask(Task task){
        return taskRepository.save(task);
    }


}
