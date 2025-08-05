/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import java.util.ArrayList;

public class SistemaMenu {
    private ArrayList<Categoria> categorias = new ArrayList<Categoria>();
    private ArrayList<Item> items = new ArrayList<Item>();
    private ArrayList<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
    private ArrayList<Insumo> insumos = new ArrayList<Insumo>();
    
    public void agregarCategoria(String nombre){
        categorias.add(new Categoria(nombre));
    }
    
    public ArrayList<Categoria> getCategorias(){
        return categorias;
    }
    
    public void agregarItem(String nombre, double precio, UnidadProcesadora unidad, Categoria cat){
        Item nuevo = new Item(nombre, precio,unidad, cat);
        items.add(nuevo);
        cat.getItems().add(nuevo);
    }
    
    public ArrayList<Item> getItems(){
        return items;
    }
    
    public void agregarIngrediente(Insumo insumo, int cantidad){
        ingredientes.add(new Ingrediente(insumo,cantidad));
    }
    
    public void agregarInsumo(String nombre, int stockMin, int stockActual){
        insumos.add(new Insumo(nombre,stockMin,stockActual));
    }
    
    public ArrayList<Insumo> getInsumo(){
        return insumos;
    }
    
}
