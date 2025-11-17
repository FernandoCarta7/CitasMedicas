package com.example.cita.modelo;

import com.example.cita.Adapter.LocalDateAdapter;
import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
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
@XmlRootElement(name = "cita")
@XmlAccessorType(XmlAccessType.FIELD)
public class Cita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCita;
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    private LocalDate fechaCita;

    @ManyToOne
    @JoinColumn(name = "fk_id_medico")
    private Medico medico;

    @ManyToOne
    @JoinColumn(name = "fk_id_paciente")
    private Paciente paciente;
}
