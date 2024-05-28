package co.edu.proyectofinal.Controlador;

import co.edu.proyectofinal.Modelo.Mesero;
import co.edu.proyectofinal.Modelo.Producto;
import co.edu.proyectofinal.Modelo.Temporada;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ControladorMesero {
    @FXML
    private Button rehacer;
    @FXML
    private Button deshacer;
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
    private ComboBox<Temporada> temporadaComboBox; // ComboBox for selecting the season

    private Mesero mesero;

    public void initialize() {
        tipoProductoComboBox.setItems(FXCollections.observableArrayList("Sandwich", "Bebida"));
        temporadaComboBox.setItems(FXCollections.observableArrayList(Temporada.values())); // Initialize the ComboBox with values from the Temporada enum
        estadoComboBox.setItems(FXCollections.observableArrayList("Pendiente", "Preparando", "Listo", "Entregado"));
        mesero = new Mesero("Juan", "Pérez", "jperez", "1234", "123456789", "mesero");



    }

    @FXML
    public void agregarProducto() {
        String tipoProducto = tipoProductoComboBox.getValue();
        String nombre = nombreTextField.getText();
        double precio = Double.parseDouble(precioTextField.getText());
        Temporada temporada = temporadaComboBox.getValue();

        mesero.hacerOrden(tipoProducto, nombre, precio, temporada);
        actualizarListaOrden();
    }

    @FXML
    public void actualizarEstadoOrden() {
        String estado = estadoComboBox.getValue();
        mesero.actualizarEstadoOrden(estado);
        actualizarListaOrden();
    }

    private void actualizarListaOrden() {
        ordenListView.getItems().clear();
        for (Producto producto : mesero.getOrden().getProductos()) {
            ordenListView.getItems().add(producto.getNombre() + " - $" + producto.getPrecio());
        }
    }

    private void mostrarAlerta(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
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
    private void deshacer() {
        mesero.deshacer();
        actualizarListaOrden();
        mostrarAlerta("Se ha deshecho la última acción.");
    }

    @FXML
    private void rehacer() {
        mesero.rehacer();
        actualizarListaOrden();
        mostrarAlerta("Se ha rehecho la última acción.");
    }
}
