package co.edu.proyectofinal.Modelo;

public class Bebida extends Producto {
    
    public Bebida(String nombre) {
        super(nombre, 5000);
    }


    @Override
    public String getTipo() {
        return "Bebida";
    }

    @Override
    public double getCosto() {
        return this.precio;
    }
}
