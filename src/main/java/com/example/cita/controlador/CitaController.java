package com.example.cita.controlador;

import com.example.cita.modelo.Cita;
import com.example.cita.servicio.CitaService;
import com.example.cita.servicio.ReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("app")
@CrossOrigin(value = "http://localhost:4200")
public class CitaController {

    @Autowired
    CitaService citaService;

    @Autowired
    ReporteService reporteService;
    
    @GetMapping("/cita")
    public Page<Cita> getList(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "0") int size
    ){
        return citaService.getList(page, size);
    }

    @GetMapping(value = "/xml", produces = "reporteCita/xml")
    public ResponseEntity<String> getReportXML(){
        String xml = reporteService.getXml();
        return ResponseEntity.ok().
                header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=ReporteXML.xml").
                body(xml);
    }

}
