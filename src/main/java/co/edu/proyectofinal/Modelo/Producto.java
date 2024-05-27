package co.edu.proyectofinal.Modelo;

public abstract class Producto {
    protected String nombre;
    protected double precio; 
   


    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio= precio;
        
        
    }

    public String getNombre() {
        return nombre;
    }

    public abstract double getCosto();
    
    public abstract String getTipo();

    public double getPrecio() {
        return precio;
    }
}
