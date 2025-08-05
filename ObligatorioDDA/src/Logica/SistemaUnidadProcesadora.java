/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import java.util.ArrayList;

/**
 *
 * @author marti
 */
class SistemaUnidadProcesadora {
    private ArrayList<UnidadProcesadora> unidades = new ArrayList<UnidadProcesadora>();

    public void agregarUnidad(String nombreUnidad) {
        unidades.add(new UnidadProcesadora(nombreUnidad));
    }
    
    public ArrayList<UnidadProcesadora> getUnidades(){
        return unidades;
    }
}
