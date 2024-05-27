package co.edu.proyectofinal.Modelo;

public class SandwichFactory implements ProductoFactory {
    @Override
    public Producto crearProducto(String nombre, double precio) {
        ComponenteSandwich sandwich = new Sandwich("pan", "relleno básico", false); // Sandwich básico sin queso

        // Aplicar decoradores según el tipo de sándwich
        if (nombre.toLowerCase().contains("queso")) {
            sandwich = new QuesoDecorador(sandwich);
        }
        if (nombre.toLowerCase().contains("ropa vieja")) {
            sandwich = new RellenoDecorador(sandwich, "Ropa Vieja");
        }
        if (nombre.toLowerCase().contains("tomate")) {
            sandwich = new RellenoDecorador(sandwich, "Tomate");
        }
        if (nombre.toLowerCase().contains("lechuga")) {
            sandwich = new RellenoDecorador(sandwich, "Lechuga");
        }
        if (nombre.toLowerCase().contains("res")) {
            sandwich = new RellenoDecorador(sandwich, "Res");
        }
        if (nombre.toLowerCase().contains("pollo")) {
            sandwich = new RellenoDecorador(sandwich, "Pollo");
        }
        if (nombre.toLowerCase().contains("cerdo")) {
            sandwich = new RellenoDecorador(sandwich, "Cerdo");
        }
        if (nombre.toLowerCase().contains("atún")) {
            sandwich = new RellenoDecorador(sandwich, "Atún");
        }
        if (nombre.toLowerCase().contains("piña")) {
            sandwich = new RellenoDecorador(sandwich, "Piña");
        }
        if (nombre.toLowerCase().contains("champiñones")) {
            sandwich = new RellenoDecorador(sandwich, "Champiñones");
        }

        // Crear el ProductoSandwich usando el componente decorado
        return new ProductoSandwich(nombre, sandwich.getCosto(), sandwich);
    }
}
