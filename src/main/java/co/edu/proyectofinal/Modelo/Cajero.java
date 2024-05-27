package co.edu.proyectofinal.Modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Cajero extends Empleado implements  GetTipo {
    
    private List<Factura> listaFacturas;

    public Cajero(String nombre, String apellido, String usuario, String contraseña, String documento, String tipo) {
        super(nombre, apellido, usuario, contraseña, documento, tipo);
        this.listaFacturas = new ArrayList<>();
    }

    public Factura generarFactura (Orden orden){

        double subTotal = orden.calcularTotal();
        double total = subTotal;
        
        Factura factura = new Factura.Builder()
        .subTotal(subTotal)
        .total(total)
        .codigoFactura(UUID.randomUUID())
        .build();
    return factura;

    }

    public void agregarFactura(Factura factura) {
        listaFacturas.add(factura);
    }

    public double cobrar() {
        double total = 0.0;
        for (Factura factura : listaFacturas) {
            total += factura.getTotal();
        }
        return total;
    }

    @Override
    public String getTipo(){
        return "Cajero";
    }
}
