
package Logica;
public class Comun extends TipoCliente {

    public Comun(String nombre) {
        super(nombre);
    }

    @Override
    public double calcularDescuento(Servicio s) {
        return 0;
    }

    @Override
    public String descripcionBeneficio() {
        return "Cliente común: no tiene beneficios aplicados.";
    }

}
