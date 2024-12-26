package com.managementtask.models;

import java.time.*;

public class Task {
    private int id;
    private String subject;
    private String taskTitle;
    private String description;
    private LocalDate taskDate;
    private LocalDateTime dueDate;
    private String taskType;
    private String submissionMethod;
    
    public Task(String subject, String taskTitle, String description, LocalDate taskDate, LocalDateTime dueDate, String taskType, String submissionMethod){
       this. subject = subject;
       this.taskTitle = taskTitle;
       this.description = description;
       this.taskDate = taskDate;
       this.dueDate = dueDate;
       this.taskType = taskType;
       this.submissionMethod = submissionMethod;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getSubject(){
        return subject;
    }

    public void setSubject(String subject){
        this.subject = subject;
    }
    
    public String getTaskTitle() {
        return taskTitle;
    }
    
    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }
    
    public String getDescription(){
        return description;
    }
    
    public void setDescription(String description){
        this.description = description;
    }
    
    public LocalDate getTaskDate(){
        return taskDate;
    }
    
    public void setTaskDate(LocalDate taskDate){
        this.taskDate = taskDate;
    }
    
    public LocalDateTime getDueDate() {
        return dueDate;
    }
    
    public void setDueDate(LocalDateTime dueDate){
        this.dueDate = dueDate;
    } 
    
    public String getTaskType(){
        return taskType;
    }
    
    public void setTaskType(String taskType){
        this.taskType = taskType;
    }
    
    public String getSubmissionMethod(){
        return submissionMethod;
    }
    
    public void setSubmissionMethod(String submissionMethod){
        this.submissionMethod = submissionMethod;
    }
    
}
