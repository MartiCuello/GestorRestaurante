
package Vistas;

import Logica.Categoria;
import Logica.Servicio;
import Logica.SesionCliente;
import java.util.ArrayList;

public interface IVistaCliente {

    public void cargarCategoriasMenu(ArrayList<Categoria> categorias);

    public void cargarItems(Categoria c);

    public void mostrarError(String message);

    public void ingresar(SesionCliente s);

    public void cargarServicio(Servicio servicio);

    public void mostrarMensaje(String mensaje);

    public void mostrarResumenPago(String mensaje);

    public void reiniciarVista();

    public void avisoRetiroPedido();

    
}
