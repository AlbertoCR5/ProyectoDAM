package com.example.proyecto.logica;

import com.example.proyecto.interfaz.PrincipalView;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class PrincipalController {

    private Login inicioSesion;
    PrincipalView vistaPrincipal = new PrincipalView();

    public PrincipalController() {
        inicioSesion = new Login();
    }

    public boolean iniciarSesion(String usuario, String contrasena) {
        if (inicioSesion.verificarCredenciales(usuario, contrasena)) {
            mostrarVentanaPrincipal();
        } else {
            mostrarAlerta("Credenciales incorrectas");
        }
        return false;
    }

    private void mostrarVentanaPrincipal() {
        Stage ventanaPrincipal = new Stage();
        PrincipalView principalView = new PrincipalView(ventanaPrincipal);
        ventanaPrincipal.setScene(principalView.getScene());
        ventanaPrincipal.show();
    }

}