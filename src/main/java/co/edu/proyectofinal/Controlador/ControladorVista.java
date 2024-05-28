package co.edu.proyectofinal.Controlador;

import co.edu.proyectofinal.Modelo.*;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ControladorVista {
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

    private Mesero mesero;
    private Cajero cajero;

    public void initialize() {
        tipoProductoComboBox.setItems(FXCollections.observableArrayList("Sandwich", "Bebida"));
        estadoComboBox.setItems(FXCollections.observableArrayList("Pendiente", "Preparando", "Listo", "Entregado"));

        mesero = new Mesero("Juan", "Pérez", "jperez", "1234", "123456789", "mesero");
        cajero = new Cajero("Ana", "García", "agarcia", "5678", "987654321", "cajero");
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

    @FXML
    public void cobrarOrden() {
        Orden orden = mesero.getOrden();
        if (!orden.getProductos().isEmpty()) {
            Factura factura = cajero.generarFactura(orden);
            cajero.agregarFactura(factura);
            mostrarAlerta("El total de la orden es de: $" + factura.getTotal());
            mesero = new Mesero("Juan", "Pérez", "jperez", "1234", "123456789", "mesero"); // Reiniciar la orden del mesero
            actualizarListaOrden();
        } else {
            mostrarAlerta("No hay órdenes para cobrar.");
        }
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
}
