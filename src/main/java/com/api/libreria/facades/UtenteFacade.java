package com.api.libreria.facades;

import com.api.libreria.entities.Pojos.UtentePojo;
import com.api.libreria.entities.Utente;
import com.api.libreria.services.UtenteServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UtenteFacade {
    @Autowired
    private UtenteServ utenteServ;

    public List<Utente> findAll(){
       return utenteServ.findAll();
    }

    public Utente findById(String id){
        return utenteServ.findById(Long.valueOf(id));
    }

    public Utente save(UtentePojo data){
        Utente newUtente =new Utente(null, data.getName(), data.getCf());
        utenteServ.save(newUtente);
        return newUtente;
    }

    public void delete(String id){
        utenteServ.deleteById(Long.valueOf(id));
    }
}
