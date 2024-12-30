/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.managementtask.utils;
import com.managementtask.models.Task;

public class TaskValidation {
    public boolean isNotValid(Task task){
        return task.getSubject().isEmpty() || task.getTaskTitle().isEmpty() || task.getDescription().isEmpty();
    }
}
