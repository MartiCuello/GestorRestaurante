
package Logica;

import java.util.ArrayList;

public class SistemaPedido {
    private ArrayList<Servicio> servicios = new ArrayList<Servicio>();
    
    public ArrayList<Servicio> getServicios(){
        return servicios;
    }
    
    public void agregarServicio (Servicio s){
        servicios.add(s);
    }
    
    public void servicioCambioDeStock(Servicio s){
        for (Servicio otro : servicios){
            if(otro != s){
                otro.verificarStockPedidos();
            }
        }
    }
}
