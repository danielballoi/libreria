package com.api.libreria.services;

import com.api.libreria.entities.Prestito;
import com.api.libreria.entities.Utente;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PrestitoServ {

    List<Prestito> findAll(Utente utente);
    Prestito save(Prestito prestito);
}
