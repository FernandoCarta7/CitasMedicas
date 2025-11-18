package com.example.cita.reportes;

import com.example.cita.modelo.Cita;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "ReporteXML")
@XmlAccessorType(XmlAccessType.FIELD)
public class ReporteXML {
    private List<Cita> citas;
    private int totalCitas;
    private double porcentajeCardiologia;

    public List<Cita> getCitas() {
        return citas;
    }

    public void setCitas(List<Cita> citas) {
        this.citas = citas;
    }

    public int getTotalCitas(){ return totalCitas; }

    public void setTotalCitas(int totalCitas) {
        this.totalCitas = totalCitas;
    }

    public double getPorcentajeCardiologia() {
        return porcentajeCardiologia;
    }

    public void setPorcentajeCardiologia(double porcentajeCardiologia) {
        this.porcentajeCardiologia = porcentajeCardiologia;
    }
}
