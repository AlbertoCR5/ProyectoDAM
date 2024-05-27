package com.example.proyecto.logica;

public class ConversorFechaToLetras {

    public String diaLetras;
    public String mesLetras;
    public String anioLetras;

    public String getDiaLetras() {
        return diaLetras;
    }

    public String getMesLetras() {
        return mesLetras;
    }

    public String getAnioLetras() {
        return anioLetras;
    }
    public String convertirDiaLetras(String dia){

        for (Dias day: Dias.values()) {
            if (day.getNumero().equalsIgnoreCase(dia)){
                this.diaLetras = day.getNombre();
            }
        }

        return diaLetras;
    }
    public String convertirMesLetras(String mesLetras){

        for (Meses month: Meses.values()) {
            if (month.obtenerNombre().equalsIgnoreCase(mesLetras)){
                mesLetras = month.toString();
            }
        }
        return mesLetras;
    }
    public String convertirAnioLetras(String anio){

        StringBuilder sbAnioLetra = new StringBuilder();
        for (Dias day: Dias.values()) {
            if (day.getNumero().equalsIgnoreCase(anio.substring(anio.length()-2))){
                sbAnioLetra.append(" de dos mil ").append(day.getNombre());
                this.anioLetras = sbAnioLetra.toString().toUpperCase();
            }
        }
        return anioLetras;
    }

}
