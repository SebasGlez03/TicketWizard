/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ticketwizard.dtos;

import ticketwizard.entidades.Eventos;
import ticketwizard.entidades.Personas;

/**
 * Clase Data Transfer Object de la entidad Boletos
 *
 * @author PC
 */
public class BoletosDTO {

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
     * @param fila Fila del boleto
     * @param asiento Asiento del boleto
     * @param codigoPersona Codigo identificador de la persona a la que le
     * pertenece el boleto
     * @param codigoEvento Codigo identificador del evento al que pertenece al
     * boleto
     * @param numeroSerie Numero de serie del boleto
     * @param costoOriginal Costo original del boleto
     * @param costo Costo actual del boleto
     * @param estado Estado del boleto ("En espera", "En venta", "Con dueño")
     */
    public BoletosDTO(String fila, String asiento, Personas codigoPersona, Eventos codigoEvento, String numeroSerie, double costoOriginal, double costo, String estado) {
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
     * de sus parametros a excepcion de las llaves foraneas
     *
     * @param fila Fila del boleto
     * @param asiento Asiento del boleto
     * @param numeroSerie Numero de serie del boleto
     * @param costoOriginal Costo original del boleto
     * @param costo Costo actual del boleto
     * @param estado Estado del boleto ("En espera", "En venta", "Con dueño")
     */
    public BoletosDTO(String fila, String asiento, String numeroSerie, double costoOriginal, double costo, String estado) {
        this.fila = fila;
        this.asiento = asiento;
        this.numeroSerie = numeroSerie;
        this.costoOriginal = costoOriginal;
        this.costo = costo;
        this.estado = estado;
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
     * Obtiene el asiento del boleto
     *
     * @return Asiento del boleto
     */
    public String getAsiento() {
        return asiento;
    }

    /**
     * Obtiene el codigo identificador de la persona a la que le pertenece el
     * boleto
     *
     * @return Codigo identificador de la persona a la que le pertenece el
     * boleto
     */
    public Personas getCodigoPersona() {
        return codigoPersona;
    }

    /**
     * Obtiene el codigo identificador del evento al que perteneve el boleto
     *
     * @return Codigo identificador del evento al que pertenece el boleto
     */
    public Eventos getCodigoEvento() {
        return codigoEvento;
    }

    /**
     * Obtiene el numero de serie del boleto
     *
     * @return Numero de serie del boleeto
     */
    public String getNumeroSerie() {
        return numeroSerie;
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
     * Obtiene el costo actual del boleto
     *
     * @return Costo actual del boleto
     */
    public double getCosto() {
        return costo;
    }

    /**
     * Obtiene el estado del boleto
     *
     * @return Estado del boleto
     */
    public String getEstado() {
        return estado;
    }

}
