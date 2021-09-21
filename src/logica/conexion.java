package logica;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class conexion {
    
    public String db="basehotel"; // nombre de la base de datos en phpMyAdmin
    public String url="jdbc:mysql://127.0.0.1/"+db; // IP donde esta la base de datos
    
    public String user="root"; // nombre del usuario, siempre sera el mismo para xampp 
    public String pass=""; // contraseña vacia
    
    public conexion(){ //constructor
    }
    
    public Connection conectar(){ // funcion conectar 
    Connection link=null;  //instancia la conexion
    try{
        
        Class.forName("org.gjt.mm.mysql.Driver"); // Ruta del driver de la libreria de conexion
        link=DriverManager.getConnection(this.url,this.user,this.pass);  // enlace para la base de datos
        
    }catch(ClassNotFoundException | SQLException e){ //Excepciones específicas
        JOptionPane.showConfirmDialog(null,e); //Mensaje de error
    
    }
    return link; //retornar cadena de conexion
    }
      
}
