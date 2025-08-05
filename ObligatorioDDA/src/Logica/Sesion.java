
package Logica;

import java.util.Date;

public class Sesion {
    private Cliente cliente;
    private Date fecha = new Date();

    public Sesion(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Date getFecha() {
        return fecha;
    }
    
    
}
