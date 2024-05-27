package co.edu.proyectofinal.Modelo;

public class RellenoDecorador extends DecoradorSandwich {
    private String relleno;

    public RellenoDecorador(ComponenteSandwich sandwichDecorado, String relleno) {
        super(sandwichDecorado);
        this.relleno = relleno;
    }

    @Override
    public String getDescripcion() {
        return sandwichDecorado.getDescripcion() + ", " + relleno;
    }

    @Override
    public double getCosto() {
        return sandwichDecorado.getCosto() + 3000;
    }
}
