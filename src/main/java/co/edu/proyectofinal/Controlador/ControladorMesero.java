package co.edu.proyectofinal.Controlador;

import co.edu.proyectofinal.Modelo.*;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;

public class ControladorMesero {
    @FXML
    private ComboBox<String> tipoProductoComboBox;
    @FXML
    private TextField nombreTextField;
    @FXML
    private TextField precioTextField;
    @FXML
    private ListView<String> ordenListView;
    @FXML
    private ComboBox<String> estadoComboBox;
    @FXML
    private Button Deshacer;

    @FXML
    private Button Rehacer;

    private Mesero mesero;
    private  OrdenCaretaker ordenCaretaker;;

    public void initialize() {
        tipoProductoComboBox.setItems(FXCollections.observableArrayList("Sandwich", "Bebida"));
        estadoComboBox.setItems(FXCollections.observableArrayList("Pendiente", "Preparando", "Listo", "Entregado"));
        mesero = new Mesero("Juan", "Pérez", "jperez", "1234", "123456789", "mesero");
    }

    @FXML
    public void agregarProducto() {
        String tipoProducto = tipoProductoComboBox.getValue();
        String nombre = nombreTextField.getText();
        double precio = Double.parseDouble(precioTextField.getText());

        mesero.hacerOrden(tipoProducto, nombre, precio);
         actualizarListaOrden();
    }

    @FXML
    public void actualizarEstadoOrden() {
        String estado = estadoComboBox.getValue();
        mesero.actualizarEstadoOrden(estado);
    }

    private void actualizarListaOrden() {
        ordenListView.getItems().clear();
        for (Producto producto : mesero.getOrden().getProductos()) {
            ordenListView.getItems().add(producto.getNombre() + " - $" + producto.getPrecio());
        }
    }

    private void mostrarAlerta(String mensaje) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Información");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    @FXML
    public void regresarACajero() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/proyectofinal/Vista/cajero.fxml"));
            VBox root = loader.load();
            ControladorCajero controladorCajero = loader.getController();
            controladorCajero.setOrden(mesero.getOrden());
            Stage stage = (Stage) nombreTextField.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
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

    @FXML
    public void deshacer(){
        mesero.deshacer();
        actualizarListaOrden();
    }

    @FXML
    public  void rehacer(){
       mesero.rehacer();
       actualizarListaOrden();
    }

}
