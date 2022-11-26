package com.api.libreria.controllers;

import com.api.libreria.entities.Libro;
import com.api.libreria.entities.Pojos.LibroPojo;
import com.api.libreria.entities.Pojos.PrestitoPojo;
import com.api.libreria.entities.Prestito;
import com.api.libreria.entities.Utente;
import com.api.libreria.facades.LibroFacade;
import com.api.libreria.facades.PrestitoFacade;
import com.api.libreria.facades.UtenteFacade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/prestito")
public class PrestitoController {
    @Autowired
    private PrestitoFacade prestitoFacade;
    @Autowired
    private UtenteFacade utenteFacade;
    @Autowired
    private LibroFacade libroFacade;

    @GetMapping("/findAll/{id}")
    public String findAll(Model model, @PathVariable String id){
        Utente utente= utenteFacade.findById(id);
        model.addAttribute("utente", utente);
        List<Prestito> prestitoList= prestitoFacade.findAllByUtente(id);
        model.addAttribute("prestiti",prestitoList );


        return "prestito";
    }

    @GetMapping("/insertPage/{id}")
    public String insPage(Model model, @PathVariable String id){
        List<Libro> libroList = libroFacade.findAll();
        Utente utente= utenteFacade.findById(id);
        model.addAttribute("utente", utente);
        model.addAttribute("libri", libroList);
        model.addAttribute("prestito", new PrestitoPojo());
        return "insertPrestito";
    }

    @PostMapping("/save/{id}")
    public String save(Model model, @ModelAttribute PrestitoPojo data, @PathVariable String id){

        data.setIdUtente(id);
        model.addAttribute("prestito", data);
        prestitoFacade.save(data);
        return "redirect:/prestito/findAll/"+id;
    }
}
