/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ticketwizard.entidades;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author santi
 */
public class Transacciones {
    Integer codigoTransaccion;
    Date fehcaHora;
    String tipoAdquision;
    float costo;
    Integer codigoComprador;
    Integer codigoBoleto;
    Integer codigoVendedor;

    public Transacciones(Date fehcaHora, String tipoAdquision, float costo, Integer codigoComprador, Integer codigoBoleto, Integer codigoVendedor) {
        this.fehcaHora = fehcaHora;
        this.tipoAdquision = tipoAdquision;
        this.costo = costo;
        this.codigoComprador = codigoComprador;
        this.codigoBoleto = codigoBoleto;
        this.codigoVendedor = codigoVendedor;
    }

    public Transacciones(Integer codigoTransaccion, Date fehcaHora, String tipoAdquision, float costo, Integer codigoComprador, Integer codigoBoleto, Integer codigoVendedor) {
        this.codigoTransaccion = codigoTransaccion;
        this.fehcaHora = fehcaHora;
        this.tipoAdquision = tipoAdquision;
        this.costo = costo;
        this.codigoComprador = codigoComprador;
        this.codigoBoleto = codigoBoleto;
        this.codigoVendedor = codigoVendedor;
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

    public float getCosto() {
        return costo;
    }

    public Integer getCodigoComprador() {
        return codigoComprador;
    }

    public Integer getCodigoBoleto() {
        return codigoBoleto;
    }

    public Integer getCodigoVendedor() {
        return codigoVendedor;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.codigoTransaccion);
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
        final Transacciones other = (Transacciones) obj;
        return Objects.equals(this.codigoTransaccion, other.codigoTransaccion);
    }

    @Override
    public String toString() {
        return "Transacciones{" + "codigoTransaccion=" + codigoTransaccion + ", fehcaHora=" + fehcaHora + ", tipoAdquision=" + tipoAdquision + ", costo=" + costo + ", codigoComprador=" + codigoComprador + ", codigoBoleto=" + codigoBoleto + ", codigoVendedor=" + codigoVendedor + '}';
    }
    
    
}
