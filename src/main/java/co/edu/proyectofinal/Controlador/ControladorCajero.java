package co.edu.proyectofinal.Controlador;

import co.edu.proyectofinal.Modelo.*;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ControladorCajero {
    @FXML
    private ListView<String> ordenesListView;

    private Cajero cajero;
    private Mesero mesero;

    public void initialize() {
        cajero = new Cajero("Ana", "García", "agarcia", "5678", "987654321", "cajero");
        mesero = new Mesero("Juan", "Pérez", "jperez", "1234", "123456789", "mesero");
    }

    @FXML
    public void cobrarOrden() {
        Orden orden = mesero.getOrden();
        if (!orden.getProductos().isEmpty()) {
            Factura factura = cajero.generarFactura(orden);
            cajero.agregarFactura(factura);
            mostrarAlerta("Total cobrado: $" + factura.getTotal());
            ordenesListView.getItems().clear();
        } else {
            mostrarAlerta("No hay órdenes para cobrar.");
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
