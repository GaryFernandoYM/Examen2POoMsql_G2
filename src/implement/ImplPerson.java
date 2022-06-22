package implement;

import conexion.ConexionMysql;
import entities.Person;
import entities.Worker;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import resources.Resources;



public class ImplPerson {
    
    ArrayList<Worker> lista= new ArrayList<>();
    
    String sql="";
    String sql2="";
    Statement stmt=null; 
    ResultSet rset=null;
    ConexionMysql cx= new ConexionMysql();
    Resources resource= new Resources();
    ArrayList<Worker> listaworkers = new ArrayList<>();
 
     
    
 
    
    public void registrarPerson(Worker w){
        
        String idPerson = "";
               idPerson = resource.generaID();
        try {
            sql = " insert into person ( person_id, person_nombres, person_paterno, person_materno, person_nro_di, person_usuario, person_password) "+
                  " values ('"+idPerson+"','"+w.getPerson_nombres()+"','"+w.getPerson_paterno()+"','"+w.getPerson_materno()+"','"+w.getPerson_nro_di()+"','"+w.getPerson_usuario()+"','"+w.getPerson_password()+"' ) ";
            int i=0;            
            stmt=cx.conectaDB().createStatement();
            i=stmt.executeUpdate(sql);
            
            
            String idWorker = "";
                   idWorker = resource.generaID();
            sql2 = " insert into worker ( worker_id, worker_salario, worker_codigotrabajador, worker_person_id  ) "+
                   " values ('"+idWorker+"','"+w.getWorker_salario()+"','"+w.getWorker_codigotrabajador()+"','"+idPerson+"' ) ";
            
            stmt=cx.conectaDB().createStatement();
            i=stmt.executeUpdate(sql2);
    
            
        }catch (SQLException ex) {
            System.out.println("capturando"+ex.getMessage()); 
        }
    }
    
    
   
    
    public Person validateLogin(Person p){
                
        Person ps = null;
        try{
            sql=" select * from person "+
                " where person_usuario='"+p.getPerson_usuario()+"'   "+
                " and  person_password='"+p.getPerson_password()+"'  ";
            
            stmt=cx.conectaDB().createStatement();
            rset= stmt.executeQuery(sql);
            if(rset.next()){
              ps = new Person();
              ps.setPerson_usuario(rset.getString("person_usuario"));
              ps.setPerson_password(rset.getString("person_password"));              
            }else {
              ps= null;
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }
        
        return ps;
        }

    public ArrayList<Worker> reporteWorkers(){
        try {
            sql=" select * from person ";
            stmt=cx.conectaDB().createStatement();
            rset=stmt.executeQuery(sql);
            while(rset.next()){
                 Worker ps = new Worker();
                ps.setPerson_id(rset.getString("person_id"));
                ps.setPerson_nombres(rset.getString(2));
                ps.setPerson_paterno(rset.getString(3));
                ps.setPerson_materno(rset.getString(4));
                ps.setPerson_nro_di(rset.getString(5));
                ps.setPerson_usuario(rset.getString(6));
                ps.setPerson_password(rset.getString(7));
                listaworkers.add(ps);            
            }
        } catch (SQLException ex) {
                ex.getMessage();
        }
        return listaworkers;
    }    
    
    public void ActualizarWorker(Worker w){        
        
        try {
            sql = " update person "+
                  " set person_nombres= '"+w.getPerson_nombres()+"' "+  
                  " , person_paterno= '"+w.getPerson_paterno()+"'"+
                  " , person_materno= '"+w.getPerson_materno()+"'"+
                  " , person_nro_di= '"+w.getPerson_nro_di()+"'"+
                  " , person_usuario= '"+w.getPerson_usuario()+"'"+
                  " , person_password= '"+w.getPerson_password()+"'"+
                  " where person_id='"+w.getPerson_id()+"' ";
                  
            int i=0;            
            stmt=cx.conectaDB().createStatement();
            i=stmt.executeUpdate(sql);
            
        }catch (SQLException ex) {
            System.out.println("capturando "+ex.getMessage()); 
        }
    }
    public void EliminarWorker(String id){
        
        try {
            sql = " delete from person "+
                  " where person_id='"+id+"' ";
                  
            int i=0;            
            stmt=cx.conectaDB().createStatement();
            i=stmt.executeUpdate(sql);
            
        }catch (SQLException ex) {
            System.out.println("capturando"+ex.getMessage()); 
        }
    }
   
   
}