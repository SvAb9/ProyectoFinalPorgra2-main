package co.edu.proyectofinal.Modelo;

import java.util.ArrayList;
import java.util.List;

public class Restaurante {
    private List<Empleado> empleados;

    // Instancia única de la clase Restaurante
    private static Restaurante instance;

    // Constructor privado para evitar la creación de instancias desde fuera
    private Restaurante() {
        this.empleados = new ArrayList<>();
    }

    // Método estático para obtener la instancia única de la clase
    public static Restaurante getInstance() {
        if (instance == null) {
            synchronized (Restaurante.class) {
                if (instance == null) {
                    instance = new Restaurante();
                }
            }
        }
        return instance;
    }

    // Método para agregar empleados
    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    // Método para verificar credenciales
    public Empleado verificarCredenciales(String usuario, String contraseña, String tipo) {
        for (Empleado empleado : empleados) {
            if (empleado.getUsuario().equals(usuario) && empleado.getContraseña().equals(contraseña)) {
                if (tipo.equalsIgnoreCase("empleado") && !(empleado instanceof Propietario)) {
                    return empleado;
                } else if (tipo.equalsIgnoreCase("propietario") && empleado instanceof Propietario) {
                    return empleado;
                }
            }
        }
        return null;
    }

    // Método para listar empleados
    public void listarEmpleados() {
        empleados.forEach(empleado -> System.out.println("Empleado: " + empleado.getNombre() + " " + empleado.getApellido() + " - Tipo: " + empleado.getTipo()));
    }
}
