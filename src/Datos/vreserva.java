package Datos;

import java.util.Date;

public class vreserva {

    private int idh_reserva; //declaracion de variable
    private int idh_habitacion;
    private int idh_cliente;
    private int idh_trabajador;
    private Date fecha_reservacion;
    private Date fecha_ingreso;
    private Date fecha_salida;
    private double costo_alojamiento;
    private String estado_reserva;

    public vreserva() {
    }

    public vreserva(int idh_reserva, int idh_habitacion, int idh_cliente, int idh_trabajador, Date fecha_reservacion, Date fecha_ingreso, Date fecha_salida, double costo_alojamiento, String estado_reserva) {
        this.idh_reserva = idh_reserva;
        this.idh_habitacion = idh_habitacion;
        this.idh_cliente = idh_cliente;
        this.idh_trabajador = idh_trabajador;
        this.fecha_reservacion = fecha_reservacion;
        this.fecha_ingreso = fecha_ingreso;
        this.fecha_salida = fecha_salida;
        this.costo_alojamiento = costo_alojamiento;
        this.estado_reserva = estado_reserva;
    }

    public int getIdh_reserva() {
        return idh_reserva;
    }

    public void setIdh_reserva(int idh_reserva) {
        this.idh_reserva = idh_reserva;
    }

    public int getIdh_habitacion() {
        return idh_habitacion;
    }

    public void setIdh_habitacion(int idh_habitacion) {
        this.idh_habitacion = idh_habitacion;
    }

    public int getIdh_cliente() {
        return idh_cliente;
    }

    public void setIdh_cliente(int idh_cliente) {
        this.idh_cliente = idh_cliente;
    }

    public int getIdh_trabajador() {
        return idh_trabajador;
    }

    public void setIdh_trabajador(int idh_trabajador) {
        this.idh_trabajador = idh_trabajador;
    }

    public Date getFecha_reservacion() {
        return fecha_reservacion;
    }

    public void setFecha_reservacion(Date fecha_reservacion) {
        this.fecha_reservacion = fecha_reservacion;
    }

    public Date getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(Date fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public Date getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(Date fecha_salida) {
        this.fecha_salida = fecha_salida;
    }

    public double getCosto_alojamiento() {
        return costo_alojamiento;
    }

    public void setCosto_alojamiento(double costo_alojamiento) {
        this.costo_alojamiento = costo_alojamiento;
    }

    public String getEstado_reserva() {
        return estado_reserva;
    }

    public void setEstado_reserva(String estado_reserva) {
        this.estado_reserva = estado_reserva;
    }
    }

