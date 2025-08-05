/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

public class Gestor {
   private String nomUsuario;
   private String password;
   private String nombreCompleto;
   private UnidadProcesadora unidadProcesadora;

    public Gestor(String nomUsuario, String password, String nombreCompleto, UnidadProcesadora unidadProcesadora) {
        this.nomUsuario = nomUsuario;
        this.password = password;
        this.nombreCompleto = nombreCompleto;
        this.unidadProcesadora = unidadProcesadora;
    }

    public String getNomUsuario() {
        return nomUsuario;
    }

    public void setNomUsuario(String nomUsuario) {
        this.nomUsuario = nomUsuario;
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

    public UnidadProcesadora getUnidadProcesadora() {
        return unidadProcesadora;
    }

    public void setUnidadProcesadora(UnidadProcesadora unidadProcesadora) {
        this.unidadProcesadora = unidadProcesadora;
    }
   
   
   
}
