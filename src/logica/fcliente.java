package logica;

import Datos.vcliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class fcliente {

    private conexion mysql = new conexion(); //instancia para la conexion
    private Connection cn = mysql.conectar();// llama a la funcion conectar de la variable que instanciamos
    private String sSQL = "";//almacena la cadena de conexion
    private String sSQL2 = "";//almacena la cadena de conexion
    public Integer totalregistros; // Total de registros tiene

    public DefaultTableModel mostrar(String buscar) {  // Mostrar los registros de la tabla cliente
        DefaultTableModel modelo;

        //Guarda los títulos de la columna
        String[] titulos = {"ID", "NOMBRE", "APELLIDO", "CUI", "DIRECCION", "CELULAR", "CODIGO CLIENTE"};
        String[] registro = new String[7];  // almacena el registro de cada columna 

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);  // agregar titulos que ya se tienen 

        sSQL = "select p.idh_persona,p.nombre,p.apellido,p.cui,p.direccion,p.celular,c.codigo_cliente from h_persona p inner join h_cliente c "
                + "on p.idh_persona=c.idh_persona where nombre like '%"
                + buscar + "%' order by idh_persona desc "; //Consulta para obtener los registros de la tabla

        try { //declaracion de errores 
            Statement st = cn.createStatement();   // asigna a la variable de tipo Statement la conexion de La BD
            ResultSet rs = st.executeQuery(sSQL); //ejecuta la consulta de arriba  

            while (rs.next()) { //todos los registros obtenidos
                registro[0] = rs.getString("idh_persona");
                registro[1] = rs.getString("nombre");
                registro[2] = rs.getString("apellido");
                registro[3] = rs.getString("cui");
                registro[4] = rs.getString("direccion");
                registro[5] = rs.getString("celular");
                registro[6] = rs.getString("codigo_cliente");

                totalregistros = totalregistros + 1; //Aumenta la variable en 1
                modelo.addRow(registro);  //agrega a la variable modelo todos los registros
            }
            return modelo;   // retorna los valores del modelo si no hay ningun error

        } catch (Exception e) {    // Si hay un error muestra una advertencia 
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }

    }

    public boolean insertar(vcliente dts) {   // Funcion insertar, recibe todo lo de la clase vcliente
        sSQL = "insert into h_persona(nombre,apellido,cui,direccion,celular)"
                + "values (?,?,?,?,?)";

        sSQL2 = "insert into h_cliente(idh_persona,codigo_cliente)"
                + "values ((select idh_persona from h_persona order by idh_persona desc limit 1),?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);// prepara la cadena para poder insertar los registros
            PreparedStatement pst2 = cn.prepareStatement(sSQL2);// prepara la cadena para poder insertar los registros

            pst.setString(1, dts.getNombre()); //Enviar 1 a 1 todos los valores
            pst.setString(2, dts.getApellido());
            pst.setString(3, dts.getCui());
            pst.setString(4, dts.getDireccion());
            pst.setString(5, dts.getCelular());

            pst2.setString(1, dts.getCodigo_cliente());

            int n = pst.executeUpdate();//almacena el estado de la ejecucucion del Statement

            if (n != 0) { //condicion para ver si se ingresaron registros
                int n2 = pst2.executeUpdate();
                if (n2 != 0) {
                    return true;
                } else {
                    return false;
                }

            } else {
                return false;
            }

        } catch (Exception e) {   // error si 
            JOptionPane.showConfirmDialog(null, e);//Lanza el mensaje de error
            return false;
        }
    }

    public boolean editar(vcliente dts) {
        sSQL = "update h_persona set nombre=?,apellido=?,cui=?,direccion=?,celular=?" //actualizar tabla persona
                + "where idh_persona=?";

        sSQL2 = "update h_cliente set codigo_cliente=?" //actualizar tabla cliente
                + "where idh_persona=?";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);// prepara la cadena para poder insertar los registros
            PreparedStatement pst2 = cn.prepareStatement(sSQL2);// prepara la cadena para poder insertar los registros

            pst.setString(1, dts.getNombre()); //Enviar 1 a 1 todos los valores
            pst.setString(2, dts.getApellido());
            pst.setString(3, dts.getCui());
            pst.setString(4, dts.getDireccion());
            pst.setString(5, dts.getCelular());
            pst.setInt(6, dts.getIdh_persona());
            
            pst2.setString(1, dts.getCodigo_cliente());
            pst2.setInt(2, dts.getIdh_persona());
            int n = pst.executeUpdate();//almacena el estado de la ejecucucion del Statement

            if (n != 0) { //condicion para ver si se ingresaron registros
                int n2 = pst2.executeUpdate();
                if (n2 != 0) {
                    return true;
                } else {
                    return false;
                }

            } else {
                return false;
            }

        } catch (Exception e) {   // error si 
            JOptionPane.showConfirmDialog(null, e);//Lanza el mensaje de error
            return false;
        }
    }

    public boolean eliminar(vcliente dts) {
        sSQL = "delete from h_cliente where idh_persona=?";  // Borra los registros del cliente en el ID indicado
        sSQL2 = "delete from h_persona where idh_persona=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);// prepara la cadena para poder insertar los registros
            PreparedStatement pst2 = cn.prepareStatement(sSQL2);// prepara la cadena para poder insertar los registros

            //enviar todos los valores 1 a 1
            pst.setInt(1, dts.getIdh_persona());
            pst2.setInt(1, dts.getIdh_persona());
            int n = pst.executeUpdate();//almacena el estado de la ejecucucion del Statement

            if (n != 0) { //condicion para ver si se ingresaron registros
                int n2 = pst2.executeUpdate();
                if (n2 != 0) {
                    return true;
                } else {
                    return false;
                }

            } else {
                return false;
            }

        } catch (Exception e) {   // error si 
            JOptionPane.showConfirmDialog(null, e);//Lanza el mensaje de error
            return false;
        }
    }

}
