package com.api.libreria.services;

import com.api.libreria.entities.Utente;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UtenteServ {
    List<Utente> findAll();
    Utente findById(Long id);
    Utente save(Utente utente);
    void deleteById(Long id);

}
