
package Logica;

import Excepciones.RestauranteException;
import Observer.Observable;
import java.time.LocalDate;

public class Pedido extends Observable {
    private Item item;
    private EstadoPedido estado;
    private String comentario;
    private Cliente cliente;
    private LocalDate horaPedido;
    private Gestor gestor;


    public Pedido(Item item, String c, Cliente cli) {
        this.item = item;
        this.estado = EstadoPedido.noConfirmado;
        this.comentario = c;
        this.cliente = cli;
        this.horaPedido = LocalDate.now();
        this.gestor = null;
    }
    
    //MANEJOS DE ESTADO
   
    //no confirmado - confirmado
    public void confirmar(){
        this.setEstado(EstadoPedido.confirmado);
    }
    
    //confirmado - enProceso (pedido tomado por gestor)
    public void asignarAGestor(Gestor gestor){
        this.setEstado(EstadoPedido.enProceso);
        this.setGestor(gestor);
    }
    
    //enProceso - finalizado (pedido finalizado por gestor)
    public void finalizar() throws RestauranteException {
        if (estado != EstadoPedido.enProceso) {
            throw new RestauranteException("El pedido debe estar en proceso para finalizarlo.");
        }
        this.setEstado(EstadoPedido.finalizado);
    }
    
    //finalizado - entregado
    public void entregado() throws RestauranteException {
        if (estado != EstadoPedido.finalizado) {
            throw new RestauranteException("El pedido debe estar finalizado para ser entregado.");
        }
        this.setEstado(EstadoPedido.entregado);
    }
    
    //getters
    public String getComentario() {
        return comentario;
    }
    public Cliente getCliente(){
        return cliente;
    }
    public Item getItem() {
        return item;
    }
   
    public Gestor getGestor(){
        return gestor;
    }
    
    public EstadoPedido getEstado() {
        return estado;
    }
    
    public LocalDate getHoraPedido(){
        return horaPedido;
    }

    //setters
    public void setGestor(Gestor g){
        this.gestor = g;
    }
    
    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }
    
    //AUX
    public boolean estaFinalizado(){
        if(this.estado == EstadoPedido.finalizado){
            return true;
        }
        return false;
    }
}
