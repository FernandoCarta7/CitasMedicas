package com.example.cita.servicio;

import com.example.cita.modelo.Cita;
import com.example.cita.repositorio.CitaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public Page<Cita> getList(int page, int size) {
        Pageable pageable = PageRequest.of(page,size);
        var lista = citaRepositorio.findAll(pageable);
        return lista;
    }
    public void deleteByPaciente(int id_paciente){
        var lista = this.citaRepositorio.findByPaciente_idPaciente(id_paciente);

        for (int i = 0; i < lista.size(); i++) {
            this.citaRepositorio.deleteById(lista.get(i).idCita);
        }
    }
}
