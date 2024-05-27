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
    private Orden orden;

    public void initialize() {
        cajero = new Cajero("Ana", "García", "agarcia", "5678", "987654321", "cajero");
        actualizarListaOrdenes();
    }

    public void setOrden(Orden orden) {
        this.orden = orden;
        actualizarListaOrdenes();
    }

    @FXML
    public void cobrarOrden() {
        if (orden != null && !orden.getProductos().isEmpty()) {
            Factura factura = cajero.generarFactura(orden);
            cajero.agregarFactura(factura);
            mostrarAlerta("Total cobrado: $" + factura.getTotal());
            orden.limpiarOrden(); // Limpiar la orden después de cobrar
            actualizarListaOrdenes();
        } else {
            mostrarAlerta("No hay órdenes para cobrar.");
        }
    }

    private void actualizarListaOrdenes() {
        if (orden != null) {
            ordenesListView.getItems().clear();
            for (Producto producto : orden.getProductos()) {
                ordenesListView.getItems().add(producto.getNombre() + " - $" + producto.getPrecio());
            }
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
