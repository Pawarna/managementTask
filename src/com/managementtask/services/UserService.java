package com.managementtask.services;

import org.mindrot.jbcrypt.BCrypt;
import java.sql.*;
import java.util.UUID;
import com.managementtask.models.User;
import com.managementtask.database.DatabaseConnection;

public class UserService {

    // Register User
    public boolean register(User user) {
        // Cek apakah user sudah ada berdasarkan email
        User existUser = getUser(user.getEmail());
        if (existUser != null) {
            return false; // User already exists
        }

        // Hash password menggunakan BCrypt
        String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        String sql = "INSERT INTO user (name, email, phoneNumber, password) " +
                     "VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPhoneNumber());
            stmt.setString(4, hashedPassword);

            stmt.executeUpdate();
            System.out.println("Register success");
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Login User
    public String login(String email, String password) {
        // Dapatkan user berdasarkan email
        User user = getUser(email);
        if (user == null) {
            System.out.println("User not found");
            return null; // User tidak ditemukan
        }

        // Validasi password menggunakan BCrypt
        if (!BCrypt.checkpw(password, user.getPassword())) {
            System.out.println("Invalid password");
            return null; // Password salah
        }

        // Generate token
        String token = UUID.randomUUID().toString();
        String sql = "UPDATE user SET token = ? WHERE email = ?";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, token);
            stmt.setString(2, email);
            stmt.executeUpdate();
            System.out.println("Login success");
            return token;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Get User by Email
    public User getUser(String email) {
        String sql = "SELECT * FROM user WHERE email = ?";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, email);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new User(
                            rs.getString("name"),
                            rs.getString("email"),
                            rs.getString("phoneNumber"),
                            rs.getString("password")
                    );
                } else {
                    System.out.println("User with email " + email + " not found.");
                    return null;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public boolean logout(String email) {
        String sql = "UPDATE user SET token = NULL WHERE email = ?";
        
        try (Connection conn = DatabaseConnection.connect();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            // Set parameter email untuk mencari user
            stmt.setString(1, email);
            
            // Eksekusi update untuk menghapus token
            int rowsUpdated = stmt.executeUpdate();
            
            // Mengecek apakah token berhasil dihapus (rowsUpdated > 0 berarti ada baris yang terupdate)
            if (rowsUpdated > 0) {
                System.out.println("Token telah dihapus, logout berhasil.");
                return true;
            } else {
                System.out.println("Token tidak ditemukan atau gagal menghapus token.");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
