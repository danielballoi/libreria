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
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "autor")
    private String autor;

    @OneToMany(mappedBy = "libro")
    @JsonBackReference
    private List<Prestito> prestitoList;

    public Libro(Long id, String title, String autor) {
        this.id = id;
        this.title = title;
        this.autor = autor;
    }
}