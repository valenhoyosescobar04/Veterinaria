package com.example.demo.Modelo.Conexion;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Conexion {
    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private void loginButtonClicked() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        // Aquí puedes agregar la lógica de autenticación
        // Por ahora, simplemente imprimimos los datos de inicio de sesión
        System.out.println("Usuario: " + username);
        System.out.println("Contraseña: " + password);
    }
}
