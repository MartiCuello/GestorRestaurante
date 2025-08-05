
package Logica;

import Excepciones.RestauranteException;

public class Dispositivo {
   public static int ultimoId = 0;
    private int id;
    private EstadoDispositivo estado;
    private Cliente clienteActual;
    private Servicio servicioActual;
   
    public Dispositivo() {
        this.id = ultimoId++;
        this.estado = estado.disponible;
        this.clienteActual = null;
        this.servicioActual = null;
    }
    
    //cambios de estado
    public void ocupar(Cliente c, Servicio s) throws RestauranteException {
        if (estado != EstadoDispositivo.disponible) {
            throw new RestauranteException("El dispositivo esta ocupado. Debe primero finalizar el servicio actual.");
        }
        setCliente(c);
        setServicio(s);
        setEstado(EstadoDispositivo.ocupado);
    }

    public void liberar() {
        this.estado = EstadoDispositivo.disponible;
        this.clienteActual = null;
        this.servicioActual = null;
    }
    
    //validaciones
    public void validarDisponible() throws RestauranteException {
        if (estado == EstadoDispositivo.ocupado) {
            throw new RestauranteException("El dispositivo esta ocupado.");
        }
    }
    
    public void validarLogueo() throws RestauranteException{
        if(servicioActual == null && clienteActual == null){
            throw new RestauranteException("Debe identificarse antes de realizar pedidos");
        }
    }

    //getters
    public int getId() {
        return id;
    }
    
    public EstadoDispositivo getEstado() {
        return estado;
    }

    public Cliente getCliente() {
        return clienteActual;
    }
    
    public Servicio getServicio(){
        return servicioActual;
    }

    //setters
    public void setCliente(Cliente c) {
        this.clienteActual = c;
    }
    
    public void setServicio(Servicio s){
        this.servicioActual = s;
    }
    
    public void setEstado(EstadoDispositivo estado){
        this.estado = estado;
    }
}
