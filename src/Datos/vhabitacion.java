
package Datos;

/**
 *
 * @author Sara Ramirez
 */
public class vhabitacion {
private int id_habitacion;
private String numero;
private String piso;
private String caracteristicas;
private Double precio;
private String tipo;
private String disponibilidad;

    public vhabitacion(int id_habitacion, String numero, String piso, String caracteristicas, Double precio, String tipo, String disponibilidad) {
        this.id_habitacion = id_habitacion;
        this.numero = numero;
        this.piso = piso;
        this.caracteristicas = caracteristicas;
        this.precio = precio;
        this.tipo = tipo;
        this.disponibilidad = disponibilidad;
    }

    public vhabitacion() {
    }

    public int getId_habitacion() {
        return id_habitacion;
    }

    public void setId_habitacion(int id_habitacion) {
        this.id_habitacion = id_habitacion;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    

    
}
