
package Inicio;

import Logica.Categoria;
import Logica.Cliente;
import Logica.Comun;
import Logica.DeLaCasa;
import Logica.Fachada;
import Logica.Frecuente;
import Logica.Item;
import Logica.Preferencial;

public class DatosPrueba {
    
    public static void cargar(){
        
        Fachada fachada = Fachada.getInstancia();
        
        //TIPOS DE CLIENTES
        fachada.agregarTipoCliente(new Comun ("Comun"));
        fachada.agregarTipoCliente(new Preferencial ("Preferencial"));
        fachada.agregarTipoCliente(new DeLaCasa ("De la casa"));
        fachada.agregarTipoCliente(new Frecuente ("Frecuente"));
    
        //CLIENTES
        fachada.agregarcliente("1","Juan Perez","jp", fachada.getTiposCliente().get(0)); //comun
        fachada.agregarcliente("2","Monica Diaz","md", fachada.getTiposCliente().get(1)); //preferencial
        fachada.agregarcliente("3","Martin Garcia","mg", fachada.getTiposCliente().get(2)); //de la casa
        fachada.agregarcliente("4","Emilia Sanchez","es", fachada.getTiposCliente().get(3)); //frecuente

        //UNIDADES PROCESADORAS
        fachada.agregarUnidadProcesadora("Bar");
        fachada.agregarUnidadProcesadora("Cocina");
        fachada.agregarUnidadProcesadora("Pasteleria");
        
        //GESTORES
        fachada.agregarGestor("Jose123", "jm", "Jose Millan", fachada.getUnidades().get(0)); //gestor de bar
        fachada.agregarGestor("Gime123", "gm", "Gimena Gomez", fachada.getUnidades().get(1)); //gestor de cocina
        fachada.agregarGestor("Gime123", "gm", "Gimena Gomez", fachada.getUnidades().get(2)); //gestor de pasteleria
        
        //CATEGORIAS
        fachada.agregarCategoria("Entradas");
        fachada.agregarCategoria("Plato principal");
        fachada.agregarCategoria("Postres");
        fachada.agregarCategoria("Bebidas");
        fachada.agregarCategoria("Cafe");
        fachada.agregarCategoria("Tragos");
        
        //INSUMOS
        fachada.agregarInsumo("Agua", 1, 30);
        fachada.agregarInsumo("Naranja", 1, 15);
        fachada.agregarInsumo("Ron", 1, 3);
        fachada.agregarInsumo("Frutilla", 3, 50);
        fachada.agregarInsumo("Marisco", 5, 40);
        fachada.agregarInsumo("Cerdo", 1, 5);
        fachada.agregarInsumo("Nalga", 1, 6);
        fachada.agregarInsumo("Sorrentino", 5, 10);
        fachada.agregarInsumo("Dulce de leche", 1, 3);
        fachada.agregarInsumo("Manzana", 1, 34);
        fachada.agregarInsumo("Cafe", 1, 10);
        fachada.agregarInsumo("Leche", 1, 15);
        
        
        //INGREDIENTES
        //fachada.agregarIngrediente(fachada.getInsumos().get(0), 1);
        
        //ITEMS
        //Bar
        fachada.agregarItem("Botella de agua", 90, fachada.getUnidades().get(0), fachada.getCategorias().get(3)); //Bebida
        fachada.agregarItem("Jugo de naranja", 120, fachada.getUnidades().get(0), fachada.getCategorias().get(3)); //Bebida
        fachada.agregarItem("Mojito", 300, fachada.getUnidades().get(0), fachada.getCategorias().get(5)); //Tragos
        fachada.agregarItem("Daikiri de frutilla", 280, fachada.getUnidades().get(0), fachada.getCategorias().get(5)); //Tragos
        //Cocina
        fachada.agregarItem("Rabas", 300, fachada.getUnidades().get(1), fachada.getCategorias().get(0)); //Entrada
        fachada.agregarItem("Bruschettas", 250, fachada.getUnidades().get(1), fachada.getCategorias().get(0)); //Entrada
        fachada.agregarItem("Milanesa en dos panes", 320, fachada.getUnidades().get(1), fachada.getCategorias().get(1)); //Plato principal
        fachada.agregarItem("Sorrentinos caprese", 400, fachada.getUnidades().get(1), fachada.getCategorias().get(1)); //Plato principal
        //Pasteleria
        fachada.agregarItem("Panqueques", 180, fachada.getUnidades().get(2), fachada.getCategorias().get(2));  //Postre
        fachada.agregarItem("Apple pie", 200, fachada.getUnidades().get(2), fachada.getCategorias().get(2));  //Postre 
        fachada.agregarItem("Brownie", 200, fachada.getUnidades().get(2), fachada.getCategorias().get(2));  //Postre 
        fachada.agregarItem("Americano", 150, fachada.getUnidades().get(2), fachada.getCategorias().get(4));   //Cafe
        fachada.agregarItem("Capuccino", 200, fachada.getUnidades().get(2), fachada.getCategorias().get(4));  //Cafe
        
        
    }
    
    public static void test(){
        Cliente c = Fachada.getInstancia().loginCliente("2", "md").getCliente();
        if(c == null){
            System.out.println("Cliente incorrecto");
        }
        System.out.println("Bienvenido Cliente: " + c.getNombreCompleto().toUpperCase());
        
        for(Categoria cat : Fachada.getInstancia().getCategorias()){
            if(cat.getNombre() == "Postres"){
                for(Item i : cat.getItems()){
                System.out.println(i.getNombre());
                }
            }
            
        }
    }
}
