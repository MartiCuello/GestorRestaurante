
package Logica;
public class Preferencial extends TipoCliente {

    public Preferencial(String nombre) {
        super(nombre);
    }

    @Override
    public double calcularDescuento(Servicio s) {
        double descuentoAgua = 0;
        for (Pedido p : s.getPedidos()) {
            Item item = p.getItem();
            if (item.getNombre().toLowerCase().contains("agua")) {
                descuentoAgua += item.getPrecio();
            }
        }
        double total = s.getMontoTotal();
        if (total > 2000) {
            return descuentoAgua + (total * 0.05);
        }
        return descuentoAgua;
    }

    @Override
    public String descripcionBeneficio() {
       return "Beneficio: agua mineral gratis, y 5% de descuento si monto supera $2000.";
    }
}
