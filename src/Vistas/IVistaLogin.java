
package Vistas;

import Logica.Dispositivo;
import Logica.SesionGestor;
import java.util.ArrayList;

public interface IVistaLogin {

    public void mostrarMensaje(String message);

    public void cargarDispositivos(ArrayList<Dispositivo> dispositivos);

    public void abrirDispositivo(Dispositivo d);

    public void ingresar(SesionGestor sg);
}
