package com.example.proyecto.logica;

public class ValidadorHora {

    public boolean validarHora(String hora) {

        // Validamos que la hora tenga el formato correcto
        if (!hora.matches("^([0-9]{2}):([0-9]{2})$")) {
            return false;
        }

        // Validamos que las horas y minutos sean valores válidos
        int horaEntera = Integer.parseInt(hora.substring(0, 2));
        int minutoEntero = Integer.parseInt(hora.substring(3, 5));

        if (horaEntera < 0 || horaEntera > 23) {
            return false;
        }

        if (minutoEntero < 0 || minutoEntero > 59) {
            return false;
        }

        return true;
    }
}

