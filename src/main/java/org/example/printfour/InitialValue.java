package org.example.printfour;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.example.printfour.entities.User;
import org.example.printfour.enums.Role;
import org.example.printfour.repository.UserRepo;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class InitialValue {
    private final UserRepo userRepo;


    @PostConstruct
    private void init() {
        userRepo.save(new User("admin@gmail.com","1234", Role.ADMIN));
    }
    @Bean
    private PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
