package org.example.printfour.repository;

import org.example.printfour.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    @Query("select u from User u where u.email = :email")
    Optional<User> findByEmail(String email);
}
