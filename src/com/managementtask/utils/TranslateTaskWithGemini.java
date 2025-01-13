package com.managementtask.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.managementtask.models.Task;

import java.util.Map;

public class TranslateTaskWithGemini {
    public String result(Task task) {
        // Menggunakan Jackson ObjectMapper untuk membuat JSON
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        try {
            // Mengubah objek Task menjadi JSON string
            String taskJson = objectMapper.writeValueAsString(task);

            // Membuat body JSON secara langsung menggunakan ObjectMapper
            ObjectNode bodyNode = objectMapper.createObjectNode();
            ObjectNode contentNode = objectMapper.createObjectNode();
            ObjectNode partNode = objectMapper.createObjectNode();

            partNode.put("text",
                "Berikan pengumuman ke group whatsapp kelas prodi Informatika bahwa ada tugas baru nih dari Pak/Bu Dosen dengan gaya gen Z atau gen alpha dan jangan kelihatan seperti generate ai ya, tugasnya sebagai berikut: "
                + taskJson +
                "\n. Salam -Management Task.");
            contentNode.putArray("parts").add(partNode);
            bodyNode.putArray("contents").add(contentNode);

            // Mengonversi bodyNode menjadi string JSON
            String body = objectMapper.writeValueAsString(bodyNode);
            System.out.println("Request Body: " + body);

            String url = "https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash:generateContent?key=";

            // Mengirimkan request POST
            String response = Fetch.post(url,
                Map.of("Content-Type", "application/json"),
                body);

            System.out.println("Response Gemini: " + response);

            // Membaca respons JSON dan mengambil teks dari 'text'
            JsonNode rootNode = objectMapper.readTree(response);
            JsonNode textNode = rootNode
                .path("candidates") // Mengambil array "candidates"
                .path(0)            // Elemen pertama dari array
                .path("content")    // Objek "content"
                .path("parts")      // Mengambil array "parts"
                .path(0)            // Elemen pertama dari array
                .path("text");      // Mengambil field "text"

            // Periksa apakah field "text" ditemukan
            if (textNode.isMissingNode()) {
                System.out.println("Field 'text' tidak ditemukan dalam respons.");
                return null;
            }

            // Mengambil nilai dari field "text"
            String resultText = textNode.asText();
            System.out.println("Text dari respons: " + resultText);

            return resultText;

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Gagal memproses permintaan.");
            return null;
        }
    }
}
