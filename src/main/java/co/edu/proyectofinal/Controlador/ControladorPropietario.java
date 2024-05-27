package co.edu.proyectofinal.Controlador;

import java.util.ArrayList;

import co.edu.proyectofinal.Modelo.*;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ControladorPropietario {
    @FXML
    private TextField nombreEmpleadoTextField;
    @FXML
    private TextField apellidoEmpleadoTextField;
    @FXML
    private TextField usuarioEmpleadoTextField;
    @FXML
    private TextField contraseñaEmpleadoTextField;
    @FXML
    private TextField documentoEmpleadoTextField;
    @FXML
    private ListView<String> empleadosListView;

    private Propietario propietario;

    public void initialize() {
        propietario = new Propietario("Carlos", "Gómez", "carlos", "propietario123", "123456789", new ArrayList<>(), "propietario");
        actualizarListaEmpleados();
    }

    @FXML
    public void contratarEmpleado() {
        String nombre = nombreEmpleadoTextField.getText();
        String apellido = apellidoEmpleadoTextField.getText();
        String usuario = usuarioEmpleadoTextField.getText();
        String contraseña = contraseñaEmpleadoTextField.getText();
        String documento = documentoEmpleadoTextField.getText();

        propietario.contratarEmpleado("mesero", nombre, apellido, usuario, contraseña, documento); // Por defecto contrata meseros
        actualizarListaEmpleados();
        mostrarAlerta("Empleado contratado: " + nombre + " " + apellido);
    }

    @FXML
    public void despedirEmpleado() {
        String nombre = nombreEmpleadoTextField.getText();
        String apellido = apellidoEmpleadoTextField.getText();

        Empleado empleadoADespedir = null;
        for (Empleado empleado : propietario.getListaEmpleados()) {
            if (empleado.getNombre().equals(nombre) && empleado.getApellido().equals(apellido)) {
                empleadoADespedir = empleado;
                break;
            }
        }

        if (empleadoADespedir != null) {
            propietario.despedirEmpleado(empleadoADespedir);
            actualizarListaEmpleados();
            mostrarAlerta("Empleado despedido: " + nombre + " " + apellido);
        } else {
            mostrarAlerta("Empleado no encontrado.");
        }
    }

    private void actualizarListaEmpleados() {
        empleadosListView.getItems().clear();
        for (Empleado empleado : propietario.getListaEmpleados()) {
            empleadosListView.getItems().add(empleado.getNombre() + " " + empleado.getApellido());
        }
    }

    private void mostrarAlerta(String mensaje) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Información");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
