package com.example.proyecto.logica;

public class ValidadorCIF {

    public boolean validarCIF(String cif) {
        // Eliminar espacios y pasar a mayúsculas
        cif = cif.trim().toUpperCase();

        // Verificar la longitud
        if (cif.length() != 9) {
            return false;
        }

        // Obtener el tipo de entidad (primera letra del CIF)
        char tipoEntidad = cif.charAt(0);

        // Verificar que el tipo de entidad es válido
        if (tipoEntidad < 'A' || tipoEntidad > 'Z') {
            return false;
        }

        // Verificar el formato del CIF
        if (!cif.substring(1, 8).matches("\\d{7}")) {
            return false;
        }

        // Calcular y verificar el dígito de control
        int digitoControl = Character.getNumericValue(cif.charAt(8));
        int suma = 0;

        for (int i = 2; i <= 8; i++) {
            int digito = Character.getNumericValue(cif.charAt(i - 1));

            if (i % 2 == 0) {
                digito *= 2;
                digito = digito < 10 ? digito : digito - 9;
            }

            suma += digito;
        }

        int resto = suma % 10;
        int resultado = resto == 0 ? 0 : 10 - resto;

        return digitoControl == resultado;
    }
}
