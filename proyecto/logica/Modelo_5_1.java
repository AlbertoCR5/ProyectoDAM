package com.example.proyecto.logica;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * La clase `Modelo_5_1`extiende la clase `Modelo_3`.
 * Esto significa que `Modelo_5_1` hereda algunas de las propiedades y métodos de `Modelo_3`.
 * Esta clase representa el Modelo_5_1 en el que se indica fecha de constitucion y de escrutinio,
 * datos de los Candidatos, y reclamaciones si las hubiere
 *
 * @author Alberto Castro <AlbertoCastrovas@gmail.com>
 */
public class Modelo_5_1 extends Modelo_3{

    //Atributos
    private short diaVotacion, anioVotacion;
    private String mesVotacion,  mesVotacionLetras;
    private String fechaEscrutinio;
    private String fechaEscrutinioLetras;
    private String fechaConstitucionLetras;

    // Datos de los candidatos
    private ArrayList<Candidato> candidatos;

    // Datos de las reclamaciones
    private String reclamaciones1;
    private String reclamaciones2;
    private String reclamaciones3;
    private String resolucionMesa;

    //Constructor por defecto
    public Modelo_5_1() {
    }

    // Constructor con parametros
    public Modelo_5_1(String nombreEmpresa, String CIF, String nombreComercial, String nombreCentro, String direccion,
                      String municipio, String provincia, String promotores, String fechaConstitucion, String municipioElecciones,
                      String dia, String mes, String anioFormateado, String fechaEscrutinio, String fechaEscrutinioLetras, String fechaConstitucionLetras) throws CumplimentarPDFException {
        super(nombreEmpresa, CIF, nombreComercial, nombreCentro, direccion, municipio, provincia, promotores,
                fechaConstitucion, municipioElecciones, dia, mes, anioFormateado);
        setFechaEscrutinio(fechaEscrutinio);
        setFechaEscrutinioLetras(fechaEscrutinioLetras);
        setFechaConstitucionLetras(fechaConstitucionLetras);
    }

    // Constructor con parametros adicionales
    public Modelo_5_1(String nombreEmpresa, String CIF, String nombreComercial, String nombreCentro, String direccion,
                      String municipio, String provincia, String promotores, String fechaConstitucion, String municipioElecciones,
                      String dia, String mes, String anioFormateado, String fechaEscrutinio, String fechaEscrutinioLetras,
                      short diaVotacion, String mesVotacion, short anioVotacion, String mesVotacionLetras, String fechaConstitucionLetras, ArrayList<Candidato> candidatos,
                      String reclamaciones1, String reclamaciones2, String reclamaciones3, String resolucionMesa) throws CumplimentarPDFException {
        super(nombreEmpresa, CIF, nombreComercial, nombreCentro, direccion, municipio, provincia, promotores,
                fechaConstitucion, municipioElecciones, dia, mes, anioFormateado);
        setFechaConstitucionLetras(fechaConstitucionLetras);
        setFechaEscrutinio(fechaEscrutinio);
        setFechaEscrutinioLetras(fechaEscrutinioLetras);
        setDiaVotacion(diaVotacion);
        setMesVotacion(mesVotacion);
        setAnioVotacion(anioVotacion);
        setMesVotacionLetras(mesVotacionLetras);
        this.candidatos = new ArrayList<>();
        this.reclamaciones1 = reclamaciones1;
        this.reclamaciones2 = reclamaciones2;
        this.reclamaciones3 = reclamaciones3;
        this.resolucionMesa = resolucionMesa;
    }

    public String getFechaEscrutinio() {
        return fechaEscrutinio;
    }

    /**
     * Establece la fecha de escrutinio.
     *
     * @param fechaEscrutinio La fecha de escrutinio a establecer.
     * @throws CumplimentarPDFException Si el formato de la fecha es incorrecto.
     */
    public void setFechaEscrutinio(String fechaEscrutinio) throws CumplimentarPDFException {

        // Se realiza la validación del formato de fecha
        if (!validarFecha.esFormatoFechaValido(fechaEscrutinio)){
            throw new CumplimentarPDFException("El formato de la fecha de constitución es incorrecto. -->".concat(Constantes.FORMATO_FECHA.concat("\n")));
        }
        // Se establece la fecha de escrutinio
        this.fechaEscrutinio = fechaEscrutinio;
        // Se llama al método para establecer la fecha en letras
        setFechaEscrutinioLetras(fechaEscrutinio);
    }

    public String getFechaEscrutinioLetras() {
        return fechaEscrutinioLetras;
    }

    public short getDiaVotacion() {
        return diaVotacion;
    }

    public String getMesVotacion() {
        return mesVotacion;
    }

    public String getMesVotacionLetras() {
        return mesVotacionLetras;
    }

    public short getAnioVotacion() {
        return anioVotacion;
    }

    /**
     * Establece el día de votación.
     *
     * @param diaVotacion El día de votación a establecer.
     * @throws CumplimentarPDFException Si el día es incorrecto.
     */
    public void setDiaVotacion(short diaVotacion) throws CumplimentarPDFException {
        // Se realiza la validación del día de votación
        if (diaVotacion < Constantes.PRIMER_DIA_MES || diaVotacion > Constantes.ULTIMO_DIA_MES) {
            throw new CumplimentarPDFException("ERROR, dia incorrecto.\n");
        }
        this.diaVotacion = diaVotacion;
    }

