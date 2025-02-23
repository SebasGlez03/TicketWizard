/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ticketwizard.entidades;

import java.util.Objects;

/**
 * Esta clase esta encargada de crear los atributos de la tabla Boletos
 *
 * @author PC
 */
public class Boletos {

    private Integer codigoBoleto;
    private String fila;
    private String asiento;
    private Personas codigoPersona;
    private Eventos codigoEvento;
    private String numeroSerie;
    private double costoOriginal;
    private double costo;
    private String estado;

    /**
     * Constructor que inicializa todos los atributos de la clase con el valor
     * de sus parametros
     *
     * @param codigoBoleto Codigo identificador del boleto
     * @param fila Fila del boleto
     * @param asiento Asiento del boleto
     * @param codigoPersona Codigo identificador de la persona a la que le
     * pertenece el boleto
     * @param codigoEvento Codigo identificador del evento al que le pertenece
     * el boleto
     * @param numeroSerie Numero de serie que contiene el boleto
     * @param costoOriginal Costo original del boleto
     * @param costo Costo actual del boleto
     * @param estado Estado del boleto ("En espera", "En venta", "Con dueño")
     */
    public Boletos(Integer codigoBoleto, String fila, String asiento, Personas codigoPersona, Eventos codigoEvento, String numeroSerie, double costoOriginal, double costo, String estado) {
        this.codigoBoleto = codigoBoleto;
        this.fila = fila;
        this.asiento = asiento;
        this.codigoPersona = codigoPersona;
        this.codigoEvento = codigoEvento;
        this.numeroSerie = numeroSerie;
        this.costoOriginal = costoOriginal;
        this.costo = costo;
        this.estado = estado;
    }

    /**
     * Constructor que inicializa todos los atributos de la clase con el valor
     * de sus parametros a excepcion del codigo identificador del boleto
     *
     * @param fila Fila del boleto
     * @param asiento Asiento del boleto
     * @param codigoPersona Codigo identificador de la persona a la que le
     * pertenece el boleto
     * @param codigoEvento Codigo identificador del evento al que le pertenece
     * el boleto
     * @param numeroSerie Numero de serie que contiene el boleto
     * @param costoOriginal Costo original del boleto
     * @param costo Costo actual del boleto
     * @param estado Estado del boleto ("En espera", "En venta", "Con dueño")
     */
    public Boletos(String fila, String asiento, Personas codigoPersona, Eventos codigoEvento, String numeroSerie, double costoOriginal, double costo, String estado) {
        this.fila = fila;
        this.asiento = asiento;
        this.codigoPersona = codigoPersona;
        this.codigoEvento = codigoEvento;
        this.numeroSerie = numeroSerie;
        this.costoOriginal = costoOriginal;
        this.costo = costo;
        this.estado = estado;
    }

    /**
     * Constructor que inicializa todos los atributos de la clase con el valor
     * de sus parametros a excepcion del codigo identificador y las llaves
     * foraneas
     *
     * @param fila Fila del boleto
     * @param asiento Asiento del boleto
     * @param numeroSerie Numero de serie que contiene el boleto
     * @param costoOriginal Costo original del boleto
     * @param costo Costo actual del boleto
     * @param estado Estado del boleto ("En espera", "En venta", "Con dueño")
     */
    public Boletos(String fila, String asiento, String numeroSerie, double costoOriginal, double costo, String estado) {
        this.fila = fila;
        this.asiento = asiento;
        this.numeroSerie = numeroSerie;
        this.costoOriginal = costoOriginal;
        this.costo = costo;
        this.estado = estado;
    }

    /**
     * Obtiene el codigo identificador del boleto
     *
     * @return Codigo identificador del boleto
     */
    public Integer getCodigoBoleto() {
        return codigoBoleto;
    }


    /**
     * Establece el codigo identificador del boleto
     *
     * @param codigoBoleto Codigo identificador del boleto a establecer
     */
    public void setCodigoBoleto(Integer codigoBoleto) {
        this.codigoBoleto = codigoBoleto;
    }

