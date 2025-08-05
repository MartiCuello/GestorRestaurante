
package Logica;

import java.util.ArrayList;

public class SistemaCliente {
    private ArrayList<TipoCliente> tiposCliente = new ArrayList<TipoCliente>();
    
    public void agregarTipoCliente(TipoCliente tipo){
        tiposCliente.add(tipo);
    }
    
    public ArrayList<TipoCliente> getTiposCliente(){
        return tiposCliente;
    }
}
