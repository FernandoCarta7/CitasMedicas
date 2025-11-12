package com.example.cita.controlador;

import com.example.cita.modelo.Paciente;
import com.example.cita.servicio.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("app")
@CrossOrigin(value = "http://localhost:4200")
public class PacienteController {

    @Autowired
    PacienteService pacienteService;


    /*@GetMapping("/paciente")
    public List<Paciente> getClientes(){
        List<Paciente> lista = pacienteService.getList();
        return lista;
    }*/

    @GetMapping("/paciente")
    public Page<Paciente> getList(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "0") int size
    ){
        return pacienteService.getList(page, size);
    }

}
