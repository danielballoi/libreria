package com.api.libreria.services.impl;

import com.api.libreria.entities.Utente;
import com.api.libreria.repositories.UtenteRepo;
import com.api.libreria.services.UtenteServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UtenteServImpl implements UtenteServ {
    @Autowired
    private UtenteRepo utenteRepo;

    @Override
    public List<Utente> findAll() {
        return utenteRepo.findAllByOrderByName();
    }

    @Override
    public Utente findById(Long id) {
        return utenteRepo.findById(id).orElse(null);
    }

    @Override
    public Utente save(Utente utente) {
        return utenteRepo.save(utente);
    }

    @Override
    public void deleteById(Long id) {
        utenteRepo.deleteById(id);
    }
}
