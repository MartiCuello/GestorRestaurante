
package Logica;
public class Frecuente extends TipoCliente {

    public Frecuente(String nombre) {
        super(nombre);
    }

    @Override
    public double calcularDescuento(Servicio s) {
        double descuentoCafe = 0;
        for (Pedido p : s.getPedidos()) {
            Item item = p.getItem();
            if (item.getCategoria().getNombre() == "Cafe") {
                descuentoCafe += item.getPrecio();
            }
        }
        return descuentoCafe;
    }

    @Override
    public String descripcionBeneficio() {
        return "Beneficio: café gratis en este servicio.";
    }
}
