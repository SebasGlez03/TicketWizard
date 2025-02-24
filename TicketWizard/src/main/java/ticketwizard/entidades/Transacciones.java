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

    /**
     * Constructor para inicializar una transacción con los detalles proporcionados.
     * 
     * @param fehcaHora          la fecha y hora de la transacción
     * @param tipoAdquision      el tipo de adquisición de la transacción
     * @param costo              el costo de la transacción
     * @param codigoComprador    el código del comprador que realizó la transacción
     * @param codigoBoleto       el código del boleto asociado a la transacción
     * @param codigoVendedor    el código del vendedor asociado a la transacción
     */
    public Transacciones(Date fehcaHora, String tipoAdquision, float costo, 
                         Integer codigoComprador, Integer codigoBoleto, Integer codigoVendedor) {
        this.fehcaHora = fehcaHora;
        this.tipoAdquision = tipoAdquision;
        this.costo = costo;
        this.codigoComprador = codigoComprador;
        this.codigoBoleto = codigoBoleto;
        this.codigoVendedor = codigoVendedor;
    }

    /**
     * Constructor para inicializar una transacción con los detalles proporcionados, incluyendo el código de la transacción.
     * 
     * @param codigoTransaccion  el código único de la transacción
     * @param fehcaHora          la fecha y hora de la transacción
     * @param tipoAdquision      el tipo de adquisición de la transacción
     * @param costo              el costo de la transacción
     * @param codigoComprador    el código del comprador que realizó la transacción
     * @param codigoBoleto       el código del boleto asociado a la transacción
     * @param codigoVendedor    el código del vendedor asociado a la transacción
     */
    public Transacciones(Integer codigoTransaccion, Date fehcaHora, String tipoAdquision, 
                         float costo, Integer codigoComprador, Integer codigoBoleto, Integer codigoVendedor) {
        this.codigoTransaccion = codigoTransaccion;
        this.fehcaHora = fehcaHora;
        this.tipoAdquision = tipoAdquision;
        this.costo = costo;
        this.codigoComprador = codigoComprador;
        this.codigoBoleto = codigoBoleto;
        this.codigoVendedor = codigoVendedor;
    }

    /**
     * Obtiene el código de la transacción.
     * 
     * @return el código de la transacción
     */
    public Integer getCodigoTransaccion() {
        return codigoTransaccion;
    }

    /**
     * Obtiene la fecha y hora de la transacción.
     * 
     * @return la fecha y hora de la transacción
     */
    public Date getFehcaHora() {
        return fehcaHora;
    }

    /**
     * Obtiene el tipo de adquisición de la transacción.
     * 
     * @return el tipo de adquisición
     */
    public String getTipoAdquision() {
        return tipoAdquision;
    }

    /**
     * Obtiene el costo de la transacción.
     * 
     * @return el costo de la transacción
     */
    public float getCosto() {
        return costo;
    }

    /**
     * Obtiene el código del comprador que realizó la transacción.
     * 
     * @return el código del comprador
     */
    public Integer getCodigoComprador() {
        return codigoComprador;
    }

    /**
     * Obtiene el código del boleto asociado a la transacción.
     * 
     * @return el código del boleto
     */
    public Integer getCodigoBoleto() {
        return codigoBoleto;
    }

    /**
     * Obtiene el código del vendedor asociado a la transacción.
     * 
     * @return el código del vendedor
     */
    public Integer getCodigoVendedor() {
        return codigoVendedor;
    }

    /**
     * Calcula el valor del código hash para la transacción, basado en el código de la transacción.
     * 
     * @return el valor del código hash
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.codigoTransaccion);
        return hash;
    }

    /**
     * Compara dos objetos Transacciones para determinar si son iguales.
     * La comparación se realiza basándose en el código de la transacción.
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
        final Transacciones other = (Transacciones) obj;
        return Objects.equals(this.codigoTransaccion, other.codigoTransaccion);
    }

    /**
     * Genera una representación en cadena de la transacción.
     * 
     * @return una cadena representando la transacción
     */
    @Override
    public String toString() {
        return "Transacciones{" + "codigoTransaccion=" + codigoTransaccion + ", fehcaHora=" + fehcaHora + 
               ", tipoAdquision=" + tipoAdquision + ", costo=" + costo + ", codigoComprador=" + codigoComprador + 
               ", codigoBoleto=" + codigoBoleto + ", codigoVendedor=" + codigoVendedor + '}';
    }
    
}
