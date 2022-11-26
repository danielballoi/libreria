package com.api.libreria.services.impl;

import com.api.libreria.entities.Libro;
import com.api.libreria.repositories.LibroRepo;
import com.api.libreria.services.LibroServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import java.util.List;

@Component
public class LibroServImpl implements LibroServ {
    @Autowired
    private LibroRepo libroRepo;

    @Override
    public List<Libro> findAll() {
        return libroRepo.findAllByOrderByTitle();
    }

    @Override
    public Libro findById(Long id) {
        return libroRepo.findById(id).orElse(null);
    }

    @Override
    public Libro save(Libro libro) {
        return libroRepo.save(libro);
    }

    @Override
    public void deleteById(Long id) {
        libroRepo.deleteById(id);
    }
}
