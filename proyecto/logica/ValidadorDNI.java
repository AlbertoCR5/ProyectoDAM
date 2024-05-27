package com.example.proyecto.logica;

public class ValidadorDNI {

    // Método para comprobar si un DNI es válido
    public boolean esDNIValido(String dni) {
        // Verificar la longitud del DNI
        if (dni == null || dni.length() != 9) {
            return false;
        }

        // Extraer número y letra del DNI
        String numeroStr = dni.substring(0, 8);
        String letra = dni.substring(8).toUpperCase();

        // Verificar que el número sea un entero válido
        int numero;
        try {
            numero = Integer.parseInt(numeroStr);
        } catch (NumberFormatException e) {
            return false;
        }

        // Calcular la letra esperada
        char letraCalculada = calcularLetraDNI(numero);

        // Comparar la letra calculada con la letra proporcionada
        return letraCalculada == letra.charAt(0);
    }

    // Método para calcular la letra del DNI
    private static char calcularLetraDNI(int numeroDNI) {
        String caracteres = "TRWAGMYFPDXBNJZSQVHLCKE";
        int indice = numeroDNI % 23;
        return caracteres.charAt(indice);
    }
}
