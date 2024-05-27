package co.edu.proyectofinal.Modelo;

import java.util.ArrayList;
import java.util.List;

public class Propietario extends Empleado implements  GetTipo {
    private List<Empleado> listaEmpleados;

    public Propietario(String nombre, String apellido, String usuario, String contraseña, String documento, List<Empleado> listaEmpleados, String tipo) {
        super(nombre, apellido, usuario, contraseña, documento, tipo);
        this.listaEmpleados = listaEmpleados != null ? listaEmpleados : new ArrayList<>();
    }


    public List<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(List<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    public void contratarEmpleado(String tipo, String nombre, String apellido, String usuario, String contraseña, String documento) {
        EmpleadoFactory factory;
        switch (tipo.toLowerCase()) {
            case "cajero":
                factory = new FactoryCajero();
                break;
            case "mesero":
                factory = new FactoryMesero();
                break;
            default:
                throw new IllegalArgumentException("Tipo de empleado no válido: " + tipo);
        }
        Empleado empleado = factory.crearEmpleado(nombre, apellido, usuario, contraseña, documento, tipo);
        if (!listaEmpleados.contains(empleado)) {
            listaEmpleados.add(empleado);
            System.out.println("Empleado contratado: " + empleado.getNombre());
        } else {
            System.out.println("El empleado ya está en la lista.");
        }
    }

    public void despedirEmpleado(Empleado empleado) {
        if (listaEmpleados.contains(empleado)) {
            listaEmpleados.remove(empleado);
            System.out.println("Empleado despedido: " + empleado.getNombre());
        } else {
            System.out.println("El empleado no está en la lista.");
        }
    }

    @Override
    public String getTipo(){
        return "Propietario";
    }
}
