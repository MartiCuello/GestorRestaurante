
package Logica;

import Observer.Observable;
import java.util.ArrayList;

public class UnidadProcesadora extends Observable {
    private String nombre;
    private ArrayList<Pedido> pedidos;
    
    public enum eventos {nuevoPedidoConfirmado};

    public UnidadProcesadora(String nombre) {
        this.nombre = nombre;
        pedidos = new ArrayList<Pedido>();
    }

    public String getNombre() {
        return nombre;
    }
    
    public ArrayList<Pedido> getPedidos(){
        return pedidos;
    }
    
    public void agregarPedido(Pedido p){
        pedidos.add(p);
        this.avisar(eventos.nuevoPedidoConfirmado);
    }

}
