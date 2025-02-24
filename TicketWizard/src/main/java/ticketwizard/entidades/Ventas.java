/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ticketwizard.entidades;

import java.util.Date;

/**
 *
 * @author santi
 */
public class Ventas {
    int codigoHistorial;
    Date fechaAccion;
    String accion;
    Boletos boletos;

    /**
     * Constructor para inicializar un objeto Ventas con los detalles proporcionados.
     * 
     * @param codigoHistorial    el código único del historial de ventas
     * @param fechaAccion        la fecha y hora en la que ocurrió la acción
     * @param accion             la acción realizada (por ejemplo, "venta", "devolución")
     * @param boletos            los boletos involucrados en la venta
     */
    public Ventas(int codigoHistorial, Date fechaAccion, String accion, Boletos boletos) {
        this.codigoHistorial = codigoHistorial;
        this.fechaAccion = fechaAccion;
        this.accion = accion;
        this.boletos = boletos;
    }

    /**
     * Obtiene el código único del historial de ventas.
     * 
     * @return el código del historial de ventas
     */
    public int getCodigoHistorial() {
        return codigoHistorial;
    }

    /**
     * Obtiene la fecha y hora de la acción realizada en el historial de ventas.
     * 
     * @return la fecha y hora de la acción
     */
    public Date getFechaAccion() {
        return fechaAccion;
    }

    /**
     * Obtiene el tipo de acción realizada en la venta (por ejemplo, "venta", "devolución").
     * 
     * @return la acción realizada
     */
    public String getAccion() {
        return accion;
    }

    /**
     * Obtiene los boletos asociados a la venta.
     * 
     * @return los boletos de la venta
     */
    public Boletos getBoletos() {
        return boletos;
    }

    /**
     * Calcula el valor del código hash para la clase Ventas, basado en el código de historial.
     * 
     * @return el valor del código hash
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + this.codigoHistorial;
        return hash;
    }

    /**
     * Compara dos objetos Ventas para determinar si son iguales.
     * La comparación se realiza basándose en el código del historial de ventas.
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
        final Ventas other = (Ventas) obj;
        return this.codigoHistorial == other.codigoHistorial;
    }

    /**
     * Genera una representación en cadena del objeto Ventas.
     * 
     * @return una cadena representando el objeto Ventas
     */
    @Override
    public String toString() {
        return "Ventas{" + "codigoHistorial=" + codigoHistorial + ", fechaAccion=" + fechaAccion + 
               ", accion=" + accion + ", boletos=" + boletos + '}';
    }
    
    
}
