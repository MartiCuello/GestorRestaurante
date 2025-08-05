
package Logica;
public class DeLaCasa extends TipoCliente {

    public DeLaCasa(String nombre) {
        super(nombre);
    }

    @Override
    public double calcularDescuento(Servicio s) {
        return 500;
    }

    @Override
    public String descripcionBeneficio() {
        return "Beneficio: $500 de consumo gratis por servicio.";
    }
}
