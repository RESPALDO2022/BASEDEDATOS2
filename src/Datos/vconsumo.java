
package Datos;


public class vconsumo {
    
    private int idh_consumo;
    private int idh_reserva;
    private int idh_producto;
    private double cantidad;
    private double costo;
    private String estado;

    public vconsumo() {
    }

    public vconsumo(int idh_consumo, int idh_reserva, int idh_producto, double cantidad, double costo, String estado) {
        this.idh_consumo = idh_consumo;
        this.idh_reserva = idh_reserva;
        this.idh_producto = idh_producto;
        this.cantidad = cantidad;
        this.costo = costo;
        this.estado = estado;
    }

    public int getIdh_consumo() {
        return idh_consumo;
    }

    public void setIdh_consumo(int idh_consumo) {
        this.idh_consumo = idh_consumo;
    }

    public int getIdh_reserva() {
        return idh_reserva;
    }

    public void setIdh_reserva(int idh_reserva) {
        this.idh_reserva = idh_reserva;
    }

    public int getIdh_producto() {
        return idh_producto;
    }

    public void setIdh_producto(int idh_producto) {
        this.idh_producto = idh_producto;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
}
