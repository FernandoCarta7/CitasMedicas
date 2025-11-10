package com.example.cita.servicio;

import com.example.cita.modelo.Cita;
import com.example.cita.repositorio.CitaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitaService implements IServiceCita{

    @Autowired
    CitaRepositorio citaRepositorio;

    @Override
    public List<Cita> getList() {
        return citaRepositorio.findAll();
    }

    @Override
    public Cita save(Cita cita) {
        return citaRepositorio.save(cita);
    }

    @Override
    public Cita findById(int id) {
        return citaRepositorio.findById(id).orElse(null);
    }

    @Override
    public void deleteById(int id) {
        Cita cita = findById(id);
        if (cita != null) citaRepositorio.deleteById(id);
    }
}
