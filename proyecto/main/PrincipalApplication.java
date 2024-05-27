package com.example.proyecto.main;

import com.example.proyecto.interfaz.PrincipalView;
import com.example.proyecto.logica.Login;
import com.example.proyecto.logica.PrincipalController;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import javafx.geometry.Insets;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
//import org.apache.pdfbox.pdmodel.PDDocument;
//import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
//import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
//import org.apache.pdfbox.pdmodel.interactive.form.PDButton;
//import org.apache.pdfbox.pdmodel.interactive.form.PDCheckBox;
//import org.apache.pdfbox.pdmodel.interactive.form.PDField;


/**
 * Clase principal para gestionar el menú de opciones y ejecutar las funcionalidades del programa.
 * Utiliza PDFBox para gestionar formularios PDF y JavaFX para la interfaz gráfica.
 *
 * @version 1.0
 */
public class PrincipalApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        PrincipalController controller = new PrincipalController();
        PrincipalView view = new PrincipalView(primaryStage, controller);
    }



    private void mostrarAlerta(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    private void tratarOpcion(int opcion) {
        switch (opcion) {
            case 1 -> mostrarMensaje("Opción Preaviso seleccionada.");
            case 2 -> mostrarMensaje("Opción Modelos de escrutinio y Autorización seleccionada.");
            case 3 -> mostrarMensaje("Opción Modelo 7.3 anexo seleccionada.");
            case 4 -> mostrarMensaje("Opción Anexo Delegados de Prevención seleccionada.");
            case 5 -> mostrarMensaje("Opción Salida Sindical seleccionada.");
            case 6 -> mostrarMensaje("Opción Calendario Comité seleccionada.");
            case 7 -> mostrarMensaje("Opción Imprimir seleccionada.");
            default -> mostrarMensaje("Opción no válida.");
        }
    }

    private void mostrarMensaje(String mensaje) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Información");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    public static class CumplimentarPDFException extends Exception {
        public CumplimentarPDFException(String message) {
            super(message);
        }
    }
    // Métodos para tratar cada opción del menú (se deben implementar)

}
