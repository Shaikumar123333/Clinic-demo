package com.project.clinic.Security;

import com.project.clinic.Entity.Users;
import com.project.clinic.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {
    private final UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Users users = userRepo.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return new UserPrincipal(users);
        //hauifjaoj
    }
}
