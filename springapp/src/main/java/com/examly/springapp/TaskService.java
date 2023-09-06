package com.examly.springapp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class TaskService{
    @Autowired
    Respository rep;
    public Task addTask(Task task)
    {
        rep.save(task);
        return task;
    }
    public Optional<Task> getTaskById(int id)
    {
       
        return rep.findById(id);
    }
   public List<Task> findAllTask()
    {
        return rep.findAll();
    }
    public void deleteTask(int id)
    {
        rep.deleteById(id);
    }
    public Task findByName(String name)
    {
        List<Task> list=rep.findAll();
        for(int i=0;i<list.size();i++)
        {
           String str=list.get(i).taskHolderName;
           if(str.equals(name))
           {
           return list.get(i);
           }
           
        }
        return null;
    }

}