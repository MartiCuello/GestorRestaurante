
package Inicio;
import IU.Login;


public class Inicio {
    
    public static void main(String[] args) {
        DatosPrueba.cargar();
        new Login().setVisible(true);
    }
    
}
