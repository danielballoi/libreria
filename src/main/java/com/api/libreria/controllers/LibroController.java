package com.api.libreria.controllers;

import com.api.libreria.entities.Libro;
import com.api.libreria.entities.Pojos.LibroPojo;
import com.api.libreria.entities.Pojos.UtentePojo;
import com.api.libreria.entities.Utente;
import com.api.libreria.facades.LibroFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/libro")
public class LibroController {
    @Autowired
    private LibroFacade libroFacade;

    @GetMapping("/findAll")
    public String findAll(Model model){
        List<Libro> libroList= libroFacade.findAll();
        model.addAttribute("libri",libroList );
        return "libro";
    }

    @GetMapping("/del/{id}")
    public String del(Model model, @PathVariable String id){
        libroFacade.deleteById(id);
        return "redirect:/libro/findAll";
    }
    @GetMapping("/insertPage")
    public String insPage(Model model){
        model.addAttribute("libro", new LibroPojo());
        return "insertBook";
    }

    @PostMapping("/save")
    public String save(Model model, @ModelAttribute LibroPojo data){
        model.addAttribute("libro", data);
        libroFacade.save(data);
        return "redirect:/libro/findAll";
    }
}
