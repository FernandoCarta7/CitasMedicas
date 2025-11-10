package com.example.cita.modelo;

import jakarta.persistence.*;
import lombok.*;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id_medico;
    public String Nombres;
    public String Apellidos;
    public String Especialidad;
}
