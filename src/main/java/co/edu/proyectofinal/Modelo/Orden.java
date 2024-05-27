package co.edu.proyectofinal.Modelo;

import java.util.ArrayList;
import java.util.List;

public class Orden {
    private List<Producto> productos;
    private String estado;

    public Orden() {
        this.productos = new ArrayList<>();
        this.estado = "Pendiente";
    }   

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public double calcularTotal() {
        return productos.stream().mapToDouble(Producto::getCosto).sum();
    }

    public void imprimirOrden() {
        productos.forEach(producto -> System.out.println("Producto: " + producto.getNombre() + " - Precio: " + producto.getPrecio()));
        System.out.println("Total: " + calcularTotal());
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public OrdenMemento guardar() {
        return new OrdenMemento(productos, estado);
    }

    public void restaurar(OrdenMemento memento) {
        productos = memento.getProductos();
        estado = memento.getEstado();
    }
    
}
