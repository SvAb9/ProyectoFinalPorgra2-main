package co.edu.proyectofinal.Modelo;

public class Compra {


    private String nombre;
    private String email;
    private String actualDate;
    private int cantidadProductos;
    private double precio;
    private Factura factura;
    //private tipo de pago

    public Compra(String nombre, String email, String actualDate, int cantidadProductos, double precio) {
        this.nombre = nombre;
        this.email = email;
        this.actualDate = actualDate;
        this.cantidadProductos = cantidadProductos;
        this.precio = precio;
    }

    public String getNombre() { return nombre; }
    public String getEmail() { return email; }
    public String getActualDate() { return actualDate; }
    public int getCantidadProductos() { return cantidadProductos; }
    public double getPrecio() { return precio; }
    public Factura getFactura() { return factura; }
    public void setFactura(Factura factura) { this.factura = factura; } //asigna una factura a la compra

    public String toFileString(){
        return  String.join("," , nombre, email, actualDate, String.valueOf(cantidadProductos) ,String.valueOf(precio), factura.toFileString());
    }


}
