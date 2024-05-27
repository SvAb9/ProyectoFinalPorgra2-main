package co.edu.proyectofinal.Modelo;

public class Mesero extends Empleado {
    private Orden orden;
    private OrdenCaretaker caretaker;

    public Mesero(String nombre, String apellido, String usuario, String contraseña, String documento, String tipo) {
        super(nombre, apellido, usuario, contraseña, documento, tipo);
        this.orden = new Orden();
        this.caretaker = new OrdenCaretaker();
    }

    @Override
    public String getTipo() {
        return "Mesero";
    }

    public void hacerOrden(String tipoProducto, String nombre, double precio) {
        ProductoFactory factory;
        switch (tipoProducto.toLowerCase()) {
            case "sandwich":
                factory = new SandwichFactory();
                break;
            case "bebida":
                factory = new BebidaFactory();
                break;
            default:
                throw new IllegalArgumentException("Tipo de producto no válido: " + tipoProducto);
        }
        Producto producto = factory.crearProducto(nombre, precio);
        orden.agregarProducto(producto);
        caretaker.guardarMemento(orden);
        System.out.println("Producto agregado a la orden: " + producto.getNombre());
    }

    public Orden getOrden() {
        return orden;
    }

    public void actualizarEstadoOrden(String estado) {
        orden.setEstado(estado);
        caretaker.guardarMemento(orden);
        System.out.println("Estado de la orden actualizado a: " + estado);
    }

    public void deshacer() {
        caretaker.deshacer(orden);
    }

    public void rehacer() {
        caretaker.rehacer(orden);
    }
}
