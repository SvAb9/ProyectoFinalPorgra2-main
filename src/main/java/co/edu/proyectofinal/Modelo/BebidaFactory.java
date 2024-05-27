package co.edu.proyectofinal.Modelo;

public class BebidaFactory implements ProductoFactory {
    @Override
    public Producto crearProducto(String nombre, double precio) {
        return new Bebida(nombre);
    }
}
