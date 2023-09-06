package com.examly.springapp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
interface Respository extends JpaRepository<ModelTask,Integer> {
    
}