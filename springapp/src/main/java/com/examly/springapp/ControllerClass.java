package com.examly.springapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@RestController
public class ControllerClass {
    @Autowired
    TaskService service;
    @GetMapping("/alltasks")
    public List<Task> getAllTasks()
    {
        return service.findAllTask();
    }
    @PostMapping("/saveTask")
    public Task addTask(@RequestBody Task t)
    {
        return service.addTask(t);
    }
    @GetMapping("/deleteTask")
    public void deleteTask(@RequestParam String taskId)
    {
        
    service.deleteTask(Integer.valueOf(taskId));
    }
    @GetMapping("/getTask")
    public Optional<Task> getbyId(@RequestParam String taskId)
    {
        return service.getTaskById(Integer.valueOf(taskId));
    }
}


