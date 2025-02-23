/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ticketwizard.entidades;

import java.util.Objects;

/**
 * Clase que representa a los boletos
 * @author santi
 */
public class Boletos {
    /**    
     * 
     * 
     */
    Integer codigoBoleto;
    String fila;
    String asiento;
    String numeroIntero;
    Integer codigoUsuario;
    Integer codigoEvento;
    String numeroSerie;
    float costo;
    float costoOriginal;
    String Estado;
    
    /**    
     * Constructor que inicializa todos los atributosde la clase con el valor de los parametor
     *
     * @param codigoBoleto codigoIdentificar del boleto
     * @param fila la fila donde es el boleto en el recinto
     * @param asiento asiento especifico del boleto 
     * @param numeroIntero  numero interno del reciento donde se encuentra
     * @param codigoUsuario el numero identificador del dueño del boleto 
     * @param codigoEvento el numero identificador del evento al que pertenece
     * @param Estado estado en el que se encuentra el voleto si esta en espera con dueño a la venta
     * 
     */

    public Boletos(Integer codigoBoleto, String fila, String asiento, String numeroIntero, Integer codigoUsuario, Integer codigoEvento, String numeroSerie, float costo, float costoOriginal, String Estado) {
        this.codigoBoleto = codigoBoleto;
        this.fila = fila;
        this.asiento = asiento;
        this.numeroIntero = numeroIntero;
        this.codigoUsuario = codigoUsuario;
        this.codigoEvento = codigoEvento;
        this.numeroSerie = numeroSerie;
        this.costo = costo;
        this.costoOriginal = costoOriginal;
        this.Estado = Estado;
    }

    /**    
     * Constructor que inicializa todos los atributosde la clase con el valor de los parametos exceptuando
     * el codigo
     *
     * @param fila la fila donde es el boleto en el recinto
     * @param asiento asiento especifico del boleto 
     * @param numeroIntero  numero interno del reciento donde se encuentra
     * @param codigoUsuario el numero identificador del dueño del boleto 
     * @param codigoEvento el numero identificador del evento al que pertenece
     * @param Estado estado en el que se encuentra el voleto si esta en espera con dueño a la venta
     * 
     */
    public Boletos(String fila, String asiento, String numeroIntero, Integer codigoUsuario, Integer codigoEvento, String numeroSerie, float costo, float costoOriginal, String Estado) {
        this.fila = fila;
        this.asiento = asiento;
        this.numeroIntero = numeroIntero;
        this.codigoUsuario = codigoUsuario;
        this.codigoEvento = codigoEvento;
        this.numeroSerie = numeroSerie;
        this.costo = costo;
        this.costoOriginal = costoOriginal;
        this.Estado = Estado;
    }

    public Integer getCodigoBoleto() {
        return codigoBoleto;
    }

    public String getFila() {
        return fila;
    }

    public String getAsiento() {
        return asiento;
    }

    public String getNumeroIntero() {
        return numeroIntero;
    }

    public Integer getCodigoUsuario() {
        return codigoUsuario;
    }

    public Integer getCodigoEvento() {
        return codigoEvento;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public float getCosto() {
        return costo;
    }

    public float getCostoOriginal() {
        return costoOriginal;
    }

    public String getEstado() {
        return Estado;
    }

    @Override
    public String toString() {
        return "Boletos{" + "codigoBoleto=" + codigoBoleto + ", fila=" + fila + ", asiento=" + asiento + ", numeroIntero=" + numeroIntero + ", codigoUsuario=" + codigoUsuario + ", codigoEvento=" + codigoEvento + ", numeroSerie=" + numeroSerie + ", costo=" + costo + ", costoOriginal=" + costoOriginal + ", Estado=" + Estado + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.codigoBoleto);
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
        final Boletos other = (Boletos) obj;
        return Objects.equals(this.codigoBoleto, other.codigoBoleto);
    }
    
    
    
    
    
}
