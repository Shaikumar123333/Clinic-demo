package com.project.clinic.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthResponse {
    private String token;
    private Integer userId;
    private String username;
    private String role;

}