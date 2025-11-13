package com.example.cita.controlador;

import com.example.cita.modelo.Cita;
import com.example.cita.servicio.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("app")
@CrossOrigin(value = "http://localhost:4200")
public class CitaController {
    @Autowired
    CitaService citaService;
    
    @GetMapping("/cita")
    public Page<Cita> getList(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "0") int size
    ){
        return citaService.getList(page, size);
    }
}
