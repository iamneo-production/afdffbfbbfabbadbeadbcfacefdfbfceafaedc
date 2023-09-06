package com.examly.springapp.controller;

import java.util.*;

import com.examly.springapp.model.Task;
import com.examly.springapp.TaskNotFoundException;
import com.examly.springapp.repository.TaskRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class TaskController {
    
    @Autowired
    private TaskRepository taskRepository;

    // Save a new task 
    @PostMapping("/saveTask")
    public Task saveTask(@RequestBody Task task) {
        return taskRepository.save(task);
    }

    // Change task status
    @GetMapping("/changeStatus")
    public Task changeStatus(@RequestParam("id") String taskId, @RequestParam("status") String taskStatus) {
        Task task = taskRepository.findById(taskId).orElseThrow(() -> new TaskNotFoundException(taskId));
        task.setTaskStatus(taskStatus);
        return taskRepository.save(task);
    }

    // Delete a task
    @GetMapping("/deleteTask")
    public ResponseEntity<Void> deleteTask(@RequestParam("id") String taskId) {
        Task task = taskRepository.findById(taskId).orElseThrow(() -> new TaskNotFoundException(taskId));
        taskRepository.delete(task);
        return ResponseEntity.ok().build();
    }

    // Get all tasks
    @GetMapping("/alltasks")
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    // Get task by task holder name
    @GetMapping("/getTask")
    public Task getTaskByTaskId(@RequestParam("id") String taskId) {
        return taskRepository.findById(taskId).orElseThrow(() -> new TaskNotFoundException(taskId));
    }
}