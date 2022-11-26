package com.api.libreria.services;

import com.api.libreria.entities.Libro;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LibroServ {
    List<Libro> findAll();
    Libro findById(Long id);
    Libro save(Libro libro);
    void deleteById(Long id);
}
