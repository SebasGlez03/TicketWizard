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

    public Ventas(int codigoHistorial, Date fechaAccion, String accion, Boletos boletos) {
        this.codigoHistorial = codigoHistorial;
        this.fechaAccion = fechaAccion;
        this.accion = accion;
        this.boletos = boletos;
    }

    public int getCodigoHistorial() {
        return codigoHistorial;
    }

    public Date getFechaAccion() {
        return fechaAccion;
    }

    public String getAccion() {
        return accion;
    }

    public Boletos getBoletos() {
        return boletos;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + this.codigoHistorial;
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
        final Ventas other = (Ventas) obj;
        return this.codigoHistorial == other.codigoHistorial;
    }

    @Override
    public String toString() {
        return "Ventas{" + "codigoHistorial=" + codigoHistorial + ", fechaAccion=" + fechaAccion + ", accion=" + accion + ", boletos=" + boletos + '}';
    }
    
    
}
