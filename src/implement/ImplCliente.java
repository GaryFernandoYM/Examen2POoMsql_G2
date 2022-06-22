package implement;

import conexion.ConexionMysql;
import entities.Cliente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import resources.Resources;

public class ImplCliente {
    
    ArrayList<Cliente> ls= new ArrayList<>();
        
    String sql="";
    String sql2="";
    Statement stmt=null; 
    ResultSet rset=null;
    ConexionMysql cx= new ConexionMysql();
    Resources resource= new Resources();
    
    ArrayList<Cliente> listaCliente = new ArrayList<>();
    
     public void registrarCliente(Cliente c){
        
        String idCliente = "";
               idCliente = resource.generaID();
        try {
            sql = " insert into cliente ( cliente_id, cliente_dni_ruc, cliente_nombres, cliente_telefono, cliente_direccion, cliente_origen)"+
                  " values ('"+idCliente+"','"+c.getCliente_dni_ruc()+"','"+c.getCliente_nombres()+"','"+c.getCliente_telefono()+"','"+c.getCliente_direccion()+"','"+c.getCliente_origen()+"' ) ";
            
            int i=0;            
            stmt=cx.conectaDB().createStatement();
            i=stmt.executeUpdate(sql);
            
            
            
        }catch (SQLException ex) {
            System.out.println("capturando"+ex.getMessage()); 
        }      
    }
 public ArrayList<Cliente> reporteCliente(){
        try {
            sql=" select * from cliente ";
            stmt=cx.conectaDB().createStatement();
            rset=stmt.executeQuery(sql);
            while(rset.next()){
                Cliente ct = new Cliente();
                ct.setCliente_id(rset.getString("cliente_id"));
                ct.setCliente_dni_ruc(rset.getString(2));
                ct.setCliente_nombres(rset.getString(3));
                ct.setCliente_telefono(rset.getString(4));
                ct.setCliente_direccion(rset.getString(5));
                ct.setCliente_origen(rset.getString(6));
                listaCliente.add(ct);            
            }
        } catch (SQLException ex) {
                ex.getMessage();
        }
        return listaCliente;
    }
    public void ActualizarCliente(Cliente c){        
        
        try {
            sql = " update cliente "+
                  
                  " set cliente_id='"+c.getCliente_id()+"' "+
                  " , cliente_dni_ruc='"+c.getCliente_dni_ruc()+"' "+
                  " , cliente_nombres='"+c.getCliente_nombres()+"' "+
                  " , cliente_telefono='"+c.getCliente_telefono()+"' "+
                  " , cliente_direccion='"+c.getCliente_direccion()+"' "+
                  " where cliente_origen ='"+c.getCliente_origen()+"' ";
                            
            
            int i=0;            
            stmt=cx.conectaDB().createStatement();
            i=stmt.executeUpdate(sql);
            
        }catch (SQLException ex) {
            System.out.println("capturando"+ex.getMessage()); 
        }
    }
public void EliminarCliente(String id){
        
        try {
            sql = " delete from cliente "+
                  " where cliente_id='"+id+"' ";
                  
            int i=0;            
            stmt=cx.conectaDB().createStatement();
            i=stmt.executeUpdate(sql);
            
        }catch (SQLException ex) {
            System.out.println("capturando"+ex.getMessage()); 
        }
    }  

    
    
}
