package com.examly.springapp.repository;

import org.springframework.data.repository.CrudRepository;
import com.examly.springapp.model.Tasks;

public interface TaskRepository extends JpaRepository<Task, String>
{
    
}
    
