/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import java.util.ArrayList;

public class Fachada {
    
    private SistemaAcceso sAcceso = new SistemaAcceso();
    private SistemaPedido sPedido = new SistemaPedido();
    private SistemaCliente sCliente = new SistemaCliente();
    private SistemaUnidadProcesadora sUnidad = new SistemaUnidadProcesadora();
    private SistemaMenu sMenu = new SistemaMenu();
    
    private static Fachada instancia = new Fachada();

    public static Fachada getInstancia() {
        return instancia;
    }
    
    private Fachada() {} 
    
    
    //Sistema Acceso
    public void agregarcliente(String num, String nombreCompleto, String password, TipoCliente tipo){
        sAcceso.agregarcliente(num, nombreCompleto, password, tipo);
    }
    
    public void agregarGestor(String nomUsuario, String password, String nombreCompleto, UnidadProcesadora unidad){
        sAcceso.agregarGestor(nomUsuario, password, nombreCompleto, unidad);
    }

    public ArrayList<Sesion> getSesiones() {
       return sAcceso.getSesiones();
    }
    
    public Sesion loginCliente(String num, String password){
        return sAcceso.loginCliente(num, password);
    }
    
    public Gestor loginGestor(String nombre,String password){
        return sAcceso.loginGestor(nombre, password);
    }
    
    //Sistema Cliente
    public void agregarTipoCliente(TipoCliente tipo){
        sCliente.agregarTipoCliente(tipo);
    }
    
    public ArrayList<TipoCliente> getTiposCliente(){
        return sCliente.getTiposCliente();
    }
    
    //Sistema Unidad Procesadora
    public void agregarUnidadProcesadora(String nombre){
        sUnidad.agregarUnidad(nombre);
    }
    
    public ArrayList<UnidadProcesadora> getUnidades(){
        return sUnidad.getUnidades();
    }
    
    //Sistema Menu
    public void agregarCategoria (String nombre){
        sMenu.agregarCategoria(nombre);
    }
    
    public ArrayList<Categoria> getCategorias(){
        return sMenu.getCategorias();
    }
    
    public void agregarItem(String nombre, double precio, UnidadProcesadora unidad, Categoria cat){
        sMenu.agregarItem(nombre, precio, unidad, cat);
    }
    

    public ArrayList<Item> getItems(){
        return sMenu.getItems();
    }
    
    public void agregarIngrediente(Insumo insumo, int cantidad){
        sMenu.agregarIngrediente(insumo, cantidad);
    }
    
    public void agregarInsumo(String nombre, int stockMin, int stockActual){
        sMenu.agregarInsumo(nombre, stockMin, stockActual);
    }
    
    public ArrayList<Insumo> getInsumos(){
        return sMenu.getInsumo();
    }
    
    
        
    //Sistema pedido
}
