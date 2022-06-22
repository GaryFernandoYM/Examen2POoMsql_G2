package conexion;
import java.sql.*;

public class ConexionMysql {
    
    Connection conexion=null;
        String userDB="root";
        String passwordDB="";
        String url="";
        
    public Connection conectaDB(){
        try {   
        url="jdbc:mysql://localhost:3308/sales-peru";
        conexion=DriverManager.getConnection(url, userDB, passwordDB);
            if(conexion!=null){
                System.out.println("se establecio la conexion");
            } else{
                System.out.print("no existe conexion");
            }  
        }catch (SQLException e) {
            e.getMessage();
        }           
        return conexion;
    }
    
    public static void main(String[] args) {
        ConexionMysql cx = new ConexionMysql();
        cx.conectaDB();
    }
    
}
