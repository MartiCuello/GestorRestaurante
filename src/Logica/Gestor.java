
package Logica;

import Excepciones.RestauranteException;
import java.util.ArrayList;

public class Gestor {
   private String nomUsuario;
   private String password;
   private String nombreCompleto;
   private UnidadProcesadora unidadProcesadora;
   private ArrayList<Pedido> pedidosTomados = new ArrayList<>();

    public Gestor(String nomUsuario, String password, String nombreCompleto, UnidadProcesadora unidadProcesadora) {
        this.nomUsuario = nomUsuario;
        this.password = password;
        this.nombreCompleto = nombreCompleto;
        this.unidadProcesadora = unidadProcesadora;
    }
    
    //MANEJO DE PEDIDOS
    public void tomarPedido(Pedido pedido){
        pedido.asignarAGestor(this);
        pedidosTomados.add(pedido);
        unidadProcesadora.getPedidos().remove(pedido);
        Fachada.getInstancia().avisar(Fachada.eventos.pedidoTomado);
    }

    public ArrayList<Pedido> getPedidosTomados() {
        return pedidosTomados;
    }
    
    public void finalizarPedido(Pedido p) throws RestauranteException {
        p.finalizar();
        Fachada.getInstancia().avisar(Fachada.eventos.pedidoFinalizado);
    }

    public void entregarPedido(Pedido p) throws RestauranteException {
        p.entregado();
        Fachada.getInstancia().avisar(Fachada.eventos.pedidoEntregado);
    }
    
    
    //getters
    public String getNomUsuario() {
        return nomUsuario;
    }

    public String getPassword() {
        return password;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public UnidadProcesadora getUnidadProcesadora() {
        return unidadProcesadora;
    }
}
