
package Logica;

public class Insumo {
    private String nombre;
    private int sotckMinimo;
    private int stockActual;

    public Insumo(String nombre, int sotckMinimo, int stockActual) {
        this.nombre = nombre;
        this.sotckMinimo = sotckMinimo;
        this.stockActual = stockActual;
    }

    //getters
    public String getNombre() {
        return nombre;
    }

    public int getSotckMinimo() {
        return sotckMinimo;
    }

    public int getStockActual() {
        return stockActual;
    }

    //setters
    public void setStockActual(int stockActual) {
        this.stockActual = stockActual;
    }  
    
    //metodos de stock
    public void sumarStock(int cantidad) {
        this.stockActual += cantidad;
    }
    public void restarStock(int cantidad) {
        this.stockActual -= cantidad;
    }
}
