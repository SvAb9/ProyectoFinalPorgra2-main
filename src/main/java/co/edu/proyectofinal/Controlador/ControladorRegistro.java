package co.edu.proyectofinal.Controlador;

import Servicios.ServicioUsuario;
import co.edu.proyectofinal.Modelo.*;
import javafx.fxml.FXML;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;

import java.io.IOException;

public class ControladorRegistro {

    @FXML
    private TextField nombreTextField;
    @FXML
    private TextField apellidoTextField;
    @FXML
    private TextField usuarioTextField;
    @FXML
    private PasswordField contraseñaPasswordField;
    @FXML
    private TextField documentoTextField;
    @FXML
    private TextField tipoUsuarioTextField;

    private final ServicioUsuario servicioUsuario = new ServicioUsuario(); //clase para manejar los usuarios

    private void showAlert(String title, String message, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    public void registrar() {
        String nombre = nombreTextField.getText();
        String apellido = apellidoTextField.getText();
        String usuario = usuarioTextField.getText();
        String contraseña = contraseñaPasswordField.getText();
        String documento = documentoTextField.getText();
        String tipoUsuario = tipoUsuarioTextField.getText().toLowerCase();

        Persona  nuevoUsuario= new Persona(nombre, apellido, documento, usuario, contraseña, tipoUsuario);
        try{
            servicioUsuario.añadirUsuario(nuevoUsuario);
        }catch(Exception e){
            e.printStackTrace();
            showAlert("Confirmación", "Error al registrar el usuario", AlertType.ERROR);
        }
        regresarALogin();
    }

    @FXML
    public void regresarALogin() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/proyectofinal/Vista/login.fxml"));
            GridPane root = loader.load(); // Ajuste aquí
            Stage stage = (Stage) nombreTextField.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
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
