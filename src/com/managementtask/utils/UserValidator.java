package com.managementtask.utils;

import com.managementtask.models.User;
import com.managementtask.services.UserService;
import java.util.regex.*;

public class UserValidator {
    private static UserService userService = new UserService();
    // Validasi email menggunakan regex
    private static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    // Validasi password (minimal 8 karakter, harus mengandung angka dan huruf)
    private static boolean isValidPassword(String password) {
        String passwordRegex = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$";
        Pattern pattern = Pattern.compile(passwordRegex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    // Validasi nomor telepon (minimal 10 digit)
    private static boolean isValidPhoneNumber(String phoneNumber) {
        String phoneRegex = "^62\\d{8,11}$";
        Pattern pattern = Pattern.compile(phoneRegex);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }

    // Validasi nama, hanya mengizinkan huruf dan spasi
    private static boolean isValidName(String name) {
        String nameRegex = "^[a-zA-Z\\s]+$";
        Pattern pattern = Pattern.compile(nameRegex);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }

    // Validasi bahwa input tidak kosong
    private static boolean isNotEmpty(String value) {
        return value != null && !value.trim().isEmpty();
    }

    // Validasi apakah email sudah terdaftar
    private static boolean isEmailAlreadyRegistered(String email) {
    User existUser;
        existUser = userService.getUser(email);
   
    if (existUser != null) {
        return true;
    }
    
    return false;
}


    // Helper method 
    public static String validateUser(String name, String email, String phoneNumber, String password) {
        if (!isNotEmpty(name)) {
            return "Nama tidak boleh kosong.";
        }
        
        if (!isValidName(name)) {
            return "Nama hanya boleh mengandung huruf dan spasi.";
        }
        
        if (!isNotEmpty(email)) {
            return "Email tidak boleh kosong.";
        }
        
        if (!isValidEmail(email)) {
            return "Email tidak valid.";
        }
        
        if (isEmailAlreadyRegistered(email)) {
            return "Email sudah terdaftar.";
        }
        
        if (!isNotEmpty(phoneNumber)) {
            return "Nomor telepon tidak boleh kosong.";
        }
        
        if (!isValidPhoneNumber(phoneNumber)) {
            return "Nomor telepon tidak valid.";
        }
        
        if (!isNotEmpty(password)) {
            return "Password tidak boleh kosong.";
        }
        
        if (!isValidPassword(password)) {
            return "Password harus mengandung minimal 8 karakter, angka, dan huruf.";
        }
        
        return null; // Jika semua validasi lolos
    }
}
