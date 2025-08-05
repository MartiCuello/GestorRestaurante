
package Logica;

import Excepciones.RestauranteException;
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
    
    public Categoria getCategoria(){
        return categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public UnidadProcesadora getUnidadProcesadora() {
        return unidadProcesadora;
    }
    
    public ArrayList<Ingrediente> getIngredientes(){
        return ingredientes;
    }
    
    //METODOS DE STOCK
    //validacion segun stock
    public boolean sePuedeHacer(){
        for(Ingrediente i : ingredientes){
            if(!i.hayStock()){
                return false;
            }
        }
        return true;
    }
    
    
    public void reintegrarStock(){
        for (Ingrediente i : ingredientes) {
            i.getInsumo().sumarStock(i.getCantidad());
        }
    }
    
    public void descontarStock() throws RestauranteException {
        for (Ingrediente i : ingredientes) {
            Insumo ins = i.getInsumo();
            int cantidadNecesaria = i.getCantidad();
            if (ins.getStockActual() < cantidadNecesaria) {
                throw new RestauranteException("No hay stock suficiente de " + ins.getNombre() + " para preparar el item " + this.getNombre());
            }
        ins.restarStock(cantidadNecesaria);
        }
    }
}
