package com.examly.springapp.controller;

import java.util.*;

import com.examly.springapp.service.TasksService;
import com.examly.springapp.model.Tasks;
import com.examly.springapp.exception.ResourceNotFoundException;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TasksController {
    private final TaskService taskService;

    @Autowired
    public TasksController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/saveTask")
    public ResponseEntity<Task> saveTask(@RequestBody Task task) {
        Task savedTask = taskService.saveTask(task);
        return ResponseEntity.ok(savedTask);
    }

    @GetMapping("/changeStatus")
    public ResponseEntity<Task> changeTaskStatus(@RequestParam("id") String taskId,
                                                 @RequestParam("status") String taskStatus) {
        Task updatedTask = taskService.changeTaskStatus(taskId, taskStatus);
        if (updatedTask != null) {
            return ResponseEntity.ok(updatedTask);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/deleteTask")
    public ResponseEntity<Void> deleteTask(@RequestParam("id") String taskId) {
        taskService.deleteTask(taskId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/allTasks")
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> tasks = taskService.getAllTasks();
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/getTask")
    public ResponseEntity<Task> getTaskByTaskId(@RequestParam("id") String taskId) {
        Task task = taskService.getTaskByTaskId(taskId);
        if (task != null) {
            return ResponseEntity.ok(task);
        }
        return ResponseEntity.notFound().build();
    }
}