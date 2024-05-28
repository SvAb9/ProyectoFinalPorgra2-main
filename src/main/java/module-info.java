module co.edu.proyectofinal {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    

    opens co.edu.proyectofinal to javafx.fxml;
    opens co.edu.proyectofinal.Vista to javafx.fxml;
    opens co.edu.proyectofinal.Controlador to javafx.fxml;

    exports co.edu.proyectofinal;
    exports co.edu.proyectofinal.Controlador;
    exports co.edu.proyectofinal.Modelo;
}
