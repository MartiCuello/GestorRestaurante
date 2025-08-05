
package controlers;

import Excepciones.RestauranteException;
import Vistas.IVistaProcesarPedido;
import Logica.Fachada;
import Logica.Gestor;
import Logica.Pedido;
import Logica.SesionGestor;
import Logica.UnidadProcesadora;
import Observer.Observable;
import Observer.Observador;

public class ControladorProcesarPedido implements Observador {
    public IVistaProcesarPedido vista;
    public Gestor gestor;
    
    public ControladorProcesarPedido(IVistaProcesarPedido vista, Gestor gestor){
        this.vista = vista;
        this.gestor = gestor;
        gestor.getUnidadProcesadora().agregarObservador(this);
        Fachada.getInstancia().agregarObservador(this);
        inicializarVista();
    }

    private void inicializarVista() {
        vista.cargarPedidos(gestor.getUnidadProcesadora().getPedidos());
        vista.cargarDatosGestor();
        vista.cargarPedidosTomados(gestor.getPedidosTomados());
    }
    
    public void tomarPedido(int indice){
        Pedido p = gestor.getUnidadProcesadora().getPedidos().get(indice);
        gestor.tomarPedido(p);
    }
    
    public void finalizarPedido(int indice){
        try{
            Pedido p = gestor.getPedidosTomados().get(indice);
            gestor.finalizarPedido(p);
        }
        catch(RestauranteException e){
            vista.mostrarMensaje(e.getMessage());
        }
    }
    
    public void entregarPedido(int indice){
        try{
            Pedido p = gestor.getPedidosTomados().get(indice);
            gestor.entregarPedido(p);
        }
        catch(RestauranteException e){
            vista.mostrarMensaje(e.getMessage());
        }
    }
    
    public boolean finalizarVista(SesionGestor Sesiongestor) {
        try{
          Fachada.getInstancia().logoutGestor(Sesiongestor);  
          return true;
        }
        catch(RestauranteException e){
            vista.mostrarMensaje(e.getMessage());
            return false;
        }
    }

    
    @Override
    public void actualizar(Object evento, Observable origen) {
        if(evento == UnidadProcesadora.eventos.nuevoPedidoConfirmado){
            vista.cargarPedidos(gestor.getUnidadProcesadora().getPedidos());
        }
        if (evento == Fachada.eventos.pedidoTomado) {
            vista.cargarPedidos(gestor.getUnidadProcesadora().getPedidos());
            vista.cargarPedidosTomados(gestor.getPedidosTomados());
        }
        else if(evento == Fachada.eventos.pedidoFinalizado || evento == Fachada.eventos.pedidoEntregado){
            vista.cargarPedidosTomados(gestor.getPedidosTomados());
        }
        
    }
 }