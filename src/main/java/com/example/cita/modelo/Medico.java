package com.example.cita.modelo;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import lombok.*;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int idMedico;
    public String nombres;
    public String apellidos;
    public String especialidad;
}
