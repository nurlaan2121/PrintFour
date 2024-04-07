package org.example.printfour;

import javafx.application.Application;
import org.example.printfour.service.UserService;
import org.example.printfour.service.impl.UserImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class MySpringBootApplication {
    public static void main(String[] args) {
        // Запускаем Spring Boot приложение
        ConfigurableApplicationContext context = SpringApplication.run(MySpringBootApplication.class, args);

        // Получаем бин HelloApplication из контекста
        HelloApplication helloApplication = context.getBean(HelloApplication.class);

        // Запускаем JavaFX приложение
        Application.launch(helloApplication.getClass(), args);

    }
    @Bean
    public PasswordEncoder passwordEncoder (){
        return new BCryptPasswordEncoder();
    }
}


