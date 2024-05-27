package com.example.proyecto.logica;

public enum Dias {

    UNO("01", "uno"),
    DOS("02", "dos"),
    TRES("03", "tres"),
    CUATRO("04", "cuatro"),
    CINCO("05", "cinco"),
    SEIS("06", "seis"),
    SIETE("07", "siete"),
    OCHO("08", "ocho"),
    NUEVE("09", "nueve"),
    DIEZ("10", "diez"),
    ONCE("11", "once"),
    DOCE("12", "doce"),
    TRECE("13", "trece"),
    CATORCE("14", "catorce"),
    QUINCE("15", "quince"),
    DIECISEIS("16", "dieciséis"),
    DIECISIETE("17", "diecisiete"),
    DIECIOCHO("18", "dieciocho"),
    DIECINUEVE("19", "diecinueve"),
    VEINTE("20", "veinte"),
    VEINTIUNO("21", "veintiuno"),
    VEINTIDOS("22", "veintidós"),
    VEINTITRES("23", "veintitrés"),
    VEINTICUATRO("24", "veinticuatro"),
    VEINTICINCO("25", "veinticinco"),
    VEINTICISEIS("26", "veintiseis"),
    VEINTICISIETE("27", "veintisiete"),
    VEINTIOCHO("28", "veintiocho"),
    VEINTINUEVE("29", "veintinueve"),
    TREINTA("30", "treinta"),
    TREINTAYUNO("31", "treinta y uno");

    private final String numero;
    private final String nombre;

    Dias(String numero, String nombre) {
        this.numero = numero;
        this.nombre = nombre;
    }

    public String getNumero() {
        return numero;
    }

    public String getNombre() {
        return nombre;
    }
}
