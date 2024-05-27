package co.edu.proyectofinal.Modelo;

public class FactoryMesero implements EmpleadoFactory {
    @Override
    public Empleado crearEmpleado(String nombre, String apellido, String usuario, String contraseña, String documento, String tipo) {
        return new Mesero(nombre, apellido, usuario, contraseña, documento, tipo);
    }
}
