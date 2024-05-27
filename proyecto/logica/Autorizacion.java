package com.example.proyecto.logica;

import org.jetbrains.annotations.NotNull;

/**
 * La clase `Autorizacion`extiende la clase `Preaviso`.
 * Esto significa que `Autorizacion` hereda algunas de las propiedades y métodos de `Preaviso`.
 * Esta clase representa el modelo con el cual el presidente de la mesa nos autoriza a presentar la documentación de manera telemática
 *
 * @author Alberto Castro <AlbertoCastrovas@gmail.com>
 */
public class Autorizacion extends Preaviso {

    // Instancia de `ConversorFechaToLetras` para convertir fechas a letras.
    ConversorFechaToLetras fechaToLetras = new ConversorFechaToLetras();

    // Variables privadas que representan los datos de la autorización.
    private String presidente;
    private String dia;
    private String mes;
    private String anio;

    // Constructor por defecto.
    public Autorizacion() {
    }

    // Constructor que inicializa `nombreEmpresa`, `nombreCentro` y `municipio`.
    public Autorizacion(String nombreEmpresa, String nombreCentro, String municipio) {
        super(nombreEmpresa, nombreCentro, municipio);
    }

    // Constructor que inicializa todos los atributos de la clase.
    public Autorizacion(String nombreEmpresa, String nombreCentro, String municipio, String presidente, String dia, String mes, String anio) {
        super(nombreEmpresa, nombreCentro, municipio);
        this.presidente = presidente;
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }

    // Método getter para obtener el valor de `presidente`.
    public String getPresidente() {
        return presidente;
    }

    // Método setter para establecer el valor de `presidente`.
    public void setPresidente(String presidente) {
        this.presidente = presidente;
    }

    // Método getter para obtener el valor de `dia`.
    public String getDia() {
        return dia;
    }

    // Método setter para establecer el valor de `dia`.
    public void setDia(String dia) {
        this.dia = dia; // Se asigna directamente el valor de `dia`.
    }

    // Método getter para obtener el valor de `mes`.
    public String getMes() {
        return mes;
    }

    /**
     * Establece el valor del mes, convirtiéndolo a su representación en letras.
     *
     * @param mes El mes a establecer. Debe ser un valor numérico del 1 al 12.
     */
    public void setMes(String mes) {
        this.mes = fechaToLetras.convertirMesLetras(mes);
    }

    // Método getter para obtener el valor de `anio`.
    public String getAnio() {
        return anio;
    }

    /**
     * Establece el valor del año, tomando solo los últimos dos dígitos.
     *
     * @param anio El año a establecer. Debe ser una cadena de cuatro dígitos representando un año.
     * @throws NullPointerException si el año proporcionado es nulo.
     * @throws StringIndexOutOfBoundsException si la longitud del año es menor a dos caracteres.
     */
    public void setAnio(@NotNull String anio) {
        this.anio = anio.substring(anio.length() - 2);
    }

    // Método `toString` que sobrescribe el método de la clase `Object` para retornar una representación en cadena de la clase.
    @Override
    public String toString() {
        return "Autorizacion";
    }
}
