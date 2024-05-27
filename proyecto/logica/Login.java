package com.example.proyecto.logica;

public class Login {

    private static final String USUARIO_VALIDO = "admin";
    private static final String CONTRASENA_VALIDA = "123456";

    public boolean verificarCredenciales(String usuario, String contrasena) {
        return usuario.equals(USUARIO_VALIDO) && contrasena.equals(CONTRASENA_VALIDA);
    }
}
