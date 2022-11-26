package com.api.libreria.repositories;

import com.api.libreria.entities.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibroRepo extends JpaRepository<Libro, Long> {

    List<Libro> findAllByOrderByTitle();
}
