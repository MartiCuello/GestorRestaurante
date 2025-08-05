/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

public class Cliente {
    private String numCliente;
    private String nombreCompleto;
    private String password;
    private TipoCliente tipo;

    public Cliente(String numCliente, String nombreCompleto, String password, TipoCliente tipo) {
        this.numCliente = numCliente;
        this.nombreCompleto = nombreCompleto;
        this.password = password;
        this.tipo = tipo;
    }

    public String getNumCliente() {
        return numCliente;
    }

    public void setNumCliente(String numCliente) {
        this.numCliente = numCliente;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public TipoCliente getTipo() {
        return tipo;
    }

    public void setTipo(TipoCliente tipo) {
        this.tipo = tipo;
    }
    
    public boolean validar(){
        if(numCliente == null || numCliente.isBlank()){
            return false;
        }
        if(password == null || password.isBlank()){
            return false;
        }
        if(nombreCompleto == null || nombreCompleto.isBlank()){
            return false;
        }
        return true;
    }
    
    
}
