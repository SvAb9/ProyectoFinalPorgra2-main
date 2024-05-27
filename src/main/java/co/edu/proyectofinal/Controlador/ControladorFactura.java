package co.edu.proyectofinal.Controlador;

import co.edu.proyectofinal.Modelo.Factura;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.UUID;

public class ControladorFactura {

    @FXML
    private TextField subTotalTextField;
    @FXML
    private TextField totalTextField;
    @FXML
    private Button generarFacturaButton;

    @FXML
    public void generarFactura() {
        try {
            double subTotal = Double.parseDouble(subTotalTextField.getText());
            double total = Double.parseDouble(totalTextField.getText());
            UUID codigoFactura = UUID.randomUUID();

            Factura factura = new Factura.Builder()
                .subTotal(subTotal)
                .total(total)
                .codigoFactura(codigoFactura)
                .build();

            mostrarAlerta("Factura generada con éxito\nCódigo: " + factura.getCodigoFactura().toString());
            limpiarCampos();
        } catch (NumberFormatException e) {
            mostrarAlerta("Por favor, ingrese valores numéricos válidos para el subtotal y el total.");
        }
    }

    private void mostrarAlerta(String mensaje) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Información");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    private void limpiarCampos() {
        subTotalTextField.clear();
        totalTextField.clear();
    }
}
