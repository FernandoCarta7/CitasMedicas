package com.example.cita.modelo;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int idPaciente;
    public String nombres;
    public String apellidos;
    public String email;
    public LocalDate fechaNacimiento;
}
