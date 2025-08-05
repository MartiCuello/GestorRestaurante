
package Logica;

import java.util.ArrayList;

public class SistemaAcceso {
    
    private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    private ArrayList<Gestor> gestores = new ArrayList<Gestor>();
    private ArrayList<Sesion> sesiones = new ArrayList();
    
    
    public void agregarcliente(String num, String nombreCompleto, String password, TipoCliente tipo){
        Cliente c = new Cliente(num, nombreCompleto, password, tipo);
        clientes.add(c);
    }
    
    public void agregarGestor(String nomUsuario, String password, String nombreCompleto, UnidadProcesadora unidad){
        Gestor g = new Gestor(nomUsuario, password, nombreCompleto, unidad);
        gestores.add(g);
    }

    public ArrayList<Sesion> getSesiones() {
        return sesiones;
    }
    
    public Sesion loginCliente(String num, String password){
        Cliente c = this.buscarCliente(num, password);
        if (c!=null){
            Sesion s = new Sesion(c);
                sesiones.add(s);
                return s;
        }       
        return null;
    }
    
    public Gestor loginGestor(String nombre,String password){
        Gestor g = this.buscarGestor(nombre, password);        
        return g;
    }
    
    
   private Cliente buscarCliente(String num, String password){
        for(Cliente c : clientes){
            if(c.getPassword().equals(password) && c.getNumCliente().equals(num)){              
                return c;
            }
        }
        return null;   
   } 
   
   private Gestor buscarGestor (String nomUser, String password)
   {
       for (Gestor g : gestores){
           if (g.getNomUsuario().equals(nomUser) && g.getPassword().equals(password)){
               return g;
           }
       }
       return null;
   }
   
}
