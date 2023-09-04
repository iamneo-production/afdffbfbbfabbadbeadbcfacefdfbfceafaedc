package com.examly.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TasksRepository extends JpaRepository<Task, Long> {
    Task findByTaskId(String taskId);
}