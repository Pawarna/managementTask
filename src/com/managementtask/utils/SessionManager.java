package com.managementtask.utils;

import com.managementtask.database.DatabaseConnection;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class SessionManager {

    private static final String SESSION_FILE = "session.properties"; // Lokasi file sesi

    // Menyimpan email dan token di session.properties
    public static void saveSession(String email, String token) {
        Properties properties = new Properties();
        File file = new File(SESSION_FILE);
        
        // Jika file tidak ada, buat baru
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        // Cek apakah file sudah ada dan memuat properti yang ada
        if (file.exists()) {
            try (FileInputStream inputStream = new FileInputStream(file)) {
                properties.load(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Menyimpan email dan token
        properties.setProperty("user.email", email);
        properties.setProperty("user.token", token);
        
        // Menyimpan kembali ke file
        try (FileOutputStream outputStream = new FileOutputStream(file)) {
            properties.store(outputStream, "User Session");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Mengambil email dari sesi yang tersimpan
    public static String getEmailFromSession() {
        Properties properties = new Properties();
        File file = new File(SESSION_FILE);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // Membaca data dari session.properties
        try (FileInputStream inputStream = new FileInputStream(SESSION_FILE)) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return properties.getProperty("user.email");
    }

    // Mengambil token dari sesi yang tersimpan
    public static String getTokenFromSession() {
        Properties properties = new Properties();
        
        // Membaca data dari session.properties
        try (FileInputStream inputStream = new FileInputStream(SESSION_FILE)) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return properties.getProperty("user.token");
    }

    // Memverifikasi apakah sesi masih valid berdasarkan email dan token
    public static boolean isSessionValid(String email) {
        String savedEmail = getEmailFromSession();
        String savedToken = getTokenFromSession();
        
        // Jika email atau token null, sesi tidak valid
        if (savedEmail == null || savedToken == null) {
            return false;
        }
        
        // Verifikasi token di database
        return verifyTokenInDatabase(savedEmail, savedToken);
    }

    // Menghapus sesi yang ada di session.properties
    public static void clearSession() {
        File file = new File(SESSION_FILE);
        if (file.exists()) {
            file.delete(); // Menghapus file session
        }
    }

    // Memverifikasi token di database
    private static boolean verifyTokenInDatabase(String email, String token) {
        String sql = "SELECT token FROM user WHERE email = ?";
        String tokendb = null;
        
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, email);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    tokendb = rs.getString("token");
                }
            }
            
            // Jika token dari database sama dengan token yang tersimpan, sesi valid
            return token.equals(tokendb);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
