package co.edu.proyectofinal.Modelo;

public class QuesoDecorador extends DecoradorSandwich {
    public QuesoDecorador(ComponenteSandwich sandwichDecorado) {
        super(sandwichDecorado);
    }

    @Override
    public String getDescripcion() {
        return sandwichDecorado.getDescripcion() + ", Queso";
    }

    @Override
    public double getCosto() {
        return sandwichDecorado.getCosto() + 1000;
    }
}
