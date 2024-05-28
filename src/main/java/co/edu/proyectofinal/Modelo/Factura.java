package co.edu.proyectofinal.Modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Factura {

    private double subTotal;
    private double total;
    private UUID codigoFactura;
    private List<Producto> productos; // Agregar lista de productos


    private Factura(Builder builder) {
        this.subTotal = builder.subTotal;
        this.total = builder.total;
        this.codigoFactura = builder.codigoFactura;
        this.productos = builder.productos; // Inicializar lista de productos

    }

    public double getSubTotal() {
        return subTotal;
    }

    public double getTotal() {
        return total;
    }

    public UUID getCodigoFactura() {
        return codigoFactura;
    }

    public List<Producto> getProductos() {
        return productos;
    }


    public static class Builder {
        private double subTotal;
        private double total;
        private UUID codigoFactura;
        private List<Producto> productos; // Agregar lista de productos

        public Builder() {
            productos = new ArrayList<>(); // Inicializar lista de productos
        }

        public Builder subTotal(double subTotal) {
            this.subTotal = subTotal;
            return this;
        }

        public Builder total(double total) {
            this.total = total;
            return this;
        }

        public Builder codigoFactura(UUID codigoFactura) {
            this.codigoFactura = codigoFactura;
            return this;
        }

        public Builder productos(List<Producto> productos) {
            this.productos = productos;
            return this;
        }

        public Factura build() {
            return new Factura(this);
        }
    }

    public String toFileString() {
        return String.join(",", String.valueOf(subTotal), String.valueOf(total), codigoFactura.toString());
    }
}
