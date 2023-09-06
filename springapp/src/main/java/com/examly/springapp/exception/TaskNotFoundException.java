package com.examly.springapp.exception;

public class TaskNotFoundException extends RuntimeException {
    public TaskNotFoundException(String taskId) {
        super("Could not find task " + taskId);
    }
}