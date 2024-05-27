package co.edu.proyectofinal.Modelo;

public interface EmpleadoFactory {
    Empleado crearEmpleado(String nombre, String apellido, String usuario, String contraseña, String documento, String tipo);
}
