
package Logica;

import Excepciones.RestauranteException;
import java.util.ArrayList;

public class SistemaAcceso {
    
    private ArrayList<Dispositivo> dispositivos = new ArrayList<Dispositivo>();
    private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    private ArrayList<Gestor> gestores = new ArrayList<Gestor>();
    
    private ArrayList<SesionGestor> sesionesGestor = new ArrayList<SesionGestor>();
    private ArrayList<SesionCliente> sesionesCliente = new ArrayList<SesionCliente>();
    
    //DISPOSITIVOS
    public void agregarDispositivo(){
        dispositivos.add(new Dispositivo());
    }
    
    public ArrayList<Dispositivo> getDispositivos(){
        return dispositivos;
    }
    
    //CLIENTES
    public void agregarcliente(String num, String nombreCompleto, String password, TipoCliente tipo){
        Cliente c = new Cliente(num, nombreCompleto, password, tipo);
        clientes.add(c);
    }
    
    public SesionCliente loginCliente(String num, String password, Dispositivo d)throws RestauranteException{
        Cliente c = this.buscarCliente(num, password);
        if (c==null){
            throw new RestauranteException("Credenciales incorrectas");
        }    
        for (SesionCliente s : sesionesCliente) {
            if (s.getCliente().getNumCliente().equals(c.getNumCliente())) {
                throw new RestauranteException("Acceso denegado. El usuario ya esta logueado en otro dispositivo");
            }
        }
        SesionCliente sc = new SesionCliente(c,d);
        sesionesCliente.add(sc);
        Servicio s = new Servicio(c,d);
        Fachada.getInstancia().agregarServicio(s);
        d.ocupar(c,s);
        Fachada.getInstancia().avisar(Fachada.eventos.nuevoLoginCliente);
        return sc;
    }
    
    public void logoutCliente(SesionCliente sesion) throws RestauranteException {
        Servicio servicio = sesion.getDispositivo().getServicio();
        if (servicio != null) {
            servicio.finalizar(); 
        }
        sesionesCliente.remove(sesion);
    }
    
    //GESTORES
    public void agregarGestor(String nomUsuario, String password, String nombreCompleto, UnidadProcesadora unidad){
        Gestor g = new Gestor(nomUsuario, password, nombreCompleto, unidad);
        gestores.add(g);
    }
        
    public SesionGestor loginGestor(String nombre, String password) throws RestauranteException {
        Gestor g = this.buscarGestor(nombre, password);
        if (g == null) {
            throw new RestauranteException("Credenciales incorrectas");
        }
        for (SesionGestor sg : sesionesGestor) {
            if (sg.getGestor().getNomUsuario().equals(g.getNomUsuario())) {
                throw new RestauranteException("Acceso denegado. El usuario ya esta logueado");
            }
        }

        SesionGestor s = new SesionGestor(g);
        sesionesGestor.add(s);
        return s;
    }
    
    public void logoutGestor(SesionGestor s) throws RestauranteException {
        for (Pedido p : s.getGestor().getPedidosTomados()){
            if(p.getEstado() != EstadoPedido.entregado){
                throw new RestauranteException("Tiene pedidos pendientes"); 
            }
        }
        sesionesGestor.remove(s);
    }
    
  
   //AUX
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
