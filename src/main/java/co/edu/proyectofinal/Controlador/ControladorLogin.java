package co.edu.proyectofinal.Controlador;
import Persistencia.UsuarioPersistencia;
import co.edu.proyectofinal.Modelo.Persona;
import Servicios.ServicioUsuario;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


public class ControladorLogin {

    @FXML
    private TextField usuarioTextField;
    @FXML
    private PasswordField contraseñaPasswordField;


    private static final String USUARIO_FILE= "./persistence/txt_persistence/usuarios.txt";
    private UsuarioPersistencia usuarioPersistencia;
    private List<Persona> usuarios;

    public void initialize(URL url, ResourceBundle rb) {
        usuarioPersistencia = new UsuarioPersistencia();
        try {
            usuarios = usuarioPersistencia.obtenerUsuarios();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de texto: " + e.getMessage());
            mostrarAlerta("Error al cargar los usuarios");
        }
    }

    public void initializableApp() {
        usuarioPersistencia = new UsuarioPersistencia();
        try {
            usuarios = usuarioPersistencia.obtenerUsuarios();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de texto: " + e.getMessage());
            mostrarAlerta("Error al cargar los usuarios");
        }
    }


    public void iniciarSesion(){
        String usuarioTxt= usuarioTextField.getText();
        String contraseñaTxt= contraseñaPasswordField.getText();
        Persona usuarioEncontrado= null;

        for (Persona u: usuarios){

            System.out.println(usuarioTxt);
            System.out.println(contraseñaTxt);
            if(u.getUsuario().equals(usuarioTxt) && u.getContraseña().equals(contraseñaTxt)){
                usuarioEncontrado= u;
                break;
            }
        }if (usuarioEncontrado != null){
            mostrarMensaje("Has iniciado correctamente");

            String tipoUsuario= usuarioEncontrado.getTipo().toLowerCase();
            switch (tipoUsuario) {
                case "mesero":
                    cargarVista("mesero.fxml");
                    break;
                case "cajero":
                    cargarVista("cajero.fxml");
                    break;
                case "propietario":
                    cargarVista("propietario.fxml");
                    break;

                default:
                    mostrarAlerta("El tipo de usuario no existe");
                    break;
            }
        }else {
            mostrarAlerta("Usuario o contraseña incorrectos");
        }
    }

    @FXML
    public void registrarUsuario() {
        cargarVista("registro.fxml");
    }

    private void cargarVista(String vista) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/proyectofinal/Vista/"+vista));
            Parent root = loader.load(); // Ajuste aquí
            Stage stage = (Stage) usuarioTextField.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void mostrarAlerta(String mensaje) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    private void mostrarMensaje(String mensaje) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Información");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

}
