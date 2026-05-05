package com.project.clinic.Controller;


import com.project.clinic.DTO.AuthResponse;
import com.project.clinic.DTO.UserDTO;
import com.project.clinic.Entity.Users;
import com.project.clinic.ModelMapper.ModelMapper;
import com.project.clinic.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserDTO> register(@RequestBody Users user) {
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody Users user) {
        return new ResponseEntity<>(userService.login(user.getEmail(), user.getPassword()),HttpStatus.OK);
    }
}