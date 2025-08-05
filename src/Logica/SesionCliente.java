
package Logica;

public class SesionCliente {
    private Cliente cliente;
    private Dispositivo dispositivo;

    public SesionCliente(Cliente cliente, Dispositivo dispositivo) {
        this.cliente = cliente;
        this.dispositivo = dispositivo;
    }

    public Cliente getCliente() {
        return cliente;
    }
    
    public Dispositivo getDispositivo(){
        return dispositivo;
    }
    
    public void setDispositivo(Dispositivo d){
        this.dispositivo = d;
    }
}
