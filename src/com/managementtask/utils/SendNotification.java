package com.managementtask.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;

public class SendNotification {
    public void toWhatsapp(String text, String recipient) {
        String apiUrl = "http://localhost:4729/send-message";
        //        String recipient = "120363169499365755@g.us";

        // Membuat body JSON menggunakan ObjectMapper
        Map<String, String> payload = Map.of(
            "text", text,
            "recipient", recipient
        );

        try {
            // Konversi objek menjadi JSON string
            ObjectMapper objectMapper = new ObjectMapper();
            String body = objectMapper.writeValueAsString(payload);

            System.out.println("Body WA : " + body);

            // Mengirimkan request
            String response = Fetch.post(apiUrl, Map.of("Content-Type", "application/json"), body);
            System.out.println("Response WA : " + response);

        } catch (Exception ex) {
            System.out.println("Gagal mengirimkan notifikasi ke Whatsapp");
            ex.printStackTrace();
        }
    }
}