    /**
     * Obtiene la fila del boleto
     *
     * @return Fila del boleto
     */
    public String getFila() {
        return fila;
    }

    /**
     * Establece la fila del boleto
     *
     * @param fila Fila del boleto a establecer
     */
    public void setFila(String fila) {
        this.fila = fila;
    }

    /**
     * Obtiene el asiento del boleto
     *
     * @return Asiento del boleto a establecer
     */
    public String getAsiento() {
        return asiento;
    }

    /**
     * Establece el asiento del boleto
     *
     * @param asiento Asiento del boleto a establecer
     */
    public void setAsiento(String asiento) {
        this.asiento = asiento;
    }

    /**
     * Obtiene el codigo identificador de la persona
     *
     * @return Codigo identificador de la persona
     */
    public Personas getCodigoPersona() {
        return codigoPersona;
    }

    /**
     * Establece el codigo identificador de la persona
     *
     * @param codigoPersona Codigo identificador de la persona a establecer
     */
    public void setCodigoPersona(Personas codigoPersona) {
        this.codigoPersona = codigoPersona;
    }

    /**
     * Obtiene el codigo identificador del evento
     *
     * @return Codigo identificador del evento
     */
    public Eventos getCodigoEvento() {
        return codigoEvento;
    }

    /**
     * Establece el codigo identificador del evento
     *
     * @param codigoEvento Codigo identificador del evento a establecer
     */
    public void setCodigoEvento(Eventos codigoEvento) {
        this.codigoEvento = codigoEvento;
    }

    /**
     * Obtiene el numerto de sierie del boleto
     *
     * @return Numero de serie del boleto
     */
    public String getNumeroSerie() {
        return numeroSerie;
    }

    /**
     * Establece el numero de serie del boleto
     *
     * @param numeroSerie Numero de serie del boleto a establecer
     */
    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    /**
     * Obtiene el costo original del boleto
     *
     * @return Costo original del boleto
     */
    public double getCostoOriginal() {
        return costoOriginal;
    }

    /**
     * Establece el costo original del boleto
     *
     * @param costoOriginal Costo original del boleto a establecer
     */
    public void setCostoOriginal(double costoOriginal) {
        this.costoOriginal = costoOriginal;
    }

    /**
     * Obtiene el costo actual del boleto
     *
     * @return Costo actual del boleto
     */
    public double getCosto() {
        return costo;
    }

    /**
     * Establece el costo actual del boleto
     *
     * @param costo costo actual del boleto
     */
    public void setCosto(double costo) {
        this.costo = costo;
    }

    /**
     * Obitne el estado del boleto
     *
     * @return Estado del boleto
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Establece el estado del boleto
     *
     * @param estado Estado del boleto a establecer
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Metodo que obtiene el hascode en base al codigo identificador del boleto
     *
     * @return hascode en base al identificador del boleto obtenido
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + Objects.hashCode(this.codigoBoleto);
        return hash;
    }

    /**
     * Metodo que diferencia un objeto boleto de otro
     *
     * @param obj boleto que recive
     * @return true si es el mismo objeto, false en caso contrario
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
        final Boletos other = (Boletos) obj;
        return Objects.equals(this.codigoBoleto, other.codigoBoleto);
    }

    /**
     * Metodo que convierte todos los atributos de la clase a un valor de tipo
     * String
     *
     * @return Cadena tipo String con todos los atributos de la clase
     */
    @Override
    public String toString() {
        return "Boletos{" + "codigoBoleto=" + codigoBoleto + ", fila=" + fila + ", asiento=" + asiento + ", codigoPersona=" + codigoPersona + ", codigoEvento=" + codigoEvento + ", numeroSerie=" + numeroSerie + ", costoOriginal=" + costoOriginal + ", costo=" + costo + ", estado=" + estado + '}';
    }
}
