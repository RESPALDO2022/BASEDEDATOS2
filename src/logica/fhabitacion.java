package logica;

import Datos.vhabitacion;
import java.sql.ResultSet;
import java.sql.Connection;
import javax.swing.table.DefaultTableModel;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class fhabitacion {

    private conexion mysql = new conexion(); //instancia para la conexion
    private Connection cn = mysql.conectar();// llama a la funcion conectar de la variable que instanciamos
    private String sSQL = "";//almacena la cadena de conexion
    public Integer totalregistros; // Total de registros tiene

    public DefaultTableModel mostrar(String buscar) {  // Mostrar los registros de la tabla habitacion
        DefaultTableModel modelo;

        //Guarda los títulos de la columna
        String[] titulos = {"ID", "Numero", "Piso", "Caracteristicas", "Precio", "Tipo", "Disponibilidad"};
        String[] registro = new String[7];  // almacena el registro de cada columna 

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);  // agregar titulos que ya se tienen 

        sSQL = "select *from h_habitacion where piso like '%" + buscar + "%' order by idh_habitacion"; //Consulta para obtener los registros de la tabla

        try { //declaracion de errores 
            Statement st = cn.createStatement();   // asigna a la variable de tipo Statement la conexion de La BD
            ResultSet rs = st.executeQuery(sSQL); //ejecuta la consulta de arriba  

            while (rs.next()) { //todos los registros obtenidos
                registro[0] = rs.getString("idh_habitacion");
                registro[1] = rs.getString("numero");
                registro[2] = rs.getString("piso");
                registro[3] = rs.getString("caracteristicas");
                registro[4] = rs.getString("precio");
                registro[5] = rs.getString("tipo");
                registro[6] = rs.getString("disponibilidad");

                totalregistros = totalregistros + 1; //Aumenta la variable en 1
                modelo.addRow(registro);  //agrega a la variable modelo todos los registros
            }
            return modelo;   // retorna los valores del modelo si no hay ningun error

        } catch (Exception e) {    // Si hay un error muestra una advertencia 
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }

    }

    public boolean insertar(vhabitacion dts) {   // Funcion insertar, recibe todo lo de la clase vhabitacion
        sSQL = "insert into h_habitacion(numero,piso,caracteristicas,precio,tipo,disponibilidad)"
                + "values (?,?,?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);// prepara la cadena para poder insertar los registros
            pst.setString(1, dts.getNumero()); //Enviar 1 a 1 todos los valores
            pst.setString(2, dts.getPiso());
            pst.setString(3, dts.getCaracteristicas());
            pst.setDouble(4, dts.getPrecio());
            pst.setString(5, dts.getTipo());
            pst.setString(6, dts.getDisponibilidad());

            int n = pst.executeUpdate();//almacena el estado de la ejecucucion del Statement

            if (n != 0) { //condicion para ver si se ingresaron registros
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {   // error si 
            JOptionPane.showConfirmDialog(null, e);//Lanza el mensaje de error
            return false;
        }
    }

    public boolean editar(vhabitacion dts) {
        sSQL = "update h_habitacion set numero=?,piso=?,caracteristicas=?,precio=?,tipo=?,disponibilidad=?" //actualizar tabla habitacion
                + "where idh_habitacion=?";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);// prepara la cadena para poder insertar los registros
            pst.setString(1, dts.getNumero()); //Enviar 1 a 1 todos los valores
            pst.setString(2, dts.getPiso());
            pst.setString(3, dts.getCaracteristicas());
            pst.setDouble(4, dts.getPrecio());
            pst.setString(5, dts.getTipo());
            pst.setString(6, dts.getDisponibilidad());
            pst.setInt(7, dts.getIdh_habitacion());

            int n = pst.executeUpdate();//almacena el estado de la ejecucucion del Statement

            if (n != 0) { //condicion para ver si se ingresaron registros
                return true;
            } else {
                return false;
            }

        } catch (Exception e) { //si tiene error
            JOptionPane.showConfirmDialog(null, e); //lanza el mesaje de error
            return false;
        }
    }

    public boolean eliminar(vhabitacion dts) {
//        sSQL = "delete from h_habitacion where idh_habitacion=?";  // Borra los registros de la habitacion en el ID indicado

        try {
          PreparedStatement pst = cn.prepareStatement(sSQL); // prepara la cadena para poder insertar los registros
//            pst.setInt(1, dts.getIdh_habitacion());// El indice 1, es el ID habitacion para indicar que se elimina
            int n = pst.executeUpdate(); //almacena el estado de la ejecucucion del Statement

            if (n != 0) {   //Revisa si esta vacio
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e); //lanza el mesaje de error
            return false;
        }
    }
}
