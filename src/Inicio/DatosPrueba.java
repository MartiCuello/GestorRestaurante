
package Inicio;

import Logica.Categoria;
import Logica.Comun;
import Logica.DeLaCasa;
import Logica.Fachada;
import Logica.Frecuente;
import Logica.Preferencial;

public class DatosPrueba {
    
    public static void cargar(){
        
        Fachada fachada = Fachada.getInstancia();
        
        //DISPOSITIVOS
        fachada.agregarDispositivo();
        fachada.agregarDispositivo();
        fachada.agregarDispositivo();
        
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
        fachada.agregarGestor("Maria123", "mp", "Maria Perez", fachada.getUnidades().get(0)); //gestor de bar
        fachada.agregarGestor("Gime123", "gm", "Gimena Gomez", fachada.getUnidades().get(1)); //gestor de cocina
        fachada.agregarGestor("Juan123", "jg", "Juan Gomez", fachada.getUnidades().get(2)); //gestor de pasteleria
        
        //CATEGORIAS
        fachada.agregarCategoria("Entradas");
        fachada.agregarCategoria("Plato principal");
        fachada.agregarCategoria("Postres");
        fachada.agregarCategoria("Bebidas");
        fachada.agregarCategoria("Cafe");
        fachada.agregarCategoria("Tragos");
        
        Categoria entradas = Fachada.getInstancia().getCategorias().get(0);
        Categoria platoPincipal = Fachada.getInstancia().getCategorias().get(1);
        Categoria postres = Fachada.getInstancia().getCategorias().get(2);
        Categoria bebidas = Fachada.getInstancia().getCategorias().get(3);
        Categoria cafe = Fachada.getInstancia().getCategorias().get(4);
        Categoria tragos = Fachada.getInstancia().getCategorias().get(5);
        
        
        //INSUMOS
        fachada.agregarInsumo("Agua", 1, 5);
        fachada.agregarInsumo("Naranja", 1, 15);
        fachada.agregarInsumo("Ron", 1, 3);
        fachada.agregarInsumo("Frutilla", 3, 50);
        fachada.agregarInsumo("Marisco", 5, 40);
        fachada.agregarInsumo("Cerdo", 1, 5);
        fachada.agregarInsumo("Nalga", 1, 2);
        fachada.agregarInsumo("Sorrentino", 5, 4);
        fachada.agregarInsumo("Dulce de leche", 1, 3);
        fachada.agregarInsumo("Manzana", 1, 34);
        fachada.agregarInsumo("Cafe", 1, 10);
        fachada.agregarInsumo("Leche", 1, 15);
        
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
        
        //INGREDIENTES PARA CADA ITEM
        // Botella de agua
        fachada.agregarIngrediente(fachada.getItems().get(0), fachada.getInsumos().get(0), 1);//Agua
        // Jugo de naranja
        fachada.agregarIngrediente(fachada.getItems().get(1), fachada.getInsumos().get(0), 1);//Agua
        fachada.agregarIngrediente(fachada.getItems().get(1), fachada.getInsumos().get(1), 3);//Naranja
        // Mojito
        fachada.agregarIngrediente(fachada.getItems().get(2), fachada.getInsumos().get(0), 1);//Agua
        fachada.agregarIngrediente(fachada.getItems().get(2), fachada.getInsumos().get(2), 1);//Ron
        // Daikiri de frutilla
        fachada.agregarIngrediente(fachada.getItems().get(3), fachada.getInsumos().get(2), 1);//Ron
        fachada.agregarIngrediente(fachada.getItems().get(3), fachada.getInsumos().get(3), 3);//Frutilla
        // Rabas
        fachada.agregarIngrediente(fachada.getItems().get(4), fachada.getInsumos().get(4), 4);//Marisco
        // Bruschettas
        fachada.agregarIngrediente(fachada.getItems().get(5), fachada.getInsumos().get(5), 1);//Cerdo
        // Milanesa en dos panes
        fachada.agregarIngrediente(fachada.getItems().get(6), fachada.getInsumos().get(6), 2);//Nalga
        // Sorrentinos caprese
        fachada.agregarIngrediente(fachada.getItems().get(7), fachada.getInsumos().get(7), 5);//Sorrentino
        // Panqueques
        fachada.agregarIngrediente(fachada.getItems().get(8), fachada.getInsumos().get(8), 1);//Dulce de leche
        // Apple pie
        fachada.agregarIngrediente(fachada.getItems().get(9), fachada.getInsumos().get(9), 2);//Manzana
        // Brownie
        fachada.agregarIngrediente(fachada.getItems().get(10), fachada.getInsumos().get(8), 1);//Dulce de leche
        // Americano
        fachada.agregarIngrediente(fachada.getItems().get(11), fachada.getInsumos().get(10), 1);//Café
        // Capuccino
        fachada.agregarIngrediente(fachada.getItems().get(12), fachada.getInsumos().get(10), 1);//Café
        fachada.agregarIngrediente(fachada.getItems().get(12), fachada.getInsumos().get(11), 1);//Leche      
    }
}
    
