package co.edu.proyectofinal.Modelo;

public class CuponNavideno implements CuponStrategy{

    @Override
    public double aplicarDescuento(double total) {
        // Descuento de 15% al hacer su primera compra
        return total*0.85;
    }

}
