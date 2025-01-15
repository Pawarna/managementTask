package com.managementtask.utils;
import com.managementtask.models.Task;

public class TaskValidation {
    public boolean isNotValid(Task task){
        return task.getSubject().isEmpty() || task.getTaskTitle().isEmpty() || task.getDescription().isEmpty();
    }
}
