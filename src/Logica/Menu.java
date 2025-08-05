
package Logica;

import java.util.ArrayList;

public class Menu {
    private ArrayList<Categoria> categorias;
    
    private static Menu instancia = new Menu();
    
    public static Menu getInstancia(){
        return instancia;
    }

    public Menu() {
        categorias = new ArrayList<Categoria>();
    }

    public ArrayList<Categoria> getCategorias() {
        return categorias;
    }
}
