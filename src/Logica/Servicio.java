
package Logica;

import Excepciones.RestauranteException;
import Observer.Observable;
import java.util.ArrayList;

public class Servicio extends Observable{
    private Cliente cliente;
    private ArrayList<Pedido> pedidos;
    private double montoTotal;
    private Dispositivo dispositivo;

    public Servicio(Cliente cliente, Dispositivo d) {
        this.cliente = cliente;
        this.montoTotal = 0;
        this.pedidos = new ArrayList<Pedido>();
        this.dispositivo = d;
    }
    
    public enum eventos {nuevoPedido, confirmarPedidos, eliminarPedido, finalizarServicio, pedidoEliminadoPorStock}

    //MANEJO DE PEDIDOS
    public void agregarPedido(Item i, String c, Cliente cli) throws RestauranteException{
        Pedido p = new Pedido(i,c, this.getCliente());
        if(p.getItem().sePuedeHacer()){
            pedidos.add(p);
        }else{
            throw new RestauranteException("No hay stock suficiente para hecer el pedido");
        }
        
        this.avisar(eventos.nuevoPedido);
    }
    
    public void confirmarPedidos() throws RestauranteException{
        if (pedidos.isEmpty()){
            throw new RestauranteException("No hay pedidos en el servicio.");
        } 
        
        if (pedidosTodosConfirmados()){
            throw new RestauranteException("No hay pedidos nuevos para confirmar.");
        } 
        for(Pedido p : pedidos){
            if(p.getEstado() == EstadoPedido.noConfirmado){
                p.confirmar();
                p.getItem().descontarStock();
                UnidadProcesadora u = p.getItem().getUnidadProcesadora();
                u.agregarPedido(p);
            }
        }
        Fachada.getInstancia().servicioCambioDeStock(this);
        this.avisar(eventos.confirmarPedidos);
    }
    
    
    public void eliminarPedido(Pedido p) throws RestauranteException{
        if (p.getEstado() == EstadoPedido.noConfirmado || p.getEstado() == EstadoPedido.confirmado){
            p.getItem().reintegrarStock();
            pedidos.remove(p);
            this.avisar(eventos.eliminarPedido);
        }
        else if (p.getEstado() == EstadoPedido.enProceso) {
            throw new RestauranteException("Un poco tarde…Ya estamos elaborando este pedido!");
        }
        
    }
    
    public void finalizar() throws RestauranteException {
        if (pedidos.isEmpty()){
            throw new RestauranteException("No hay pedidos en el servicio");
        }
        if (hayPedidosSinConfirmar()) {
            throw new RestauranteException("Hay pedidos sin confirmar!");
        }  
        if (validarFinalizarPedido()){
            throw new RestauranteException(hayPedidosEnProceso());
        }
        dispositivo.liberar();
        this.cliente = null;
        avisar(eventos.finalizarServicio);
    }
    
    //no se puede modificar la lista con el for each porque da: ConcurrentModificationExceptio
    public void verificarStockPedidos() {
        for (int i = 0; i < pedidos.size(); i++) {
                Pedido p = pedidos.get(i);
            if (p.getEstado() == EstadoPedido.noConfirmado && !p.getItem().sePuedeHacer()) {
                pedidos.remove(i);
                this.avisar(eventos.pedidoEliminadoPorStock);
                i--;
            }
        }
    }
    
    //AUX
    //hay pedidos sin confirmar?
    private boolean hayPedidosSinConfirmar(){
        boolean result = false;
        for (Pedido p : pedidos){
            if(p.getEstado() == EstadoPedido.noConfirmado){
                result = true;
            }
        }
        return result;
    }
    
    //estan todos los pedidos confirmados??
    private boolean pedidosTodosConfirmados() {
        for (Pedido p : pedidos) {
            if (p.getEstado() != EstadoPedido.confirmado) {
                return false;
            }
        }
        return true; 
    }
    
    
    
    //string para mostrar mensaje de pago al cliente
    public String procesarPago() {
       double descuento = cliente.getTipo().calcularDescuento(this);
       double montoFinal = getMontoFinal();
       String beneficio = cliente.getTipo().descripcionBeneficio();
       String msjAdicional = this.hayPedidosEnProceso();

       String mensaje = "Pago realizado exitosamente.\n\n"; 
       mensaje += "Beneficio aplicado: " + beneficio + "\n";
       mensaje += "Monto de descuento: " + descuento + "\n";
       mensaje += "Monto total a pagar: " + montoFinal + "\n\n";
       mensaje += msjAdicional;

       return mensaje;
   }
    
    //hay algun pedido en proceso?
    public String hayPedidosEnProceso(){
        String result = "";
        int cantEnProceso = 0;
        for (Pedido p : pedidos){
            if(p.getEstado() == EstadoPedido.enProceso){
                cantEnProceso ++;
            }
        }
        if(cantEnProceso > 0){
            result = "Tienes " + cantEnProceso + " pedidos en proceso! recuerda ir a retirarlos";
        }
        return result;
    }
    
    //si hay pedidos en proceso
    private boolean validarFinalizarPedido(){
        boolean result = false;
        for (Pedido p : pedidos){
            if(p.getEstado() == EstadoPedido.enProceso){
                result = true;
            }
        }
        return result;
    }
       
    //getters
    public double getMontoTotal() {
        double montoTotal = 0;
        for (Pedido p : pedidos){
            montoTotal += p.getItem().getPrecio();
        }
        return montoTotal;
    }
    
    public double getMontoFinal() {
        double total = getMontoTotal();
        double descuento = cliente.getTipo().calcularDescuento(this);
        double montoFinal = total - descuento;
        return montoFinal;
    }
    
    public Cliente getCliente() {
        return cliente;
    }
   
    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }
}
