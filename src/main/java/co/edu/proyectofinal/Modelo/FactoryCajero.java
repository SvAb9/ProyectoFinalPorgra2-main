package co.edu.proyectofinal.Modelo;

public class FactoryCajero implements EmpleadoFactory {
    @Override
    public Empleado crearEmpleado(String nombre, String apellido, String usuario, String contraseña, String documento, String tipo) {
        return new Cajero(nombre, apellido, usuario, contraseña, documento, tipo);
    }
}
