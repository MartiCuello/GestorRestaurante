package Logica;

import java.util.ArrayList;


public class Categoria {
    private String nombre;
    private ArrayList<Item> items;

    public Categoria(String nombre) {
        this.nombre = nombre;
        this.items = new ArrayList<Item>();
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Item> getItems() {
        return items;
    }
    
    //mostrar solo los items que tengan stock disponible 
    public ArrayList<Item> getItemsDisponibles(){
        ArrayList<Item> result = new ArrayList<Item>();
        for (Item i : items){
            if(i.sePuedeHacer()){
                result.add(i);
            }
        }
        return result;
    }
}
