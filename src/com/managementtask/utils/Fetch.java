package com.managementtask.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class Fetch {

    // Method utama untuk membuat request
    public static String request(String urlString, String method, Map<String, String> headers, String body) throws Exception {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // Set metode HTTP
        connection.setRequestMethod(method);

        // Set header jika ada
        if (headers != null) {
            for (Map.Entry<String, String> header : headers.entrySet()) {
                connection.setRequestProperty(header.getKey(), header.getValue());
            }
        }

        // Jika ada body dan metode mendukung body (POST, PUT, dll)
        if (body != null && (method.equals("POST") || method.equals("PUT") || method.equals("PATCH"))) {
            connection.setDoOutput(true);
            try (OutputStream os = connection.getOutputStream();
                 BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"))) {
                writer.write(body);
                writer.flush();
            }
        }

        // Membaca respons dari server
        int responseCode = connection.getResponseCode();
        BufferedReader reader;
        if (responseCode >= 200 && responseCode < 300) {
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        } else {
            reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
        }

        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        connection.disconnect();
        return response.toString();
    }

    // Helper untuk metode GET
    public static String get(String urlString, Map<String, String> headers) throws Exception {
        return request(urlString, "GET", headers, null);
    }

    // Helper untuk metode POST
    public static String post(String urlString, Map<String, String> headers, String body) throws Exception {
        return request(urlString, "POST", headers, body);
    }

    // Helper untuk metode PUT
    public static String put(String urlString, Map<String, String> headers, String body) throws Exception {
        return request(urlString, "PUT", headers, body);
    }

    // Helper untuk metode DELETE
    public static String delete(String urlString, Map<String, String> headers) throws Exception {
        return request(urlString, "DELETE", headers, null);
    }
}