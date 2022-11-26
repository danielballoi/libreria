package com.api.libreria.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Prestito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data")
    private LocalDate data;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "id_utente", referencedColumnName = "id")
    private Utente utente;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "id_libro", referencedColumnName = "id")
    private Libro libro;


}