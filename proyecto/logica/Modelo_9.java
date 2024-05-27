package com.example.proyecto.logica;

/**
 * Esta clase representa el Modelo_9 en el cual se certifica que se ha elegido un total de "x" representantes
 * y los sindicatos a los que representan.
 *
 * @author Alberto Castro <AlbertoCastrovas@gmail.com>
 */
public class Modelo_9 extends Preaviso {

    ValidadorDNI validarDNI = new ValidadorDNI();
    ValidadorFecha extraerFecha = new ValidadorFecha();
    String presidente;
    String dniPresidente;
    String dia;
    String mes;
    String anio;
    short totalRepresentantes;
    String sindicato1;
    String representantesElegidos1;
    String sindicato2;
    String representantesElegidos2;
    String sindicato3;
    String representantesElegidos3;

    public Modelo_9() {
    }

    public Modelo_9(String nombreEmpresa, String CIF, String nombreComercial, String nombreCentro, String direccion, String municipio, String provincia) throws CumplimentarPDFException {
        super(nombreEmpresa, CIF, nombreComercial, nombreCentro, direccion, municipio, provincia);
    }

    public Modelo_9(String nombreEmpresa, String CIF, String nombreComercial, String nombreCentro, String direccion, String municipio,
                    String provincia, String presidente, String dniPresidente, String dia, String mes, String anio,
                    short totalRepresentantes, String sindicato1, String representantesElegidos1, String sindicato2,
                    String representantesElegidos2, String sindicato3, String representantesElegidos3) throws CumplimentarPDFException {
        super(nombreEmpresa, CIF, nombreComercial, nombreCentro, direccion, municipio, provincia);
        this.presidente = presidente;
        setDniPresidente(dniPresidente);
        this.dia = dia;
        setMes(mes);
        this.anio = anio;
        setTotalRepresentantes(totalRepresentantes);
        this.sindicato1 = sindicato1;
        this.representantesElegidos1 = representantesElegidos1;
        this.sindicato2 = sindicato2;
        this.representantesElegidos2 = representantesElegidos2;
        this.sindicato3 = sindicato3;
        this.representantesElegidos3 = representantesElegidos3;
    }

    public String getPresidente() {
        return presidente;
    }

    /**
     * Establece el nombre del presidente.
     *
     * @param presidente el nombre del presidente.
     */
    public void setPresidente(String presidente) {
        this.presidente = presidente;
    }

    public String getDniPresidente() throws CumplimentarPDFException {
        return dniPresidente;
    }

    /**
     * Establece el DNI del presidente.
     *
     * @param dniPresidente el DNI del presidente.
     * @throws CumplimentarPDFException si el DNI no es válido.
     */
    public void setDniPresidente(String dniPresidente) throws CumplimentarPDFException {

        if (!validarDNI.esDNIValido(dniPresidente)) {
            throw new CumplimentarPDFException("ERROR, DNI introducido incorrecto");
        }
        this.dniPresidente = dniPresidente;
    }

    public String getDia() {
        return dia;
    }

    /**
     * Establece el día de la constitución de la mesa.
     *
     * @param dia el día de la constitución de la mesa.
     */
    public void setDia(String dia) {
        this.dia = extraerFecha.getDia();
    }

    public String getMes() {
        return mes;
    }

    /**
     * Establece el mes de la constitución de la mesa.
     *
     * @param mes el mes de la constitución de la mesa
     */
    public void setMes(String mes) {

        this.mes = extraerFecha.getMes();
        convertirMesALetras(mes);
        this.mes = mes;
    }

    public String getAnio() {
        return anio;
    }

    /**
     * Establece el año de la constitución de la mesa.
     *
     * @param anio el año de la constitución de la mesa
     */
    public void setAnio(String anio) {
        this.anio = extraerFecha.getAnio();
    }

    public short getTotalRepresentantes() {
        return totalRepresentantes;
    }

    /**
     * Establece el total de representantes.
     *
     * @param totalRepresentantes el total de representantes
     */
    public void setTotalRepresentantes(short totalRepresentantes) {
        this.totalRepresentantes = totalRepresentantes;
    }

    public String getSindicato1() {
        return sindicato1;
    }

    /**
     * Establece el nombre del primer sindicato.
     *
     * @param sindicato1 el nombre del primer sindicato
     */
    public void setSindicato1(String sindicato1) {
        this.sindicato1 = sindicato1;
    }

    public String getRepresentantesElegidos1() {
        return representantesElegidos1;
    }

    /**
     * Establece los representantes elegidos del primer sindicato.
     *
     * @param representantesElegidos1 los representantes elegidos del primer sindicato
     */
    public void setRepresentantesElegidos1(String representantesElegidos1) {
        this.representantesElegidos1 = representantesElegidos1;
    }

    public String getSindicato2() {
        return sindicato2;
    }

    /**
     * Establece el nombre del segundo sindicato.
     *
     * @param sindicato2 el nombre del segundo sindicato
     */
    public void setSindicato2(String sindicato2) {
        this.sindicato2 = sindicato2;
    }

    public String getRepresentantesElegidos2() {
        return representantesElegidos2;
    }


    public void setRepresentantesElegidos2(String representantesElegidos2) {
        this.representantesElegidos2 = representantesElegidos2;
    }

    public String getSindicato3() {
        return sindicato3;
    }

    /**
     * Establece el nombre del tercer sindicato.
     *
     * @param sindicato3 el nombre del tercer sindicato
     */
    public void setSindicato3(String sindicato3) {
        this.sindicato3 = sindicato3;
    }

    public String getRepresentantesElegidos3() {
        return representantesElegidos3;
    }

    /**
     * Establece los representantes elegidos del tercer sindicato.
     *
     * @param representantesElegidos3 los representantes elegidos del tercer sindicato
     */
    public void setRepresentantesElegidos3(String representantesElegidos3) {
        this.representantesElegidos3 = representantesElegidos3;
    }

    public void convertirMesALetras(String mes){

        for (Meses month : Meses.values()) {
            if (month.obtenerNombre().equals(this.mes)){
                this.mes = month.toString();
            }
        }
    }
}
