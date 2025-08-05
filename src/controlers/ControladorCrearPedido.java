
package controlers;

import Vistas.IVistaCliente;
import Excepciones.RestauranteException;
import Logica.Categoria;
import Logica.Dispositivo;
import Logica.Fachada;
import Logica.Item;
import Logica.Pedido;
import Logica.Servicio;
import Logica.SesionCliente;
import Observer.Observable;
import Observer.Observador;

public class ControladorCrearPedido implements Observador{
    
    public IVistaCliente vista;
    public Dispositivo disp;
    public SesionCliente sesionActual;
    
    private Categoria categoriaSeleccionada;

    public ControladorCrearPedido(IVistaCliente vista, Dispositivo d) {
        this.vista = vista;
        this.disp = d;
        Fachada.getInstancia().agregarObservador(this);
        inicializarVista();
    }

    private void inicializarVista() {
        vista.cargarCategoriasMenu(Fachada.getInstancia().getCategorias());
    }
    
    public void seleccionarCategoria(int indiceCat){
        categoriaSeleccionada = Fachada.getInstancia().getCategorias().get(indiceCat);
        vista.cargarItems(categoriaSeleccionada);
    }
    
    public void login(String numCliente, String pass){
        try{
            SesionCliente s = Fachada.getInstancia().loginCliente(numCliente, pass, disp);
            //guarda la sesion actual en el controlador
            sesionActual = s;
            //observa al servicio
            disp.getServicio().agregarObservador(this);
            
            vista.ingresar(s);
            vista.mostrarMensaje("Bienvenido/a " + s.getCliente().getNombreCompleto() + " " + " (" + s.getCliente().getTipo().getNombre()+")");
        }
        catch(RestauranteException e){
            vista.mostrarError(e.getMessage());
        } 
    }
    
    public void agregarPedido(Servicio s, int i, int cat, String comentario){
        Categoria c = Fachada.getInstancia().getCategorias().get(cat);
        Item item = c.getItems().get(i);
        try{
            disp.validarLogueo();
            disp.getServicio().agregarPedido(item, comentario, disp.getCliente());
        }
        catch (RestauranteException e){
            vista.mostrarError(e.getMessage());
        }
    }
    
    public void confirmarPedidos(){
        try{
            disp.validarLogueo();
            disp.getServicio().confirmarPedidos();
            Fachada.getInstancia().servicioCambioDeStock(disp.getServicio());
        }
        catch(RestauranteException e){
            vista.mostrarError(e.getMessage());
        }
    }
    
    public void eliminarPedido(int i){
        Pedido p = disp.getServicio().getPedidos().get(i);
        try{
           disp.validarLogueo();
           disp.getServicio().eliminarPedido(p); 
        }
        catch(RestauranteException e){
            vista.mostrarError(e.getMessage());
        }
    }
    
    public void finalizarServicio(){
        try{
            disp.validarLogueo();
            String mensaje = disp.getServicio().procesarPago();
            Fachada.getInstancia().logoutCliente(sesionActual);  
            vista.mostrarResumenPago(mensaje);
        }
        catch(RestauranteException e){
            vista.mostrarError(e.getMessage());
        }
    }
    
    private void verificarPedidoFinalizado() {
        for (Pedido p : disp.getServicio().getPedidos()) {
            if (p.estaFinalizado()) {
                vista.avisoRetiroPedido();
                break;
            }
        }
    }
    
    @Override
    public void actualizar(Object evento, Observable origen) {
        if (evento == Servicio.eventos.nuevoPedido || evento == Servicio.eventos.confirmarPedidos || evento == Servicio.eventos.eliminarPedido){
            vista.cargarServicio(disp.getServicio());
        }
        if (evento == Fachada.eventos.pedidoTomado || evento == Fachada.eventos.pedidoFinalizado || evento == Fachada.eventos.pedidoEntregado){
            vista.cargarServicio(disp.getServicio());
        }

        if (evento == Servicio.eventos.finalizarServicio){
            vista.reiniciarVista();
            vista.cargarCategoriasMenu(Fachada.getInstancia().getCategorias());
            if (categoriaSeleccionada != null) {
                vista.cargarItems(categoriaSeleccionada);
            }  
        }
        if (evento == Fachada.eventos.pedidoFinalizado){
            verificarPedidoFinalizado();
        }
        if (evento == Servicio.eventos.pedidoEliminadoPorStock) {
            vista.mostrarMensaje("Lo sentimos, nos quedamos sin stock y eliminamos un pedido de su servicio");
            vista.cargarServicio(disp.getServicio());
            vista.cargarCategoriasMenu(Fachada.getInstancia().getCategorias());
            if (categoriaSeleccionada != null) {
                vista.cargarItems(categoriaSeleccionada);
            }  
        }
    }
}