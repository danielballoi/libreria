package com.api.libreria.entities.Pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrestitoPojo {
    private String data;
    private String idUtente;
    private String idLibro;

}
