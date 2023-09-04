package com.examly.springapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.examly.springapp.exception.ResourceNotFoundException;
import com.examly.springapp.repository.TasksRepository;
import com.examly.springapp.model.Tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TasksService {
    private final TasksRepository taskRepository;

    @Autowired
    public TaskService(TasksRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    public Task changeTaskStatus(String taskId, String taskStatus) {
        Task task = taskRepository.findByTaskId(taskId);
        if (task != null) {
            task.setTaskStatus(taskStatus);
            return taskRepository.save(task);
        }
        return null;
    }

    public void deleteTask(String taskId) {
        Task task = taskRepository.findByTaskId(taskId);
        if (task != null) {
            taskRepository.delete(task);
        }
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskByTaskId(String taskId) {
        return taskRepository.findByTaskId(taskId);
    }
}