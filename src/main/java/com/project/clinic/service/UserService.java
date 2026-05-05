package com.project.clinic.service;

import com.project.clinic.DTO.AuthResponse;
import com.project.clinic.DTO.UserDTO;
import com.project.clinic.Entity.Users;
import com.project.clinic.ModelMapper.ModelMapper;
import com.project.clinic.Security.JwtUtility;
import com.project.clinic.exception.UserNotFoundException;
import com.project.clinic.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;
    private final PasswordEncoder encoder;
    private final JwtUtility jwtUtility;

    public UserDTO createUser(Users user) {
        Users newUser = new Users();
        newUser.setRole(Users.Role.USER);
        newUser.setName(user.getName());
        newUser.setPassword(encoder.encode(user.getPassword()));
        newUser.setEmail(user.getEmail());
        return ModelMapper.toUserDTO(userRepo.save(newUser));
    }
    public AuthResponse login(String email, String password) {
        Users user = userRepo.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException(email + " User not found"));

        if (!encoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        // 🎟️ token with email
        String token = jwtUtility.generateToken(user.getEmail());

        return new AuthResponse(
                token,
                user.getId(),
                user.getName(),
                user.getRole().name()
        );
    }


}