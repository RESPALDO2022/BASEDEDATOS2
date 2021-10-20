package logica;

import Datos.vconsumo;
 
import java.sql.ResultSet;
import java.sql.Connection;
import javax.swing.table.DefaultTableModel;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class fconsumo {

    private conexion mysql = new conexion(); //instancia para la conexion
    private Connection cn = mysql.conectar();// llama a la funcion conectar de la variable que instanciamos
    private String sSQL = "";//almacena la cadena de conexion
    public Integer totalregistros; // Total de registros tiene
    public double totalconsumo;    // Total de consumos tiene 
    
    public DefaultTableModel mostrar(String buscar) {  // Mostrar los registros de la tabla producto
        DefaultTableModel modelo;

        //Guarda los títulos de la columna
        String[] titulos = {"ID","idreserva", "idproducto", "producto", "cantidad", "precio", "estado"};
        String[] registro = new String[7];  // almacena el registro de cada columna 

        totalregistros = 0;
        totalconsumo =0.0;
        modelo = new DefaultTableModel(null, titulos);  // agregar titulos que ya se tienen 

        sSQL = "select c.idh_consumo, c.idh_reserva,c.idh_producto,p.nombre,c.cantidad,c.costo"+
               "c.estado from h_consumo c inner join h_producto p on c.idh_producto = p.idh_producto"+
               "where c.idh_reserva =" + buscar + " order by c.idh_consumo desc "; //Consulta para obtener los registros de la tabla

        try { //declaracion de errores 
            Statement st = cn.createStatement();   // asigna a la variable de tipo Statement la conexion de La BD
            ResultSet rs = st.executeQuery(sSQL); //ejecuta la consulta de arriba  

            while (rs.next()) { //todos los registros obtenidos
                registro[0] = rs.getString("idh_consumo");
                registro[1] = rs.getString("idh_reserva");
                 registro[2] = rs.getString("idh_producto");
                registro[3] = rs.getString("nombre");
                registro[4] = rs.getString("cantidad");
                registro[5] = rs.getString("costo");
                registro[6] = rs.getString("estado");

                totalregistros = totalregistros + 1; //Aumenta la variable en 1
                totalconsumo = totalconsumo +(rs.getDouble("cantidad")*rs.getDouble("costo"));
                modelo.addRow(registro);  //agrega a la variable modelo todos los registros
            }
            return modelo;   // retorna los valores del modelo si no hay ningun error

        } catch (Exception e) {    // Si hay un error muestra una advertencia 
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }

    }

    public boolean insertar(vconsumo dts) {   // Funcion insertar, recibe todo lo de la clase vconsumo
        sSQL = "insert into h_consumo(idh_reserva,idh_producto,cantidad,costo,estado)"
                + "values (?,?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);// prepara la cadena para poder insertar los registros
            pst.setInt(1, dts.getIdh_reserva()); //Enviar 1 a 1 todos los valores
            pst.setInt(2, dts.getIdh_producto());
            pst.setDouble(3, dts.getCantidad());
            pst.setDouble(4, dts.getCosto());
            pst.setString(5, dts.getEstado());

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

    public boolean editar(vconsumo dts) {
        sSQL = "update h_consumo set idh_reserva=?,idh_producto=?,cantidad=?,costo=?,estado=?," //actualizar tabla consumo
                + "where idh_consumo=?";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);// prepara la cadena para poder insertar los registros
             pst.setInt(1, dts.getIdh_reserva()); //Enviar 1 a 1 todos los valores
            pst.setInt(2, dts.getIdh_producto());
            pst.setDouble(3, dts.getCantidad());
            pst.setDouble(4, dts.getCosto());
            pst.setString(5, dts.getEstado()); 
            
            pst.setInt(6, dts.getIdh_consumo());

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

    public boolean eliminar(vconsumo dts) {
        sSQL = "delete from h_consumo where idh_consumo=?";  // Borra los registros de los consumos en el ID indicado

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL); // prepara la cadena para poder insertar los registros
            pst.setInt(1, dts.getIdh_consumo());// El indice 1, es el ID consumo para indicar que se elimina
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
