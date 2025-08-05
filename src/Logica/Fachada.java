
package Logica;

import Excepciones.RestauranteException;
import Observer.Observable;
import java.util.ArrayList;

public class Fachada extends Observable {
    
    private SistemaAcceso sAcceso = new SistemaAcceso();
    private SistemaPedido sPedido = new SistemaPedido();
    private SistemaCliente sCliente = new SistemaCliente();
    private SistemaUnidadProcesadora sUnidad = new SistemaUnidadProcesadora();
    private SistemaMenu sMenu = new SistemaMenu();
    
    private static Fachada instancia = new Fachada();

    public enum eventos {nuevoLoginCliente, logoutCliente, pedidoTomado, pedidoFinalizado, pedidoEntregado, nuevoPedido};
    
    public static Fachada getInstancia() {
        return instancia;
    }
    
    private Fachada() {} 
    
    
    //SISTEMA ACCESO
    public void agregarDispositivo(){
        sAcceso.agregarDispositivo();
    }
    public ArrayList<Dispositivo> getDispositivos(){
        return sAcceso.getDispositivos();
    }
    
    public void agregarcliente(String num, String nombreCompleto, String password, TipoCliente tipo){
        sAcceso.agregarcliente(num, nombreCompleto, password, tipo);
    }
    
    public SesionCliente loginCliente(String num, String password, Dispositivo d)throws RestauranteException{
        return sAcceso.loginCliente(num, password, d);
    }
    
    public void logoutCliente(SesionCliente s) throws RestauranteException{
        sAcceso.logoutCliente(s);
        avisar(eventos.logoutCliente);
    }
    
    public void agregarGestor(String nomUsuario, String password, String nombreCompleto, UnidadProcesadora unidad){
        sAcceso.agregarGestor(nomUsuario, password, nombreCompleto, unidad);
    }
    
    public SesionGestor loginGestor(String nombre,String password) throws RestauranteException{
        return sAcceso.loginGestor(nombre, password);
    }
    
    public void logoutGestor(SesionGestor s) throws RestauranteException {
       sAcceso.logoutGestor(s);
    }
    

    
    //SISTEMA PEDIDO
    public ArrayList<Servicio> getServicios(){
        return sPedido.getServicios();
    }
    
    public void agregarServicio (Servicio s){
        sPedido.agregarServicio(s);
    }
    
    public void servicioCambioDeStock(Servicio s){
         sPedido.servicioCambioDeStock(s);
    }
    
    //SISTEMA CLIENTE
    public void agregarTipoCliente(TipoCliente tipo){
        sCliente.agregarTipoCliente(tipo);
    }
    
    public ArrayList<TipoCliente> getTiposCliente(){
        return sCliente.getTiposCliente();
    }
    
    //SISTEMA UNIDAD PROCESADORA
    public void agregarUnidadProcesadora(String nombre){
        sUnidad.agregarUnidad(nombre);
    }
    
    public ArrayList<UnidadProcesadora> getUnidades(){
        return sUnidad.getUnidades();
    }
    
    //SISTEMA MENU
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
    
    public void agregarIngrediente(Item i, Insumo insumo, int cantidad){
        sMenu.agregarIngrediente(i, insumo, cantidad);
    }
    
    public void agregarInsumo(String nombre, int stockMin, int stockActual){
        sMenu.agregarInsumo(nombre, stockMin, stockActual);
    }
    
    public ArrayList<Insumo> getInsumos(){
        return sMenu.getInsumo();
    }
   
}
