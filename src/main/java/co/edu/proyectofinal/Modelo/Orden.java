package co.edu.proyectofinal.Modelo;

import java.util.ArrayList;
import java.util.List;

public class Orden {
    private List<Producto> productos;
    private String estado;
    private Temporada temporada; 

    public Orden() {
        this.productos = new ArrayList<>();
        this.estado = "Pendiente";
    }

    public void setTemporada(Temporada temporada) {
        this.temporada = temporada;
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public double calcularTotal() {
        double total = productos.stream().mapToDouble(Producto::getPrecio).sum();
        if (temporada == Temporada.NAVIDEÑO) {
            return new CuponNavideno().aplicarDescuento(total);
        } else if (temporada == Temporada.HALLOWEEN) {
            return new CuponHalloween().aplicarDescuento(total);
        } else {
            return total; // No discount for other seasons
        }
    }

        public Temporada getTemporada() {
        return temporada;
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

    public void limpiarOrden() {
        productos.clear();
        estado = "Pendiente";
    }

    public OrdenMemento guardar() {
        return new OrdenMemento(productos, estado);
    }

    public void restaurar(OrdenMemento memento) {
        productos = memento.getProductos();
        estado = memento.getEstado();
    }
}
