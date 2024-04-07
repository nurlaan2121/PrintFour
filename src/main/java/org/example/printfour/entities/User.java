package org.example.printfour.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.printfour.enums.Role;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(generator = "increment",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "increment",allocationSize = 1)
    private Long id;
    @Email
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
    @OneToMany
    private List<Photo> photos = new ArrayList<>();
    @OneToMany
    private List<User> users = new ArrayList<>();

    public User(String email, String password, Role role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }
}
