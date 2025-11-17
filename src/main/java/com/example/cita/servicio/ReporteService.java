package com.example.cita.servicio;

import com.example.cita.modelo.Cita;
import com.example.cita.reportes.ReporteXML;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.PropertyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.io.StringWriter;
import java.util.List;

@Service
public class ReporteService {
    @Autowired
    CitaService citaService;

    public String getXml(){


        List<Cita> citas = citaService.getList();
        try {
            ReporteXML reporteXML = new ReporteXML();
            reporteXML.setCitas(citas);

            JAXBContext context = JAXBContext.newInstance(ReporteXML.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            StringWriter writer = new StringWriter();

            marshaller.marshal(reporteXML, writer);

            return writer.toString();


        } catch (PropertyException e) {
            throw new RuntimeException(e);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }

    }

}
