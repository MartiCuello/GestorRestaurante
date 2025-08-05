package Logica;

import java.util.ArrayList;

class SistemaUnidadProcesadora {
    private ArrayList<UnidadProcesadora> unidades = new ArrayList<UnidadProcesadora>();

    public void agregarUnidad(String nombreUnidad) {
        unidades.add(new UnidadProcesadora(nombreUnidad));
    }
    
    public ArrayList<UnidadProcesadora> getUnidades(){
        return unidades;
    }
}
