
package Logica;

import java.util.ArrayList;

public class Servicio {
    private Cliente cliente;
    private ArrayList<Pedido> pedidos;
    private double montoTotal;

    public Servicio(Cliente cliente, double montoTotal) {
        this.cliente = cliente;
        this.montoTotal = montoTotal;
        this.pedidos = new ArrayList<Pedido>();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public double getMontoTotal() {
        return montoTotal;
    }
    
    
    
    
}