    /**
     * Establece el mes de votación.
     *
     * @param mesVotacion El mes de votación a establecer.
     * @throws CumplimentarPDFException Si el mes es incorrecto.
     */
    public void setMesVotacion(String mesVotacion) throws CumplimentarPDFException {
        // Se realiza la validación del mes de votación
        if (!mesVotacion.matches("[0-9]+")) {
            throw new CumplimentarPDFException("ERROR, introduce el mes en dígitos\n");
        } else {
            // Se elimina los ceros iniciales
            mesVotacion = mesVotacion.replaceFirst("^0+(?!$)", "");
            int mes = Integer.parseInt(mesVotacion);
            if (mes < Constantes.PRIMER_MES || mes > Constantes.ULTIMO_MES) {
                throw new CumplimentarPDFException("ERROR, mes introducido incorrecto\n");
            }
        }
        // Se establece el mes de votación
        this.mesVotacion = mesVotacion;
        // Se llama al método para establecer el mes de votación en letras
        setMesVotacionLetras(mesVotacion);
    }

    /**
     * Establece el año de votación.
     *
     * @param anioVotacion El año de votación a establecer.
     * @throws CumplimentarPDFException Si el año es incorrecto.
     */
    public void setAnioVotacion(short anioVotacion) throws CumplimentarPDFException {
        // Se realiza la validación del año de votación
        if (anioVotacion < Calendar.getInstance().get(Calendar.YEAR) || anioVotacion > Calendar.getInstance().get(Calendar.YEAR) + 1){
            throw new CumplimentarPDFException("ERROR, Año introducido incorrecto\n");
        }
        this.anioVotacion = anioVotacion;
    }

    /**
     * Establece la fecha de escrutinio en letras.
     *
     * @param fechaescrutinios La fecha de escrutinio a establecer en letras.
     */
    public void setFechaEscrutinioLetras(String fechaescrutinios) {
        // Se separa la fecha en partes
        String[] partes = fechaescrutinios.split("/");

        // Se convierte el día y el mes a letras
        String dia = convertirFechas.convertirDiaLetras(partes[0]) + " de ";
        String mes = convertirFechas.convertirMesLetras(partes[1]);

        // Se elimina los ceros iniciales en el mes para evitar errores
        if (mes.startsWith("0")){
            mes = mes.replace("0", "");
        }

        // Se llama al método para establecer el mes de votación en letras
        setMesVotacionLetras(mes);

        // Se establece la fecha de escrutinio en letras
        fechaescrutinios = dia + mes + convertirFechas.convertirAnioLetras(partes[2]);

        // Se establece la fecha de escrutinio en letras en el atributo correspondiente
        this.fechaEscrutinioLetras = fechaescrutinios.concat("  (".concat(fechaescrutinios).concat(")")).toUpperCase();
    }

    public String getFechaConstitucionLetras() {
        return fechaConstitucionLetras;
    }

    /**
     * Establece la fecha de constitución en letras.
     *
     * @param fechaConstitucion La fecha de constitución en formato de texto.
     */
    @Override
    public void setFechaConstitucionLetras(@NotNull String fechaConstitucion) {
        String fechaConFormato = fechaConstitucion;
        String[] partes = fechaConstitucion.split("/");

        // Convertir el día y el mes a cadenas de texto
        String dia = String.valueOf(partes[0]);
        String mes = partes[1];

        // Agregar un guion "-" entre el día y el mes
        dia = convertirFechas.convertirDiaLetras(dia) + " de ";

        // Elimina los 0 para evitar errores
        if (mes.startsWith("0")){
            mes = mes.replace("0", "");
        }
        setMesVotacionLetras(mes);
        // Agregar un espacio entre el mes y el año
        mes = convertirFechas.convertirMesLetras(mes);


        // Agregar el año a la cadena de texto
        fechaConstitucion = dia + mes + convertirFechas.convertirAnioLetras(partes[2]);

        // Establecer la fecha en el atributo
        this.fechaConstitucionLetras = fechaConstitucion.concat("  (".concat(fechaConFormato).concat(")")).toUpperCase();
    }

    /**
     * Establece el mes de votación en letras.
     *
     * @param mesVotacionLetras El mes de votación en formato de texto.
     */
    public void setMesVotacionLetras(String mesVotacionLetras) {
        this.mesVotacionLetras = convertirFechas.convertirMesLetras(mesVotacionLetras);
    }

    public ArrayList<Candidato> getCandidatos() {
        return candidatos;
    }

    /**
     * Establece la lista de candidatos.
     *
     * @param candidatos La lista de candidatos a establecer.
     */
    public void setCandidatos(ArrayList<Candidato> candidatos) {
        this.candidatos = candidatos;
    }

    public String getReclamaciones1() {
        return reclamaciones1;
    }

    public void setReclamaciones(String reclamaciones) {
        this.reclamaciones1 = reclamaciones1;
    }

    public String getReclamaciones2() {
        return reclamaciones2;
    }

    public void setReclamaciones2(String reclamaciones2) {
        this.reclamaciones2 = reclamaciones2;
    }

    public String getReclamaciones3() {
        return reclamaciones3;
    }

    public void setReclamaciones3(String reclamaciones3) {
        this.reclamaciones3 = reclamaciones3;
    }

    public String getResolucionMesa() {
        return resolucionMesa;
    }

    public void setResolucionMesa(String resolucionMesa) {
        this.resolucionMesa = resolucionMesa;
    }

    /**
     * Agrega un nuevo candidato a la lista de candidatos.
     *
     * @param nuevoCandidato El nuevo candidato a agregar.
     * @throws CumplimentarPDFException Si ocurre un error al agregar el candidato.
     */
    public void agregarCandidato (Candidato nuevoCandidato)  throws CumplimentarPDFException{
        // Se intenta agregar el nuevo candidato a la lista
        boolean esAnadido = candidatos.add(nuevoCandidato);

        // Se lanza una excepción si no se puede agregar el candidato
        if (!esAnadido) {
            throw new CumplimentarPDFException("Error, no se puede añadir al candidato " + nuevoCandidato);
        }
    }
}