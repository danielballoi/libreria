package com.api.libreria.services.impl;

import com.api.libreria.entities.Prestito;
import com.api.libreria.entities.Utente;
import com.api.libreria.repositories.PrestitoRepo;
import com.api.libreria.services.PrestitoServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PrestitoServImpl implements PrestitoServ {
    @Autowired
    private PrestitoRepo prestitoRepo;

    @Override
    public List<Prestito> findAll(Utente utente) {
        return prestitoRepo.findAllByUtente(utente);
    }

    @Override
    public Prestito save(Prestito prestito) {
        return prestitoRepo.save(prestito);
    }
}
