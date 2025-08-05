
package Logica;

public class SesionGestor {
     private Gestor gestor;

    public SesionGestor(Gestor gestor) {
        this.gestor = gestor;
    }

    public Gestor getCliente() {
        return gestor;
    }

    public Gestor getGestor() {
       return this.gestor;
    }
    
}
