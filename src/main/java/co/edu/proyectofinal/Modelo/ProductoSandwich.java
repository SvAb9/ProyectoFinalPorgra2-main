package co.edu.proyectofinal.Modelo;

public class ProductoSandwich extends Producto implements ComponenteSandwich {
    private ComponenteSandwich componenteSandwich;

    public ProductoSandwich(String nombre, double precio, ComponenteSandwich componenteSandwich) {
        super(nombre, precio);
        this.componenteSandwich = componenteSandwich;
    }

    @Override
    public String getDescripcion() {
        return componenteSandwich.getDescripcion();
    }

    @Override
    public double getCosto() {
        return componenteSandwich.getCosto();
    }

    @Override
    public String getTipo() {
        return "Sandwich";
    }
}
