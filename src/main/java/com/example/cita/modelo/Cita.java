package com.example.cita.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Cita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id_cita;
    public LocalDate fecha_cita;

    @ManyToOne
    @JoinColumn(name = "fk_id_medico")
    private Medico medico;

    @ManyToOne
    @JoinColumn(name = "fk_id_paciente")
    private Paciente paciente;
}
