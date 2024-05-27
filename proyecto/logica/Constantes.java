package com.example.proyecto.logica;

public class Constantes {
    public static final String[] PROVINCIAS_ANDALUCIA = {
            "ALMERÍA",
            "CÁDIZ",
            "CÓRDOBA",
            "GRANADA",
            "HUELVA",
            "JAÉN",
            "MÁLAGA",
            "SEVILLA"
    };
    public static final String PROMOTORES = "UNIÓN GENERAL DE TRABAJADORES   (UGT)";
    public static final String FORMATO_FECHA = "dd/MM/yyyy";
    public static final String FORMATO_HORA = "HH:mm";
    public static final short PRIMER_DIA_MES = 1;
    public static final short ULTIMO_DIA_MES = 31;
    public static final short PRIMER_MES = 1;
    public static final short ULTIMO_MES = 12;
    public static final short DIGITOS_CODIGO_POSTAL = 5;
    public static final short DIGITOS_ISS = 11;
    public static final int MINIMO_ELECTORES = 6;
    public static final int MAXIMO_ELECTORES_DELEGADOS = 50;
    public static final int MAXIMO_1_DELEGADO = 30;
    public static final int CANTIDAD_REPRESENTANTES_3 = 3;
    public static final int CANTIDAD_REPRESENTANTES_1 = 1;

    // Constantes PC WORK
    public static final String RUTA_ABSOLUTA_WORK = "C:\\Users\\alber\\Documents";
    public static final String RUTA_ABSOLUTA_NUEVO_WORK = "C:\\Users\\Alberto\\Documents";
    public static final String RUTA_RELATIVA_DOCUMENTACION_ELECCIONES_WORK = "\\Documentacion Elecciones\\";
    public static final String RUTA_RELATIVA_DELEGADOS_WORK = "\\Documentacion Elecciones\\Delegados\\";
    public static final String RUTA_RELATIVA_COMITE_WORK = "\\Documentacion Elecciones\\Comite\\";

    // Constantes PC HOME
    public static final String RUTA_ABSOLUTA_HOME = "C:\\Users\\Alberto CR\\Documents";
    public static final String RUTA_RELATIVA_DOCUMENTACION_ELECCIONES_HOME = "\\DocumentacionElecciones\\";
    public static final String RUTA_RELATIVA_DELEGADOS_HOME = "\\DocumentacionElecciones\\Delegados\\";
    public static final String RUTA_RELATIVA_COMITE_HOME = "\\DocumentacionElecciones\\Comite\\";
    public static final String SALIDAS_SINDICALES = "Salidas Sindicales\\";
    public static final String SALIDA_SINDICAL_COMPLETA = "Salida Sindical Completa";
    public static final String SALIDA_SINDICAL_HORAS = "Salida Sindical Horas";


    //Constante ruta Preaviso
    public static final String PREAVISO = "preaviso";

    //Constantes con directorios de las actas para delegados
    public static final String AUTORIZACION = "autorizacion";
    public static final String DELEGADO_PREVENCION = "anexo_delegado_prevencion";
    public static final String CALENDARIO_DELEGADOS = "calendario_delegado";
    public static final String MODELO_3 = "modelo_3";
    public static final String MODELO_5_1 = "modelo_5_1";
    public static final String MODELO_5_2_PROCESO = "modelo_5_2_proceso";
    public static final String MODELO_5_2_CONCLUSION = "modelo_5_2_conclusion";
    public static final String MODELO_9 = "modelo_9";
    public static final String FICHA_DELEGADO = "ficha_delegado";
    public static final String[] DOCUMENTACION_DELEGADOS = {PREAVISO, CALENDARIO_DELEGADOS, MODELO_3, MODELO_5_1, MODELO_5_2_PROCESO, MODELO_5_2_CONCLUSION, MODELO_9, AUTORIZACION, DELEGADO_PREVENCION, FICHA_DELEGADO};
    public static final String IMPRESION_DELEGADOS = "ImprimirDelegados.ps1";


    //Constantes con directorios de las actas para comite
    public static final String CALENDARIO_COMITE = "calendario_comite";
    public static final String MODELO_4_ESPECIALISTAS = "modelo_4_Especialistas";
    public static final String MODELO_4_TECNICOS = "modelo_4_Tecnicos";
    public static final String MODELO_6_1_ESPECIALISTAS = "modelo_6_1_Especialistas";
    public static final String MODELO_6_1_TECNICOS = "modelo_6_1_Tecnicos";
    public static final String MODELO_6_2_ESPECIALISTAS = "modelo_6_2_Especialistas";
    public static final String MODELO_6_2_TECNICOS = "modelo_6_2_Tecnicos";
    public static final String MODELO_6_3_ESPECIALISTAS = "modelo_6_3_Especialistas";
    public static final String MODELO_6_3_TECNICOS = "modelo_6_3_Tecnicos";
    public static final String MODELO_7_1 = "modelo_7_1";
    public static final String MODELO_7_2 = "modelo_7_2";
    public static final String MODELO_7_3_ACTA_GLOBAL = "modelo_7_3_acta_global";
    public static final String MODELO_7_3_ANEXO = "modelo_7_3_anexo";
    public static final String MODELO_7_3_PROCESO = "modelo_7_3_proceso";
    public static final String MODELO_9_COMITE = "modelo_9";
    public static final String[] DOCUMENTACION_COMITE = {PREAVISO, CALENDARIO_COMITE, MODELO_3, MODELO_4_ESPECIALISTAS, MODELO_4_TECNICOS, MODELO_6_1_ESPECIALISTAS, MODELO_6_1_TECNICOS, MODELO_6_2_ESPECIALISTAS,
            MODELO_6_2_TECNICOS, MODELO_6_3_ESPECIALISTAS, MODELO_6_3_TECNICOS, MODELO_7_1, MODELO_7_2, MODELO_7_3_ACTA_GLOBAL, MODELO_7_3_ANEXO, MODELO_7_3_PROCESO, MODELO_9_COMITE, AUTORIZACION, DELEGADO_PREVENCION, FICHA_DELEGADO};
    public static final String IMPRESION_COMITE = "ImprimirComite.ps1";
    public static final String IMPRESION_EMPRESA = "ImprimirEmpresa.ps1";
    public static final String EXTENSION = ".pdf";
    public static final String FORMATO_PREAVISO = "ppp/aaaa";
    public static final String FORMATO_ISS = "\\d{11}";
    public static final String FORMATO_CONVENIO = "^\\d{14}$";
    public static final String BASICA = "Básica";
    public static final String MEDIA = "Media";
    public static final String SUPERIOR = "Superior";
}
