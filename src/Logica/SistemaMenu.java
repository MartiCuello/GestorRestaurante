
package Logica;

import java.util.ArrayList;

public class SistemaMenu {
    private ArrayList<Item> items = new ArrayList<Item>();
    private ArrayList<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
    private ArrayList<Insumo> insumos = new ArrayList<Insumo>();

    public void agregarCategoria(String nombre){
        Menu.getInstancia().getCategorias().add(new Categoria(nombre));
    }
    
    public ArrayList<Categoria> getCategorias(){
        return Menu.getInstancia().getCategorias();
    }
    
    public void agregarItem(String nombre, double precio, UnidadProcesadora unidad, Categoria cat){
        Item nuevo = new Item(nombre, precio,unidad, cat);
        items.add(nuevo);
        cat.getItems().add(nuevo);
    }
   
    public ArrayList<Item> getItems(){
        return items;
    }
    
    public void agregarIngrediente(Item i, Insumo insumo, int cantidad){
        i.getIngredientes().add(new Ingrediente(insumo,cantidad));
    }
    
    public void agregarInsumo(String nombre, int stockMin, int stockActual){
        insumos.add(new Insumo(nombre,stockMin,stockActual));
    }
    
    public ArrayList<Insumo> getInsumo(){
        return insumos;
    }

}
