package org.example.printfour.service;

import org.example.printfour.entities.User;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@Repository
@Component

public interface UserService {
    User signIn(String email, String password);
}
