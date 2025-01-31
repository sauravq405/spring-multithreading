package com.mt.demo.service;

import com.mt.demo.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;

@Service
@Slf4j
public class PracticeService {

    public ResponseEntity<?> practice() {
        Student student = Student.builder().grade("A").name("Saurav").rollNumber(405).build();
        log.info("Student: {}", student.toString());
        log.info("Class name: {}", this.getClass().getName());
        String uuid = UUID.randomUUID().toString();

        // Split the UUID into an array of strings
        String[] uuidParts = uuid.split("-");

        // Ensure we have at least 5 parts (0 to 4 index) to work with
        if (uuidParts.length >= 5) {
            // Randomly select an index from 0 to 4
            int randomIndex = (int) (Math.random() * 5); // 5 because we want 0, 1, 2, 3, or 4

            // Create a Map with the randomly selected part of the UUID
            Map<String, String> map = Map.of("randomUUID", uuidParts[randomIndex]);
            return ResponseEntity.ok(map);
        } else {
            // Handle the case where the UUID doesn't split into at least 5 parts (though this should not happen with UUID format)
            return ResponseEntity.badRequest().body(Map.of("error", "UUID format unexpected"));
        }
    }
}
