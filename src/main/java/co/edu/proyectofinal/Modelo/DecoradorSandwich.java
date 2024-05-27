package co.edu.proyectofinal.Modelo;

public abstract class DecoradorSandwich implements ComponenteSandwich {
    protected ComponenteSandwich sandwichDecorado;

    public DecoradorSandwich(ComponenteSandwich sandwichDecorado) {
        this.sandwichDecorado = sandwichDecorado;
    }

    @Override
    public String getDescripcion() {
        return sandwichDecorado.getDescripcion();
    }

    @Override
    public double getCosto() {
        return sandwichDecorado.getCosto();
    }
}
