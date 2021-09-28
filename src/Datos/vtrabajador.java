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
public class vtrabajador extends vpersona {
    Double sueldo;
    String cargo;
    String usuario;
    String contrasenia;
    String estado;

    public vtrabajador() {
    }

    public vtrabajador(Double sueldo, String cargo, String usuario, String contrasenia, String estado) {
        this.sueldo = sueldo;
        this.cargo = cargo;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.estado = estado;
    }

    public Double getSueldo() {
        return sueldo;
    }

    public void setSueldo(Double sueldo) {
        this.sueldo = sueldo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    

}
