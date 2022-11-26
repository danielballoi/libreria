package com.api.libreria.controllers;

import com.api.libreria.entities.Pojos.UtentePojo;
import com.api.libreria.entities.Utente;
import com.api.libreria.facades.UtenteFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/utente")
public class UtenteController {
    @Autowired
    private UtenteFacade utenteFacade;

    @GetMapping("/findAll")
    public String findAll(Model model){
        List<Utente> utenteList= utenteFacade.findAll();
        model.addAttribute("utenti",utenteList );
        return "utente";
    }

    @GetMapping("/del/{id}")
    public String del(Model model, @PathVariable String id){
        utenteFacade.delete(id);
        return "redirect:/utente/findAll";
    }
    @GetMapping("/insertPage")
    public String insPage(Model model){
        model.addAttribute("utente", new UtentePojo());
        return "insertUser";
    }

    @PostMapping("/save")
    public String save(Model model, @ModelAttribute UtentePojo data){
        model.addAttribute("utente", data);
        utenteFacade.save(data);
        return "redirect:/utente/findAll";
    }

}
