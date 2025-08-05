
package Logica;

import java.util.ArrayList;

public class Item {
    private String nombre;
    private double precio;
    private UnidadProcesadora unidadProcesadora;
    private Categoria categoria;
    private ArrayList<Ingrediente> ingredientes;

    public Item(String nombre, double precio, UnidadProcesadora unidadProcesadora, Categoria cat) {
        this.nombre = nombre;
        this.precio = precio;
        this.unidadProcesadora = unidadProcesadora;
        this.categoria = cat;
        this.ingredientes = new ArrayList<Ingrediente>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public UnidadProcesadora getUnidadProcesadora() {
        return unidadProcesadora;
    }

    public void setUnidadProcesadora(UnidadProcesadora unidadProcesadora) {
        this.unidadProcesadora = unidadProcesadora;
    }
    
    
}
