package co.edu.proyectofinal.Controlador;

import co.edu.proyectofinal.Modelo.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class ControladorCajero {
    @FXML
    private ListView<String> ordenesListView;
    @FXML
    private ListView<String> facturaListView; // Lista para mostrar la factura

    private Cajero cajero;
    private Orden orden;

    public void initialize() {
        cajero = new Cajero("Ana", "García", "agarcia", "5678", "987654321", "cajero");
        orden = new Orden(); // Inicializamos una orden vacía para evitar null pointer
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
            actualizarListaFactura(factura);
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

    private void actualizarListaFactura(Factura factura) {
        if (factura != null) {
            facturaListView.getItems().clear();
            for (Producto producto : factura.getProductos()) {
                facturaListView.getItems().add(producto.getNombre() + " - $" + producto.getPrecio());
            }
            facturaListView.getItems().add("Total: $" + factura.getTotal());
        }
    }

    @FXML
    public void regresarAMesero() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/proyectofinal/Vista/mesero.fxml"));
            VBox root = loader.load();
            Stage stage = (Stage) ordenesListView.getScene().getWindow();
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
