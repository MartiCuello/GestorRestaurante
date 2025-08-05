
package Vistas;

import Logica.Pedido;
import java.util.ArrayList;

public interface IVistaProcesarPedido {


    public void cargarDatosGestor();

    public void cargarPedidos(ArrayList<Pedido> pedidosDe);

    public void cargarPedidosTomados(ArrayList<Pedido> pedidosTomadoDe);

    public void mostrarMensaje(String message);
    
}
