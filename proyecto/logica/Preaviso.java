package com.example.proyecto.logica;

import org.jetbrains.annotations.NotNull;

import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Esta clase representa al modelo 1 o Preaviso para Registro de Elecciones en una Empresa.
 *
 * @author Alberto Castro <AlbertoCastrovas@gmail.com>
 */
public class Preaviso {

    ConversorFechaToLetras convertirFechas = new ConversorFechaToLetras();
    ValidadorFecha validarFecha = new ValidadorFecha();
    ValidadorCIF validarCIF = new ValidadorCIF();

    // Variables
    private String nombreEmpresa;
    private String CIF;
    private String nombreComercial;
    private String nombreCentro;
    private String direccion;
    private String municipio;
    private String codigoPostal;
    private String comarca;
    private String provincia;
    private short totalTrabajadores;
    private String numeroISS;
    private String mesElecciones;
    private short anioElecciones;
    private boolean total;
    private boolean parcial;
    private String promotores;
    private String fechaConstitucion;
    private short electores;
    private short diaPreaviso;
    private String mesPreaviso;
    private short anioPreaviso;
    private String fechaConstitucionLetras;
    private String mesConstitucionLetras;

    //Constructor Vacío
    public Preaviso() {
    }

    // Constructor Modelo 6.2
    public Preaviso(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    // Constructor Calendario
    public Preaviso(String nombreEmpresa, String fechaConstitucion) throws CumplimentarPDFException {
        this.nombreEmpresa = nombreEmpresa;
        setFechaConstitucion(fechaConstitucion);
    }

    // Constructor Modelo 3, Modelo 5.1,
    public Preaviso(String nombreEmpresa, String CIF, String nombreComercial, String nombreCentro, String direccion, String municipio, String provincia, String promotores, String fechaConstitucion) throws CumplimentarPDFException {
        this.nombreEmpresa = nombreEmpresa;
        setCIF(CIF);
        setNombreComercial(nombreComercial);
        setNombreCentro(nombreCentro);
        this.direccion = direccion;
        this.municipio = municipio;
        this.provincia = provincia;
        this.promotores = promotores;
        setFechaConstitucion(fechaConstitucion);
    }

    // Constructor Modelo 7.3 Anexo, Autorización
    public Preaviso(String nombreEmpresa, String nombreCentro, String municipio) {
        this.nombreEmpresa = nombreEmpresa;
        setNombreCentro(nombreCentro);
        this.municipio = municipio;
    }

    // Constructor Modelo 5.2 Conclusión
    public Preaviso(String nombreEmpresa, String CIF, String nombreComercial, String nombreCentro, String direccion, String municipio, String codigoPostal, String comarca, String provincia, String numeroISS) throws CumplimentarPDFException {
        this.nombreEmpresa = nombreEmpresa;
        setCIF(CIF);
        setNombreComercial(nombreComercial);
        setNombreCentro(nombreCentro);
        this.direccion = direccion;
        this.municipio = municipio;
        setCodigoPostal(codigoPostal);
        this.comarca = comarca;
        this.provincia = provincia;
        setNumeroISS(numeroISS);
    }

    // Constructor Modelo 9
    public Preaviso(String nombreEmpresa, String CIF, String nombreComercial, String nombreCentro, String direccion, String municipio, String provincia) throws CumplimentarPDFException {
        this.nombreEmpresa = nombreEmpresa;
        setCIF(CIF);
        setNombreComercial(nombreComercial);
        setNombreCentro(nombreCentro);
        this.direccion = direccion;
        this.municipio = municipio;
        this.provincia = provincia;
    }

    // Constructor Preaviso Completo
    public Preaviso(String nombreEmpresa, String CIF, String nombreComercial, String nombreCentro, String direccion, String municipio,
                    String codigoPostal, String comarca, String provincia, short totalTrabajadores, String numeroISS, String mesElecciones,
                    short anioElecciones, boolean total, boolean parcial, String promotores, String fechaConstitucion, short diaPreaviso,
                    String mesPreaviso, short anioPreaviso) throws CumplimentarPDFException {
        this.nombreEmpresa = nombreEmpresa;
        setCIF(CIF);
        setNombreComercial(nombreComercial);
        setNombreCentro(nombreCentro);
        this.direccion = direccion;
        this.municipio = municipio;
        setCodigoPostal(codigoPostal);
        this.comarca = comarca;
        this.provincia = provincia;
        this.totalTrabajadores = totalTrabajadores;
        setNumeroISS(numeroISS);
        setMesElecciones(mesElecciones);
        setAnioElecciones(anioElecciones);
        setTotal(total);
        setParcial(parcial);
        this.promotores = promotores;
        setFechaConstitucion(fechaConstitucion);
        this.electores = totalTrabajadores;
        setDiaPreaviso(diaPreaviso);
        setMesPreaviso(mesPreaviso);
        setAnioPreaviso(anioPreaviso);
        setFechaConstitucionLetras(fechaConstitucionLetras);
    }


    //Getters and Setters
    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getCIF() {
        return CIF;
    }

    /**
     * Establece el Código de Identificación Fiscal (CIF) del documento.
     *
     * @param CIF El CIF a establecer.
     * @throws CumplimentarPDFException Se lanza si el CIF no es válido.
     * <p>
     * Este método permite asignar un CIF al documento PDF. Antes de realizar la asignación,
     * se valida el formato del CIF utilizando el método `validarCIF.validarCIF(CIF)`. Si la validación falla,
     * se lanza una excepción `CumplimentarPDFException` con el mensaje "ERROR, CIF introducido incorrecto\n".
     *
     * Si el CIF es válido, se asigna el valor del parámetro `CIF` al atributo privado `this.CIF` del objeto.
     */
    public void setCIF(String CIF) throws CumplimentarPDFException {

        if (!validarCIF.validarCIF(CIF)) {
            throw new CumplimentarPDFException("ERROR, CIF introducido incorrecto\n");
        }
        this.CIF = CIF;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    /**
     * Establece el nombre comercial del documento.
     * @param nombreComercial El nombre comercial a establecer.
     * <p>
     * Este método permite asignar un nombre comercial al documento PDF. Si el valor de `nombreComercial`
     * está vacío, se asigna el valor del atributo `nombreEmpresa` al atributo `nombreComercial`. En caso contrario,
     * se asigna directamente el valor de `nombreComercial` al atributo `nombreComercial`.
     */
    public void setNombreComercial(@NotNull String nombreComercial) {

        if (nombreComercial.isEmpty()) {
            this.nombreComercial = nombreEmpresa;
        } else {
            this.nombreComercial = nombreComercial;
        }
    }

    public String getNombreCentro() {
        return nombreCentro;
    }
    /**
     * Establece el nombre del centro de trabajo del documento.
     * @param nombreCentro El nombre del centro de trabajo a establecer.
     * <p>
     * Este método permite asignar un nombre del centro de trabajo al documento PDF. Si el valor de `nombreCentro`
     * está vacío, se asigna el valor del atributo `nombreCentro` al atributo `nombreComercial`. En caso contrario,
     * se asigna directamente el valor de `nombreComercial` al atributo `nombreComercial`.
     */
    public void setNombreCentro(@NotNull String nombreCentro) {

        if (nombreCentro.isEmpty()) {
            this.nombreCentro = nombreEmpresa;
        } else {
            this.nombreCentro = nombreCentro;
        }
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    /**
     * Establece el código postal del documento.
     *
     * @param codigoPostal El código postal a establecer.
     * @throws CumplimentarPDFException Se lanza si el código postal no tiene la longitud correcta (5).
     * <p>
     * Est método permite asignar un código postal al documento PDF. Antes de realizar la asignación,
     * se valida la longitud del código postal para asegurarse de que cumple con el número requerido de dígitos
     * establecido en la constante `Constantes.DIGITOS_CODIGO_POSTAL`. Si la longitud del código postal no es
     * la correcta, se lanza una excepción `CumplimentarPDFException` con el mensaje "ERROR, Código postal introducido incorrecto\n".
     * <p>
     * Si el código postal tiene la longitud correcta, se asigna el valor del parámetro `codigoPostal`
     * al atributo privado `this.codigoPostal` del objeto.
     */
    public void setCodigoPostal(@NotNull String codigoPostal) throws CumplimentarPDFException {

        if (codigoPostal.length() != Constantes.DIGITOS_CODIGO_POSTAL) {
            throw new CumplimentarPDFException("ERROR, Código postal introducido incorrecto\n");
        }
        this.codigoPostal = codigoPostal;
    }

    public String getComarca() {
        return comarca;
    }

    public void setComarca(String comarca) {
        this.comarca = comarca;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public short getTotalTrabajadores() {
        return totalTrabajadores;
    }

    /**
     * Establece el total de trabajadores de la empresa.
     *
     * @param totalTrabajadores El total de trabajadores a establecer.
     * @throws CumplimentarPDFException Se lanza si el número de trabajadores es menor al mínimo permitido.
     * <p>
     * Este método permite asignar el total de trabajadores de la empresa al documento PDF. Antes de realizar la asignación,
     * se valida que el número de trabajadores sea mayor o igual al mínimo establecido en la constante `Constantes.MINIMO_ELECTORES`.
     * Si el número de trabajadores es menor al mínimo, se lanza una excepción `CumplimentarPDFException` con el mensaje
     * "ERROR, No se puede preavisar una empresa con menos de 6 trabajadores. \n".
     * <p>
     * Si el número de trabajadores es mayor o igual al mínimo, se asigna el valor del parámetro `totalTrabajadores`
     * al atributo privado `this.totalTrabajadores` del objeto.
     */
    public void setTotalTrabajadores(short totalTrabajadores) throws CumplimentarPDFException {

        if (totalTrabajadores > Constantes.MINIMO_ELECTORES) {
            throw new CumplimentarPDFException("ERROR, No se puede preavisar una empresa con menos de 6 trabajadores. \n");
        }
        this.totalTrabajadores = totalTrabajadores;
    }

    public String getNumeroISS() {
        return numeroISS;
    }

    /**
     * Establece el número de la Seguridad Social (ISS) del documento.
     *
     * @param numeroISS El número de ISS a establecer.
     * @throws CumplimentarPDFException Se lanza si el número de ISS no tiene el formato correcto.
     * <p>
     * Este método permite asignar el número de ISS al documento PDF. Si el valor de `numeroISS` no está vacío,
     * se valida su formato utilizando una expresión regular definida en la constante `Constantes.FORMATO_ISS`.
     * La expresión regular asegura que el número de ISS tenga la longitud correcta (11 dígitos) y cumpla con el
     * formato especificado.
     * <p>
     * Si el valor de `numeroISS` está vacío, se ignora.
     * <p>
     * Si el número de ISS tiene el formato correcto, se asigna el valor del parámetro `numeroISS` al atributo
     * privado `this.numeroISS` del objeto.
     * <p>
     * Si el número de ISS no tiene el formato correcto, se lanza una excepción `CumplimentarPDFException` con el
     * mensaje "ERROR, formato del número de ISS no válido. --> 11 DÍGITOS\n".
     */
    public void setNumeroISS(@NotNull String numeroISS) throws CumplimentarPDFException {

        if (!numeroISS.isEmpty()) {
            // Compilar la expresión regular
            Pattern pattern = Pattern.compile(Constantes.FORMATO_ISS);

            // Crear un objeto Matcher para comparar la cadena con el patrón
            Matcher matcher = pattern.matcher(numeroISS);

            if (!matcher.matches()) {
                throw new CumplimentarPDFException("ERROR, formato del número de ISS no válido. --> 11 DÍGITOS\n");
            }
        }
        this.numeroISS = numeroISS;
    }

    public String getMesElecciones() {
        return mesElecciones;
    }

    /**
     * Establece el mes de las elecciones.
     *
     * @param mesElecciones El mes de las elecciones a establecer (en formato numérico).
     * @throws CumplimentarPDFException Se lanza si el mes no está en formato numérico o si no está dentro del rango válido.
     * <p>
     * Este método permite asignar el mes de las elecciones al documento PDF. Primero, se valida que el valor de
     * `mesElecciones` esté compuesto únicamente por dígitos. Si no es así, se lanza una excepción `CumplimentarPDFException`
     * con el mensaje "ERROR, introduce el mes en dígitos\n".
     * <p>
     * Si el valor de `mesElecciones` es válido (solo dígitos), se eliminan los ceros iniciales (si los hay) y se
     * convierte la cadena a un valor entero. Luego, se valida que el valor entero esté dentro del rango permitido
     * (entre `Constantes.PRIMER_MES` y `Constantes.ULTIMO_MES`). Si no está dentro del rango, se lanza una
     * excepción `CumplimentarPDFException` con el mensaje "ERROR, mes introducido incorrecto\n".
     * <p>
     * Si el valor de `mesElecciones` es válido y está dentro del rango permitido, se convierte el número del mes a
     * letras utilizando el método `convertirFechas.convertirMesLetras(mesElecciones)` y se asigna el resultado al
     * atributo privado `this.mesElecciones` del objeto.
     */
    public void setMesElecciones(@NotNull String mesElecciones) throws CumplimentarPDFException {

        if (!mesElecciones.matches("[0-9]+")) {
            throw new CumplimentarPDFException("ERROR, introduce el mes en dígitos\n");
        } else {
            // Eliminar los ceros iniciales
            mesElecciones = mesElecciones.replaceFirst("^0+(?!$)", "");

            int mes = Integer.parseInt(mesElecciones);
            if (mes < Constantes.PRIMER_MES || mes > Constantes.ULTIMO_MES) {
                throw new CumplimentarPDFException("ERROR, mes introducido incorrecto\n");
            }
        }
        this.mesElecciones = convertirFechas.convertirMesLetras(mesElecciones);
    }

    public short getAnioElecciones() {
        return anioElecciones;
    }

    /**
     * Establece el año de las elecciones.
     *
     * @param anioElecciones El año de las elecciones a establecer.
     * @throws CumplimentarPDFException Se lanza si el año no está dentro del rango válido (año actual o año siguiente).
     * <p>
     * Este método permite asignar el año de las elecciones al documento PDF. Se valida que el valor de
     * `anioElecciones` esté dentro del rango válido: el año actual o el siguiente año. Para realizar la validación,
     * se utiliza la clase `Calendar` y su método `get(Calendar.YEAR)` para obtener el año actual.
     * <p>
     * Si el valor de `anioElecciones` es menor al año actual o mayor a un año después del año actual,
     * se lanza una excepción `CumplimentarPDFException` con el mensaje "ERROR, Año introducido incorrecto\n".
     * <p>
     * Si el valor de `anioElecciones` está dentro del rango válido, se asigna directamente al atributo privado
     * `this.anioElecciones` del objeto.
     */
    public void setAnioElecciones(short anioElecciones) throws CumplimentarPDFException {

        if (anioElecciones < Calendar.getInstance().get(Calendar.YEAR) || (anioElecciones) > Calendar.getInstance().get(Calendar.YEAR) + 1){
            throw new CumplimentarPDFException("ERROR, Año introducido incorrecto\n");
        }
        this.anioElecciones = anioElecciones;
    }

    public boolean isTotal() {
        return total;
    }

    public void setTotal(boolean total) {

        if (isParcial()) {
            total = false;
        }
        this.total = total;
    }

    public boolean isParcial() {
        return parcial;
    }

    public void setParcial(boolean parcial) {

        if (isTotal()) {
            parcial = false;
        }
        this.parcial = parcial;
    }

    public String getPromotores() {
        return promotores;
    }

    public void setPromotores(String promotores) {
        this.promotores = promotores;
    }

    public String getFechaConstitucion() {
        return fechaConstitucion;
    }

    /**
     * Establece la fecha de constitución de la empresa.
     *
     * @param fechaConstitucion La fecha de constitución a establecer (en formato dd/MM/yyyy).
     * @throws CumplimentarPDFException Se lanza si el formato de la fecha no es válido.
     * <p>
     * Este método permite asignar la fecha de constitución de la empresa al documento PDF. Primero, se valida el formato de la fecha utilizando el método `validarFecha.esFormatoFechaValido(fechaConstitucion)`. Si el formato de la fecha no es válido, se lanza una excepción `CumplimentarPDFException` con el mensaje "El formato de la fecha de constitución es incorrecto. --> dd/MM/yyyy\n".
     * <p>
     * Si el formato de la fecha es válido, se asigna directamente el valor de `fechaConstitucion` al atributo privado `this.fechaConstitucion` del objeto.
     *
     * Adicionalmente, se llama al método `setFechaConstitucionLetras(fechaConstitucion)` para convertir la fecha en formato numérico a letras y asignarla al atributo `this.fechaConstitucionLetras`.
     */
    public void setFechaConstitucion(String fechaConstitucion) throws CumplimentarPDFException {

        if (!validarFecha.esFormatoFechaValido(fechaConstitucion)){
            throw new CumplimentarPDFException("El formato de la fecha de constitución es incorrecto. -->".concat(Constantes.FORMATO_FECHA.concat("\n")));
        }
        this.fechaConstitucion = fechaConstitucion;
        setFechaConstitucionLetras(fechaConstitucion);
    }

    public short getElectores() {
        return electores;
    }

    public void setElectores(short electores) {
        this.electores = electores;
    }

    public short getDiaPreaviso() {
        return diaPreaviso;
    }

    /**
     * Establece el día de preaviso del documento.
     *
     * @param diaPreaviso El día de preaviso a establecer (entre 1 y 31).
     * @throws CumplimentarPDFException Se lanza si el día de preaviso no está dentro del rango válido (1 al 31).
     * <p>
     * Este método permite asignar el día de preaviso al documento PDF. Se valida que el valor de `diaPreaviso` esté dentro del rango permitido:
     * entre 1 y el último día del mes (definido en la constante `Constantes.ULTIMO_DIA_MES`). Si el valor de `diaPreaviso` no está dentro del rango válido,
     * se lanza una excepción `CumplimentarPDFException` con el mensaje "ERROR, dia incorrecto.\n".
     *
     * Si el valor de `diaPreaviso` es válido, se asigna directamente al atributo privado `this.diaPreaviso` del objeto.
     */
    public void setDiaPreaviso(short diaPreaviso) throws CumplimentarPDFException {

        if (diaPreaviso < Constantes.PRIMER_DIA_MES || diaPreaviso > Constantes.ULTIMO_DIA_MES) {
            throw new CumplimentarPDFException("ERROR, dia incorrecto.\n");
        }
        this.diaPreaviso = diaPreaviso;
    }

    public String getMesPreaviso() {
        return mesPreaviso;
    }

    /**
     * Establece el mes de preaviso del documento.
     *
     * @param mesPreaviso El mes de preaviso a establecer (en formato numérico).
     * @throws CumplimentarPDFException Se lanza si el mes no está en formato numérico o si no está dentro del rango válido (1 a 12).
     * <p>
     * Este método permite asignar el mes de preaviso al documento PDF. Primero, se valida que el valor de `mesPreaviso`
     * esté compuesto únicamente por dígitos. Si no es así, se lanza una excepción `CumplimentarPDFException` con el mensaje "ERROR,
     * introduce el mes en dígitos\n".
     * <p>
     * Si el valor de `mesPreaviso` es válido (solo dígitos), se eliminan los ceros iniciales (si los hay) y se convierte la cadena a un valor entero.
     * Luego, se valida que el valor entero esté dentro del rango permitido (entre `Constantes.PRIMER_MES` y `Constantes.ULTIMO_MES`, normalmente 1 y 12).
     * Si el valor del mes no está dentro del rango válido, se lanza una excepción `CumplimentarPDFException` con el mensaje "ERROR, mes introducido incorrecto\n".
     *
     * Si el valor de `mesPreaviso` es válido y está dentro del rango permitido, se convierte el número del mes a letras utilizando el método `convertirFechas.convertirMesLetras(mesPreaviso)`. El resultado de la conversión se asigna al atributo privado `this.mesPreaviso` del objeto.
     */
    public void setMesPreaviso(@NotNull String mesPreaviso) throws CumplimentarPDFException {

        if (!mesPreaviso.matches("[0-9]+")) {
            throw new CumplimentarPDFException("ERROR, introduce el mes en dígitos\n");
        } else {
            // Eliminar los ceros iniciales
            mesPreaviso = mesPreaviso.replaceFirst("^0+(?!$)", "");

            int mes = Integer.parseInt(mesPreaviso);
            if (mes < Constantes.PRIMER_MES || mes > Constantes.ULTIMO_MES) {
                throw new CumplimentarPDFException("ERROR, mes introducido incorrecto\n");
            }
        }
        this.mesPreaviso = convertirFechas.convertirMesLetras(mesPreaviso);
    }

    public short getAnioPreaviso() {
        return anioPreaviso;
    }

    /**
     * Establece el año de preaviso del documento.
     *
     * @param anioPreaviso El año de preaviso a establecer (se utilizan los dos últimos dígitos del año completo).
     * @throws CumplimentarPDFException Se lanza si el año de preaviso no está dentro del rango válido (año actual o año siguiente).
     * <p>
     * Este método permite asignar el año de preaviso al documento PDF. Se valida que el valor de `anioPreaviso` esté dentro del rango permitido:
     * el año actual o el año siguiente. Para realizar la validación, se utiliza la clase `Calendar` y su método `get(Calendar.YEAR)` para obtener el año actual.
     * <p>
     * La condición de validación comprueba que:
     *  - La suma de `anioPreaviso` y 1 sea menor al año actual: esto descarta años anteriores al actual.
     *  - `anioPreaviso` sea menor o igual al año actual más 1: esto descarta años posteriores al año siguiente.
     * <p>
     * Si la condición no se cumple, se lanza una excepción `CumplimentarPDFException` con el mensaje "ERROR, Año introducido incorrecto\n".
     * <p>
     * Si el valor de `anioPreaviso` es válido, se asigna a un short utilizando el operador de casting `(short)`.
     * Adicionalmente, se aplica el módulo 100 (`anioPreaviso % 100`) para obtener los dos últimos dígitos del año completo.
     * Este último valor se asigna al atributo privado `this.anioPreaviso` del objeto.
     */
    public void setAnioPreaviso(short anioPreaviso) throws CumplimentarPDFException {

        if ((anioPreaviso + 1) < Calendar.getInstance().get(Calendar.YEAR) || (anioPreaviso ) > Calendar.getInstance().get(Calendar.YEAR) + 1){
            throw new CumplimentarPDFException("ERROR, Año introducido incorrecto\n");
        }
        this.anioPreaviso = (short) (anioPreaviso % 100);
    }

    public String getFechaConstitucionLetras() {
        return fechaConstitucionLetras;
    }

    /**
     * Convierte la fecha de constitución a un formato textual (día, mes y año en letras).
     *
     * @param fechaConstitucion La fecha de constitución en formato "dd/MM/yyyy".
     * <p>
     * Este método convierte la fecha de constitución (`fechaConstitucion`) del formato "dd/MM/yyyy" a un formato textual, donde el día y el mes se representan en letras y el año permanece en formato numérico. La fecha convertida se almacena luego en el atributo `this.fechaConstitucionLetras` del objeto.
     * <p>
     * Los pasos del método son:
     * 1. Dividir la cadena de fecha de constitución en un array de partes utilizando el delimitador "/".
     * 2. Convertir las partes del día y el mes a cadenas de texto.
     * 3. Añadir un guión "-" entre el día y el mes.
     * 4. Eliminar los ceros iniciales de la cadena del mes.
     * 5. Convertir el mes a letras utilizando `convertirFechas.convertirMesLetras(mes)`.
     * 6. Añadir un espacio entre el mes y el año.
     * 7. Concatenar el día, el mes modificado y el año en una nueva cadena de texto.
     * 8. Almacenar la fecha convertida en el atributo `this.fechaConstitucionLetras`.
     */
    public void setFechaConstitucionLetras(@NotNull String fechaConstitucion) {
        String[] partes = fechaConstitucion.split("/");

        // Convertir el día y el mes a cadenas de texto
        String dia = String.valueOf(partes[0]);
        String mes = partes[1];

        // Agregar un guión "-" entre el día y el mes
        dia = dia + " - ";

        // Elimina los 0 para evitar errores
        if (mes.startsWith("0")){
           mes = mes.replace("0", "");
        }
        // Agregar un espacio entre el mes y el año
        mes = convertirFechas.convertirMesLetras(mes) + " - ";
        this.mesConstitucionLetras = mes;

        // Agregar el año a la cadena de texto
        fechaConstitucion = dia + mes + partes[2];

        // Establecer la fecha en el atributo
        this.fechaConstitucionLetras = fechaConstitucion;
    }

    public String getMesConstitucionLetras() {
        return mesConstitucionLetras;
    }

/*
 public void setMesConstitucionLetras (String fechaConstitucion){
     String[] partes = fechaConstitucion.split("/");
     String mes = partes[1];

     // Elimina los 0 para evitar errores
     if (mes.startsWith("0")){
         mes = mes.replace("0", "");
     }
     // Agregar un espacio entre el mes y el año
     mes = convertirFechas.convertirMesLetras(mes);
     this.mesConstitucionLetras = mes;
 }
*/

    @Override
    public String toString() {
        return "Preaviso de la Empresa " + nombreEmpresa + " Generado.\n";
    }
}