package com.managementtask.services;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.managementtask.database.DatabaseConnection;
import com.managementtask.models.Task;

public class TaskService {
    
    public void addTask(Task task){
        String sql = "INSERT INTO Task (subject, taskTitle, description, taskDate, dueDate, taskType, submissionMethod) " +
                     "VALUE (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.connect();
            PreparedStatement stmt = conn.prepareStatement(sql)){
        
                stmt.setString(1, task.getSubject());
                stmt.setString(2, task.getTaskTitle());
                stmt.setString(3, task.getDescription());
                stmt.setDate(4, java.sql.Date.valueOf(task.getTaskDate()));
                stmt.setTimestamp(5, java.sql.Timestamp.valueOf(task.getDueDate()));
                stmt.setString(6, task.getTaskType());
                stmt.setString(7, task.getSubmissionMethod());

                stmt.executeUpdate();
                System.out.println("New Task Added");            
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<Task> getAllTasks(){
        String sql = "SELECT * FROM Task";
        List<Task> tasks = new ArrayList<>();

        try (Connection conn = DatabaseConnection.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
                
                while (rs.next()){

                    LocalDate taskDate = rs.getDate("taskDate").toLocalDate();
                    LocalDateTime dueDate = rs.getTimestamp("dueDate").toLocalDateTime();

                    Task task = new Task(
                        rs.getString("subject"),
                        rs.getString("taskTitle"),
                        rs.getString("description"),
                        taskDate,
                        dueDate,
                        rs.getString("taskType"),
                        rs.getString("submissionMethod"));

                    task.setId(rs.getInt("id"));
                    tasks.add(task);
                }
            } catch(SQLException e){
                e.printStackTrace();
            }

            return tasks;
        }
}
