package logica;

import Datos.vfactura;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Date;
import javax.swing.table.DefaultTableModel;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ffactura {

    private conexion mysql = new conexion(); //instancia para la conexion
    private Connection cn = mysql.conectar();// llama a la funcion conectar de la variable que instanciamos
    private String sSQL = "";//almacena la cadena de conexion
    public Integer totalregistros; // Total de registros tiene

    public DefaultTableModel mostrar(String buscar) {  // Mostrar los registros de la tabla producto
        DefaultTableModel modelo;

        //Guarda los títulos de la columna
        String[] titulos = {"ID", "Idreserva", "numero", "total","fecha"};
        String[] registro = new String[5];  // almacena el registro de cada columna 

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);  // agregar titulos que ya se tienen 

        sSQL = "select *from h_factura where idh_reserva like '%" + buscar + "%' order by idh_factura desc "; //Consulta para obtener los registros de la tabla

        try { //declaracion de errores 
            Statement st = cn.createStatement();   // asigna a la variable de tipo Statement la conexion de La BD
            ResultSet rs = st.executeQuery(sSQL); //ejecuta la consulta de arriba  

            while (rs.next()) { //todos los registros obtenidos
                registro[0] = rs.getString("idh_factura");
                registro[1] = rs.getString("idh_reserva");
                registro[2] = rs.getString("numero");
                registro[3] = rs.getString("total");
                registro[4] = rs.getString("fecha");

                totalregistros = totalregistros + 1; //Aumenta la variable en 1
                modelo.addRow(registro);  //agrega a la variable modelo todos los registros
            }
            return modelo;   // retorna los valores del modelo si no hay ningun error

        } catch (Exception e) {    // Si hay un error muestra una advertencia 
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }

    }

    public boolean insertar(vfactura dts) {   // Funcion insertar, recibe todo lo de la clase vfactura
        sSQL = "insert into h_factura(idh_reserva,numero,total,fecha)"
                + "values (?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);// prepara la cadena para poder insertar los registros
            pst.setInt(1, dts.getIdh_reserva()); //Enviar 1 a 1 todos los valores
            pst.setString(2, dts.getNumero());
            pst.setDouble(3, dts.getTotal());
            pst.setDate(4, (Date) dts.getFecha());

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

    public boolean editar(vfactura dts) {
        sSQL = "update h_factura set idh_reserva=?,numero=?,total=?,fecha=?" //actualizar tabla producto
                + "where idh_factura=?";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);// prepara la cadena para poder insertar los registros
            pst.setInt(1, dts.getIdh_reserva()); //Enviar 1 a 1 todos los valores
            pst.setString(2, dts.getNumero());
            pst.setDouble(3, dts.getTotal());
            pst.setDate(4, (Date) dts.getFecha());
            
            pst.setInt(5, dts.getIdh_factura());

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

    public boolean eliminar(vfactura dts) {
        sSQL = "delete from h_factura where idh_factura=?";  // Borra los registros de los consuos en el ID indicado

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL); // prepara la cadena para poder insertar los registros
            pst.setInt(1, dts.getIdh_factura());// El indice 1, es el ID producto para indicar que se elimina
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
