package co.edu.proyectofinal.Modelo;

import java.util.ArrayList;
import java.util.List;

public class OrdenMemento {

    private final List<Producto> productos;
    private final String estado;

    public OrdenMemento(List<Producto> productos, String estado) {
        this.productos = new ArrayList<>(productos);
        this.estado = estado;
    }

    public List<Producto> getProductos() {
        return new ArrayList<>(productos);
    }

    public String getEstado() {
        return estado;
    }
}
