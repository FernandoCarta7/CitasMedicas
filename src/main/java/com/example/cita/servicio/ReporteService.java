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
        /*
        * Total de citas
        * % de citas de cardiologias
        *
        * */

        List<Cita> citas = citaService.getList();
        int totalCitas = citas.size();
        try {
            ReporteXML reporteXML = new ReporteXML();
            reporteXML.setCitas(citas);
            reporteXML.setTotalCitas(totalCitas);
            reporteXML.setPorcentajeCardiologia(porcentajeCitasCardiologia(citas, reporteXML.getTotalCitas()));

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

    public double porcentajeCitasCardiologia( List<Cita> citas, int totalCitas ){
        boolean bandera = false;
        int contador = 0;
        String especialidad = "Cardiología";
        String compare = "";
        int indiceInicio = 0;
        int indiceFinal = 0;
        int i = 0;
        double porcentaje = 0;
        while ( !bandera ){
            compare = citas.get(i).getMedico().getEspecialidad();
            if (especialidad.equals(compare) && (contador == 0) ){
                contador++;
                indiceInicio = i;

            } else if (especialidad.equals(compare)) {
                contador++;
            } else if (!especialidad.equals(compare) && contador !=0 && indiceFinal == 0) {
                indiceFinal = i;
                bandera = true;
            }
            i++;
        }



        porcentaje = (contador * 1.0 / totalCitas * 1.0) * 100;
        return porcentaje;
    }


}
