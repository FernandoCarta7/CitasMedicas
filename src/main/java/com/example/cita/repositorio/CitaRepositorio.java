package com.example.cita.repositorio;

import com.example.cita.modelo.Cita;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CitaRepositorio extends JpaRepository<Cita, Integer> {
}
