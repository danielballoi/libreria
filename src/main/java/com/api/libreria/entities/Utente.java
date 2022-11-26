package com.api.libreria.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "cf")
    private String cf;

    @OneToMany(mappedBy = "utente")
    @JsonBackReference
    private List<Prestito> prestitoList;

    public Utente(Long id, String name, String cf) {
        this.id = id;
        this.name = name;
        this.cf = cf;
    }
}
