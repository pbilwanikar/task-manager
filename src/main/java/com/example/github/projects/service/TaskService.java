package com.example.github.projects.service;

import com.example.github.projects.model.Task;
import com.example.github.projects.repositiory.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    public Task createTask(Task task){
        return taskRepository.save(task);
    }

    public Optional<Task> getTask(Long id){
        return taskRepository.findById(id);
    }
    public void deleteById(Long id){
        taskRepository.deleteById(id);
    }

}
