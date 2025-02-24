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

     /**
     * Constructor para inicializar un objeto BoletoTransferenciaDto con los detalles proporcionados.
     * 
     * @param codigoBoleto        el código único del boleto
     * @param fila                la fila del asiento
     * @param asiento             el número de asiento
     * @param numeroSerie         el número de serie del boleto
     * @param costoOriginal       el costo original del boleto
     * @param estado              el estado del boleto
     * @param codigoTransaccion   el código de transacción asociado
     * @param fehcaHora           la fecha y hora de la transacción
     * @param tipoAdquision       el tipo de adquisición
     */
    public BoletoTransferenciaDto(int codigoBoleto, String fila, String asiento, 
                                  String numeroSerie, double costoOriginal, 
                                  String estado, Integer codigoTransaccion, 
                                  Date fehcaHora, String tipoAdquision) {
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

    /**
     * Obtiene el código del boleto.
     * 
     * @return el código del boleto
     */
    public int getCodigoBoleto() {
        return codigoBoleto;
    }

    /**
     * Obtiene la fila del asiento.
     * 
     * @return la fila del asiento
     */
    public String getFila() {
        return fila;
    }

    /**
     * Obtiene el número de asiento.
     * 
     * @return el número de asiento
     */
    public String getAsiento() {
        return asiento;
    }

    /**
     * Obtiene el número de serie del boleto.
     * 
     * @return el número de serie del boleto
     */
    public String getNumeroSerie() {
        return numeroSerie;
    }

    /**
     * Obtiene el costo original del boleto.
     * 
     * @return el costo original del boleto
     */
    public double getCostoOriginal() {
        return costoOriginal;
    }

    /**
     * Obtiene el estado del boleto.
     * 
     * @return el estado del boleto
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Obtiene el código de transacción asociado al boleto.
     * 
     * @return el código de transacción
     */
    public Integer getCodigoTransaccion() {
        return codigoTransaccion;
    }

    /**
     * Obtiene la fecha y hora de la transacción del boleto.
     * 
     * @return la fecha y hora de la transacción
     */
    public Date getFehcaHora() {
        return fehcaHora;
    }

    /**
     * Obtiene el tipo de adquisición del boleto.
     * 
     * @return el tipo de adquisición
     */
    public String getTipoAdquision() {
        return tipoAdquision;
    }

    /**
     * Calcula el valor del código hash para el objeto BoletoTransferenciaDto, basado en el código del boleto.
     * 
     * @return el valor del código hash
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.codigoBoleto;
        return hash;
    }

    /**
     * Compara dos objetos BoletoTransferenciaDto para determinar si son iguales.
     * La comparación se realiza basándose en el código del boleto.
     * 
     * @param obj el objeto con el que se compara
     * @return true si los objetos son iguales, false en caso contrario
     */
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

    /**
     * Genera una representación en cadena del objeto BoletoTransferenciaDto.
     * 
     * @return una cadena representando el objeto BoletoTransferenciaDto
     */
    @Override
    public String toString() {
        return "BoletoTransferencia{" + "codigoBoleto=" + codigoBoleto + ", fila=" + fila + 
               ", asiento=" + asiento + ", numeroSerie=" + numeroSerie + ", costoOriginal=" + 
               costoOriginal + ", estado=" + estado + ", codigoTransaccion=" + codigoTransaccion + 
               ", fehcaHora=" + fehcaHora + ", tipoAdquision=" + tipoAdquision + '}';
    }

    
}
