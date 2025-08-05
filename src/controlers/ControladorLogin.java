package controlers;

import Vistas.IVistaLogin;
import Excepciones.RestauranteException;
import Logica.Dispositivo;
import Logica.Fachada;
import Logica.SesionGestor;
import Observer.Observable;
import Observer.Observador;


public class ControladorLogin implements Observador {
    public IVistaLogin vista;
    
    public ControladorLogin(IVistaLogin vista) {
        this.vista = vista;
        Fachada.getInstancia().agregarObservador(this);        
        inicializarVista();
    }
    
    private void inicializarVista(){
        vista.cargarDispositivos(Fachada.getInstancia().getDispositivos());
    }
    
    public void seleccionarDispositivo(int indice){
        Dispositivo d = Fachada.getInstancia().getDispositivos().get(indice);
        try{
            d.validarDisponible();
            vista.abrirDispositivo(d);
        }
        catch(RestauranteException e){
            vista.mostrarMensaje(e.getMessage());
        }

    }
    
    public void login(String user, String pass){
        try{
            SesionGestor s = Fachada.getInstancia().loginGestor(user, pass);
            vista.ingresar(s);
        }
        catch(RestauranteException e){
            vista.mostrarMensaje(e.getMessage());
        } 
    }

    @Override
    public void actualizar(Object evento, Observable origen) {
       if (evento == Fachada.eventos.nuevoLoginCliente){
           vista.cargarDispositivos(Fachada.getInstancia().getDispositivos());
       }
       else if (evento == Fachada.eventos.logoutCliente){
           vista.cargarDispositivos(Fachada.getInstancia().getDispositivos());
       }
    }
    
}
    
