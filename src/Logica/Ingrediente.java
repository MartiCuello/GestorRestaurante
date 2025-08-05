
package Logica;

public class Ingrediente {
    private Insumo insumo;
    private int cantidad;

    public Ingrediente(Insumo insumo, int cantidad) {
        this.insumo = insumo;
        this.cantidad = cantidad;
    }
    //getters
    public Insumo getInsumo() {
        return insumo;
    }
    public int getCantidad() {
        return cantidad;
    }
    //validacion de stock
    public boolean hayStock(){
        if(insumo.getStockActual() >= cantidad){
            return true;
        }
        return false;
    }
}
