package com.api.libreria.facades;

import com.api.libreria.entities.Libro;
import com.api.libreria.entities.Pojos.PrestitoPojo;
import com.api.libreria.entities.Pojos.UtentePojo;
import com.api.libreria.entities.Prestito;
import com.api.libreria.entities.Utente;
import com.api.libreria.services.LibroServ;
import com.api.libreria.services.PrestitoServ;
import com.api.libreria.services.UtenteServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
public class PrestitoFacade {
    @Autowired
    private PrestitoServ prestitoServ;
    @Autowired
    private UtenteServ utenteServ;
    @Autowired
    private LibroServ libroServ;

    public List<Prestito> findAllByUtente( String id){
        Utente utente= utenteServ.findById(Long.valueOf(id));
        return prestitoServ.findAll(utente);
    }
    public Prestito save(PrestitoPojo data){
        Utente utente= utenteServ.findById(Long.valueOf(data.getIdUtente()));
        Libro libro= libroServ.findById(Long.valueOf(data.getIdLibro()));
        DateTimeFormatter f = DateTimeFormatter.ofPattern( "yyyy-MM-dd" );
        LocalDate date = LocalDate.parse( data.getData() , f );
        Prestito prestito= new Prestito(null,date,utente, libro);
        return prestitoServ.save(prestito);
    }
}
