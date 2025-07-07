package com.example.github.projects.controller;


import com.example.github.projects.model.Task;
import com.example.github.projects.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/v1/api")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/createTask")
    public ResponseEntity<Task> createTask(@RequestBody Task task){
        Task savedTask = taskService.createTask(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTask);
    }

    @GetMapping("/getTask/{id}")
    public ResponseEntity<Optional<Task>> getTaskById(@PathVariable Long id){
        Optional<Task> taskFound = taskService.getTask(id);
        if (taskFound==null){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(taskFound);
        }
        return ResponseEntity.status(HttpStatus.OK).body(taskFound);
    }

}

