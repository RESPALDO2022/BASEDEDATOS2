package Datos;

public class vpersona {

    private int idh_persona;
    private String nombre;
    private String apellido;
    private String cui;                                           //declaracion de variables
    private String direccion;
    private String celular;

    public vpersona() {

    }

    public vpersona(int idh_persona, String nombre, String apellido, String cui, String direccion, String celular) {
        this.idh_persona = idh_persona;
        this.nombre = nombre;
        this.apellido = apellido;            //constructor
        this.cui = cui; 
        this.direccion = direccion;
        this.celular = celular;
    }

    public int getIdh_persona() {
        return idh_persona;
    }

    public void setIdh_persona(int idh_persona) {
        this.idh_persona = idh_persona;                        //metodos setters y getters
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCui() {
        return cui;
    }

    public void setCui(String cui) {
        this.cui = cui;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

}
