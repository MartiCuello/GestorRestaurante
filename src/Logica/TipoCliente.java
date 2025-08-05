
package Logica;

public abstract class TipoCliente {
    private String nombre;

    public TipoCliente(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
    
    public abstract double calcularDescuento(Servicio s);
    
    public abstract String descripcionBeneficio();
}
