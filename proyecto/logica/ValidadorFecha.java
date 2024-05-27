package com.example.proyecto.logica;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ValidadorFecha {

    public String dia;
    public String mes;
    public String anio;
    public String anioFormateado;

    public boolean esFormatoFechaValido(String fechaStr) {

        // Verificar si la cadena es nula o está vacía
        if (fechaStr == null || fechaStr.isEmpty()) {
            //ModificarCamposTextoPDFv2.mostrarMensaje("La fecha no tiene el formato correcto\n");
            return false;
        }

        // Define el formato de fecha esperado
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        formatoFecha.setLenient(false); // No permite fechas inválidas

        try {
            // Intenta parsear la cadena como fecha
            @SuppressWarnings("unused")
            Date fecha = formatoFecha.parse(fechaStr);

            extraerDiaMesAnio(fecha);

            // Obtener las dos últimas cifras del año
            this.anioFormateado = String.valueOf(Short.parseShort (this.anio ) % 100);

            // Si el parsing es exitoso, la cadena tiene el formato correcto
            return true;
        } catch (ParseException e) {
            // Si ocurre una excepción, la cadena no tiene el formato correcto
            //ModificarCamposTextoPDFv2.mostrarMensaje("La fecha no tiene el formato correcto\n");
            return false;
        }
    }

    private void extraerDiaMesAnio(Date fecha) {
        // Convertir Date a LocalDate
        java.time.LocalDate localDate = fecha.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();

        // Extraer el día, mes y año
        this.dia = String.valueOf(localDate.getDayOfMonth());
        this.mes = String.valueOf(localDate.getMonthValue());
        this.anio = String.valueOf(localDate.getYear());
    }

    // Métodos getter para acceder a los valores extraídos
    public String getDia() {
        return dia;
    }

    public String getMes() {
        return mes;
    }

    public String getAnio() {
        return anio;
    }
    public String getAnioFormateado() {
        return anioFormateado;
    }
}
