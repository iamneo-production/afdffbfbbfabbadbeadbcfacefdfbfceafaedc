package com.examly.springapp;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Task {
    @Id
    int taskId;
    String taskHolderName;
    String taskDate;
    String taskName;
    String houseno;
    public int getTaskId() {
        return taskId;
    }
    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }
    public String getTaskHolderName() {
        return taskHolderName;
    }
    public void setTaskHolderName(String taskHolderName) {
        this.taskHolderName = taskHolderName;
    }
    public String getTaskDate() {
        return taskDate;
    }
    public void setTaskDate(String taskDate) {
        this.taskDate = taskDate;
    }
    public String getTaskName() {
        return taskName;
    }
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
    public String getTaskStatus() {
        return taskStatus;
    }
    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }
    String taskStatus;
   public String getHouseno(){
    return houseno;
   }
   public void setHouseno(String houseno) {
    this.houseno = houseno;
}

}