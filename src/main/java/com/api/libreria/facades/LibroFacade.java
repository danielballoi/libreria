package com.api.libreria.facades;

import com.api.libreria.entities.Libro;
import com.api.libreria.entities.Pojos.LibroPojo;
import com.api.libreria.services.LibroServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LibroFacade {
    @Autowired
    private LibroServ libroServ;

    public List<Libro> findAll(){
        List<Libro> libroList = libroServ.findAll();
        return libroList;
    }

    public Libro findById(String id){
        Libro libro = libroServ.findById(Long.valueOf(id));
        return libro;
    }

    public Libro save(LibroPojo data){
        Libro libro = new Libro(null, data.getTitle(), data.getAutor());
        return libroServ.save(libro);
    }

    public void deleteById(String id){
        libroServ.deleteById(Long.valueOf(id));
    }
}
