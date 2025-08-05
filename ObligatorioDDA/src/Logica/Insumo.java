/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

/**
 *
 * @author marti
 */
public class Insumo {
    private String nombre;
    private int sotckMinimo;
    private int stockActual;

    public Insumo(String nombre, int sotckMinimo, int stockActual) {
        this.nombre = nombre;
        this.sotckMinimo = sotckMinimo;
        this.stockActual = stockActual;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSotckMinimo() {
        return sotckMinimo;
    }

    public void setSotckMinimo(int sotckMinimo) {
        this.sotckMinimo = sotckMinimo;
    }

    public int getStockActual() {
        return stockActual;
    }

    public void setStockActual(int stockActual) {
        this.stockActual = stockActual;
    }
    
    
}
