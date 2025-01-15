package com.managementtask.services;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.managementtask.database.DatabaseConnection;
import com.managementtask.models.Task;

public class TaskService {
    
        // Tambahkan Tugas
    public void addTask(Task task, String userEmail) {
        String sql = "INSERT INTO Task (subject, taskTitle, description, taskDate, dueDate, taskType, submissionMethod, user_email) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, task.getSubject());
            stmt.setString(2, task.getTaskTitle());
            stmt.setString(3, task.getDescription());
            stmt.setDate(4, java.sql.Date.valueOf(task.getTaskDate()));
            stmt.setTimestamp(5, java.sql.Timestamp.valueOf(task.getDueDate()));
            stmt.setString(6, task.getTaskType());
            stmt.setString(7, task.getSubmissionMethod());
            stmt.setString(8, userEmail);

            stmt.executeUpdate();
            System.out.println("New Task Added");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Ambil Semua Tugas Berdasarkan User ID
    public List<Task> getTasksByUserEmail(String userEmail) {
        String sql = "SELECT * FROM Task WHERE user_email = ?";
        List<Task> tasks = new ArrayList<>();

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, userEmail);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    LocalDate taskDate = rs.getDate("taskDate").toLocalDate();
                    LocalDateTime dueDate = rs.getTimestamp("dueDate").toLocalDateTime();

                    Task task = new Task(
                        rs.getString("subject"),
                        rs.getString("taskTitle"),
                        rs.getString("description"),
                        taskDate,
                        dueDate,
                        rs.getString("taskType"),
                        rs.getString("submissionMethod")
                    );

                    task.setId(rs.getInt("id"));
                    tasks.add(task);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tasks;
    }

    // Dapatkan Tugas Berdasarkan ID Tugas
    public Task getTask(int taskId) {
        String sql = "SELECT * FROM Task WHERE id = ?";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, taskId);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    LocalDate taskDate = rs.getDate("taskDate").toLocalDate();
                    LocalDateTime dueDate = rs.getTimestamp("dueDate").toLocalDateTime();

                    Task task = new Task(
                        rs.getString("subject"),
                        rs.getString("taskTitle"),
                        rs.getString("description"),
                        taskDate,
                        dueDate,
                        rs.getString("taskType"),
                        rs.getString("submissionMethod")
                    );

                    task.setId(rs.getInt("id"));
                    return task;
                } else {
                    System.out.println("Task with ID " + taskId + " not found.");
                    return null;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public void updateTask(int taskId, Task updatedTask) {
        String sql = "UPDATE task SET subject = ?, taskTitle = ?, description = ?, taskDate = ?, dueDate = ?, taskType = ?, submissionMethod = ? WHERE id = ?";
        
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, updatedTask.getSubject());
            stmt.setString(2, updatedTask.getTaskTitle());
            stmt.setString(3, updatedTask.getDescription());
            stmt.setDate(4, java.sql.Date.valueOf(updatedTask.getTaskDate()));
            stmt.setTimestamp(5, java.sql.Timestamp.valueOf(updatedTask.getDueDate()));
            stmt.setString(6, updatedTask.getTaskType());
            stmt.setString(7, updatedTask.getSubmissionMethod());
            stmt.setInt(8, taskId);

            stmt.executeUpdate();
            System.out.println("Tugas berhasil diperbarui.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void deleteTask(int taskId){
        String sql = "DELETE FROM task WHERE id = ?";
        
        try(Connection conn = DatabaseConnection.connect();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, taskId);
            stmt.executeUpdate();
            System.out.println("Tugas berhasil dihapus.");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
