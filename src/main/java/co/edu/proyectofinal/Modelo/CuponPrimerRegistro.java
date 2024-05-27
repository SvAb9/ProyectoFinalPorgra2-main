package co.edu.proyectofinal.Modelo;

public class CuponPrimerRegistro implements CuponStrategy{

    @Override
    public double aplicarDescuento(double total) {
        return total*0.80; //Aplicar un 20% de descuento al registrarse por primera vez
    }

}
