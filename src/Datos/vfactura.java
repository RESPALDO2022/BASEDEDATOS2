
package Datos;

import java.util.Date;


public class vfactura {
    private int idh_factura;
    private int idh_reserva;
    private String numero;
    private Double total;
    private Date fecha;

    public vfactura() {
    }

    public vfactura(int idh_factura, int idh_reserva, String numero, Double total, Date fecha) {
        this.idh_factura = idh_factura;
        this.idh_reserva = idh_reserva;
        this.numero = numero;
        this.total = total;
        this.fecha = fecha;
    }

    public int getIdh_factura() {
        return idh_factura;
    }

    public void setIdh_factura(int idh_factura) {
        this.idh_factura = idh_factura;
    }

    public int getIdh_reserva() {
        return idh_reserva;
    }

    public void setIdh_reserva(int idh_reserva) {
        this.idh_reserva = idh_reserva;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
}
