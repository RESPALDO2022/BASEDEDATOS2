package logica;


import Datos.vreserva;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Date;
import javax.swing.table.DefaultTableModel;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class freserva {

    private conexion mysql = new conexion(); //instancia para la conexion
    private Connection cn = mysql.conectar();// llama a la funcion conectar de la variable que instanciamos
    private String sSQL = "";//almacena la cadena de conexion
    public Integer totalregistros; // Total de registros tiene

    public DefaultTableModel mostrar(String buscar) {  // Mostrar los registros de la tabla reserva
        DefaultTableModel modelo;

        //Guarda los títulos de la columna
        String[] titulos = {"ID", "IdHabitacion", "Numero", "IdCliente", "Cliente", "IdTrabajador", "Trabajador", "FechaReserva", "FechaIngreso", "FechaSalida", "CostoAlojamiento", "EstadoReserva"};
        String[] registro = new String[12];  // almacena el registro de cada columna 

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);  // agregar titulos que ya se tienen 

        sSQL = "select r.idh_reserva, r.idh_habitacion, h.numero, r.idh_cliente,"
                + "(select nombre from h_persona where idh_persona=r.idh_cliente) as clienten,"
                + "(select apellido from h_persona where idh_persona=r.idh_cliente) as clienteap,"
                + "r.idh_trabajador,(select nombre from h_persona where idh_persona=r.idh_trabajador)as trabajadorn,"
                + "(select apellido from h_persona where idh_persona=r.idh_trabajador)as trabajadorap,"
                + "r.fecha_reservacion, r.fecha_ingreso, r.fecha_salida,"
                + "r.costo_alojamiento, r.estado_reserva from h_reserva r inner join h_habitacion h on r.idh_habitacion=h.idh_habitacion where r.fecha_reservacion like '%" + buscar + "%' order by idh_reserva desc "; //Consulta para obtener los registros de la tabla
       
        try { //declaracion de errores 
            Statement st = cn.createStatement();   // asigna a la variable de tipo Statement la conexion de La BD
            ResultSet rs = st.executeQuery(sSQL); //ejecuta la consulta de arriba  

            while (rs.next()) { //todos los registros obtenidos
                registro[0] = rs.getString("idh_reserva");
                registro[1] = rs.getString("idh_habitacion");
                registro[2] = rs.getString("numero");
                registro[3] = rs.getString("idh_cliente");
                registro[4] = rs.getString("clienten") + " " + rs.getString("clienteap");
                registro[5] = rs.getString("idh_trabajador");
                registro[6] = rs.getString("trabjadorn") + " " + rs.getString("trabajadorap");
                registro[7] = rs.getString("fecha_reservacion");
                registro[8] = rs.getString("fecha_ingreso");
                registro[9] = rs.getString("fecha_salida");
                registro[10] = rs.getString("costo_alojamiento");
                registro[11] = rs.getString("estado_reserva");

                totalregistros = totalregistros + 1; //Aumenta la variable en 1
                modelo.addRow(registro);  //agrega a la variable modelo todos los registros
            }
            return modelo;   // retorna los valores del modelo si no hay ningun error

        } catch (Exception e) {    // Si hay un error muestra una advertencia 
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }

    }

    public boolean insertar(vreserva dts) {   // Funcion insertar, recibe todo lo de la clase vreserva
        sSQL = "insert into h_reserva(idh_habitacion, idh_cliente, idh_trabajador, fecha_reservacion,fecha_ingreso,fecha_salida,costo_alojamiento,estado_reserva)"
                + "values (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);// prepara la cadena para poder insertar los registros
            pst.setInt(1, dts.getIdh_habitacion()); //Enviar 1 a 1 todos los valores
            pst.setInt(2, dts.getIdh_cliente());
            pst.setInt(3, dts.getIdh_trabajador());
            pst.setDate(4, (Date) dts.getFecha_reservacion());
            pst.setDate(5, (Date) dts.getFecha_ingreso());
            pst.setDate(6, (Date) dts.getFecha_salida());
            pst.setDouble(7, dts.getCosto_alojamiento());
            pst.setString(8, dts.getEstado_reserva());

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

    public boolean editar(vreserva dts) {
      sSQL = "update h_reserva set idh_habitacion=?,idh_cliente=?,idh_trabajador=?,fecha_reservacion=?,fecha_ingreso=?,fecha_salida=?,costo_alojamiento=?,estado_reserva=?" //actualizar tabla reserva
                + "where idh_reserva=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);// prepara la cadena para poder insertar los registros
            pst.setInt(1, dts.getIdh_habitacion()); //Enviar 1 a 1 todos los valores
            pst.setInt(2, dts.getIdh_cliente());
            pst.setInt(3, dts.getIdh_trabajador());
            pst.setDate(4, (Date) dts.getFecha_reservacion());
            pst.setDate(5, (Date) dts.getFecha_ingreso());
            pst.setDate(6, (Date) dts.getFecha_salida());
            pst.setDouble(7, dts.getCosto_alojamiento());
            pst.setString(8, dts.getEstado_reserva());
            pst.setInt(9, dts.getIdh_reserva());    
            
           
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

    public boolean eliminar(vreserva dts) {
        sSQL = "delete from h_reserva where idh_reserva=?";  // Borra los registros de las reservas en el ID indicado

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL); // prepara la cadena para poder insertar los registros
            pst.setInt(1, dts.getIdh_reserva());// El indice 1, es el ID reserva para indicar que se elimina
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
