/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ticketwizard.dtos;

import java.util.Date;
import ticketwizard.entidades.Eventos;
import ticketwizard.entidades.Personas;

/**
 *
 * @author santi
 */
public class BoletoTransferenciaDto {
    
    int codigoBoleto;
    private String fila;
    private String asiento;
    private String numeroSerie;
    private double costoOriginal;
    private String estado;
    Integer codigoTransaccion;
    Date fehcaHora;
    String tipoAdquision;

    public BoletoTransferenciaDto(int codigoBoleto, String fila, String asiento, String numeroSerie, double costoOriginal, String estado, Integer codigoTransaccion, Date fehcaHora, String tipoAdquision) {
        this.codigoBoleto = codigoBoleto;
        this.fila = fila;
        this.asiento = asiento;
        this.numeroSerie = numeroSerie;
        this.costoOriginal = costoOriginal;
        this.estado = estado;
        this.codigoTransaccion = codigoTransaccion;
        this.fehcaHora = fehcaHora;
        this.tipoAdquision = tipoAdquision;
    }

    public int getCodigoBoleto() {
        return codigoBoleto;
    }

    public String getFila() {
        return fila;
    }

    public String getAsiento() {
        return asiento;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public double getCostoOriginal() {
        return costoOriginal;
    }

    public String getEstado() {
        return estado;
    }

    public Integer getCodigoTransaccion() {
        return codigoTransaccion;
    }

    public Date getFehcaHora() {
        return fehcaHora;
    }

    public String getTipoAdquision() {
        return tipoAdquision;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.codigoBoleto;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BoletoTransferenciaDto other = (BoletoTransferenciaDto) obj;
        return this.codigoBoleto == other.codigoBoleto;
    }

    @Override
    public String toString() {
        return "BoletoTransferencia{" + "codigoBoleto=" + codigoBoleto + ", fila=" + fila + ", asiento=" + asiento + ", numeroSerie=" + numeroSerie + ", costoOriginal=" + costoOriginal + ", estado=" + estado + ", codigoTransaccion=" + codigoTransaccion + ", fehcaHora=" + fehcaHora + ", tipoAdquision=" + tipoAdquision + '}';
    }

    
}
