package com.example.proyecto.interfaz;

import com.example.proyecto.logica.PrincipalController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PrincipalView {

    private PrincipalController controller;

    public PrincipalView(Stage primaryStage, PrincipalController controller) {
        this.controller = controller;
        configurarInterfazUsuario(primaryStage);
    }

    private void configurarInterfazUsuario(Stage primaryStage) {
        primaryStage.setTitle("Inicio de Sesión");
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(10);

        Label usuarioLabel = new Label("Usuario:");
        TextField usuarioTextField = new TextField();
        Label contrasenaLabel = new Label("Contraseña:");
        PasswordField contrasenaField = new PasswordField();
        Button btnIniciarSesion = new Button("Iniciar Sesión");

        vbox.getChildren().addAll(usuarioLabel, usuarioTextField, contrasenaLabel, contrasenaField, btnIniciarSesion);

        btnIniciarSesion.setOnAction(e -> {
            String usuario = usuarioTextField.getText();
            String contrasena = contrasenaField.getText();
            if (controller.iniciarSesion(usuario, contrasena)) {
                mostrarVentanaPrincipal(primaryStage);
            } else {
                mostrarAlerta("Credenciales incorrectas");
            }
        });

        Scene scene = new Scene(vbox, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void mostrarVentanaPrincipal(Stage primaryStage) {
        primaryStage.close();

        Stage menuStage = new Stage();
        menuStage.setTitle("Gestión de Formularios");

        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(10);

        Label label = new Label("Seleccione modelos a cumplimentar:");

        Button btnPreaviso = new Button("Preaviso de Celebración de Elecciones");
        Button btnEscrutinio = new Button("Modelos de escrutinio y Autorización");
        Button btnAnexo73 = new Button("Modelo 7.3 anexo");
        Button btnDelegados = new Button("Anexo Delegados de Prevención");
        Button btnSalidaSindical = new Button("Salida Sindical");
        Button btnCalendario = new Button("Calendario Comité");
        Button btnImprimir = new Button("Imprimir");
        Button btnSalir = new Button("Salir");

        // Establecer el ancho de los botones
        configurarAnchoBotones(btnPreaviso, btnEscrutinio, btnAnexo73, btnDelegados, btnSalidaSindical, btnCalendario, btnImprimir, btnSalir);

        vbox.getChildren().addAll(label, btnPreaviso, btnEscrutinio, btnAnexo73, btnDelegados, btnSalidaSindical, btnCalendario, btnImprimir, btnSalir);

//        btnPreaviso.setOnAction(e -> tratarOpcion(1));
//        btnEscrutinio.setOnAction(e -> tratarOpcion(2));
//        btnAnexo73.setOnAction(e -> tratarOpcion(3));
//        btnDelegados.setOnAction(e -> tratarOpcion(4));
//        btnSalidaSindical.setOnAction(e -> tratarOpcion(5));
//        btnCalendario.setOnAction(e -> tratarOpcion(6));
//        btnImprimir.setOnAction(e -> tratarOpcion(7));
//        btnSalir.setOnAction(e -> primaryStage.close());

        Scene scene = new Scene(vbox, 300, 300);
        menuStage.setScene(scene);
        menuStage.show();
    }

    private void configurarAnchoBotones(Button... botones) {
        double anchoBoton = 250; // Ancho predeterminado
        for (Button boton : botones) {
            boton.setPrefWidth(anchoBoton);
        }
    }

    private void mostrarAlerta(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}

