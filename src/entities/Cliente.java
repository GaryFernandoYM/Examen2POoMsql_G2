package entities;


public class Cliente extends Person {

   private String cliente_id; 
   private String cliente_dni_ruc;
   private String cliente_nombres;         
   private String cliente_telefono;       
   private String cliente_direccion;         
   private String cliente_origen;         

    public String getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(String cliente_id) {
        this.cliente_id = cliente_id;
    }

    public String getCliente_dni_ruc() {
        return cliente_dni_ruc;
    }

    public void setCliente_dni_ruc(String cliente_dni_ruc) {
        this.cliente_dni_ruc = cliente_dni_ruc;
    }

    public String getCliente_nombres() {
        return cliente_nombres;
    }

    public void setCliente_nombres(String cliente_nombres) {
        this.cliente_nombres = cliente_nombres;
    }

    public String getCliente_telefono() {
        return cliente_telefono;
    }

    public void setCliente_telefono(String cliente_telefono) {
        this.cliente_telefono = cliente_telefono;
    }

    public String getCliente_direccion() {
        return cliente_direccion;
    }

    public void setCliente_direccion(String cliente_direccion) {
        this.cliente_direccion = cliente_direccion;
    }

    public String getCliente_origen() {
        return cliente_origen;
    }

    public void setCliente_origen(String cliente_origen) {
        this.cliente_origen = cliente_origen;
    }

   
           
           
   
    
    
    
}
