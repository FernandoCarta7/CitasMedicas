package com.example.cita.servicio;

import com.example.cita.modelo.Paciente;
import com.example.cita.repositorio.PacienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService implements IServicePaciente{


    @Autowired
    PacienteRepositorio pacienteRepositorio;


    @Override
    public List<Paciente> getList() {
        return pacienteRepositorio.findAll();
    }

    @Override
    public Paciente save(Paciente paciente) {
        return pacienteRepositorio.save(paciente);
    }

    @Override
    public Paciente findById(int id) {
        return pacienteRepositorio.findById(id).orElse(null);
    }

    @Override
    public void deleteById(int id) {
        Paciente paciente = findById(id);
        if (paciente != null) pacienteRepositorio.deleteById(id);
    }
}
