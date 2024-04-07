package org.example.printfour.repository;

import org.example.printfour.entities.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoRepo extends JpaRepository<Photo,Long> {
}
