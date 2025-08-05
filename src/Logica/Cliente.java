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

    public String getNombreCompleto() {
        return nombreCompleto;
    }
    
    public String getPassword(){
        return password;
    }

    public TipoCliente getTipo() {
        return tipo;
    }
}
