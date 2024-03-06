package com.example.userservice.model;

import com.example.userservice.enums.ERole;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("users")
public class User {
    @Id
    private String id;
    private String username;
    private String password;
    private String email;
    private ERole role;
    private String bc32SecretKeyForGeneratingTotp;
    private Long pixelNumber = 0l;
}
