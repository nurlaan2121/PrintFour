package org.example.printfour.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.printfour.entities.User;
import org.example.printfour.repository.PhotoRepo;
import org.example.printfour.repository.UserRepo;
import org.example.printfour.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserImpl implements UserService {
    private final UserRepo userRepo;
    @Override
    public User signIn(String email, String password) {
        User user = userRepo.findByEmail(email).orElse(null);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
}
