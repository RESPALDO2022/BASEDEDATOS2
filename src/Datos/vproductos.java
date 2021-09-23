/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

/**
 *
 * @author Antonio Orozco
 */
public class vproductos {
    private int idh_producto;       //declaracion de las variables producto
    private String nombre;
    private String descripcion;
    private Double precio;

    public vproductos() {
    }

    public vproductos(int idh_producto, String nombre, String descripcion, Double precio) {
        this.idh_producto = idh_producto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public int getIdh_producto() {
        return idh_producto;
    }

    public void setIdh_producto(int idh_producto) {
        this.idh_producto = idh_producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    
}

