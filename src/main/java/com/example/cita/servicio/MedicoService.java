package com.example.cita.servicio;

import com.example.cita.modelo.Medico;
import com.example.cita.modelo.Paciente;
import com.example.cita.repositorio.MedicoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoService implements IServiceMedico{


    @Autowired
    MedicoRepositorio medicoRepositorio;


    @Override
    public List<Medico> getList() {
        var lista = medicoRepositorio.findAll();
        lista.sort( (a,b) -> a.getEspecialidad().compareTo(b.getEspecialidad()) );
        return lista;
    }

    @Override
    public Medico save(Medico medico) {
        return medicoRepositorio.save(medico);
    }

    @Override
    public Medico findById(int id) {
        return medicoRepositorio.findById(id).orElse(null);
    }

    @Override
    public void deleteById(int id) {
        Medico medico = findById(id);
        if (medico != null) medicoRepositorio.deleteById(id);
    }
    public Page<Medico> getList(int page, int size) {
        Pageable pageable = PageRequest.of(page,size);
        var lista = medicoRepositorio.findAll(pageable);
        return lista;
    }
}
