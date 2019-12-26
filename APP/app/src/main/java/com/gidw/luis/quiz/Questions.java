package com.gidw.luis.quiz;

public class Questions {

    public static final String TABLE_NAME = "questions";
    public static final String COLUMNA_ID = "id";
    public static final String COLUMNA_PREGUNTA = "pregunta";
    public static final String COLUMNA_OPCION_A = "opcionA";
    public static final String COLUMNA_OPCION_B = "opcionB";
    public static final String COLUMNA_OPCION_C = "opcionC";
    public static final String COLUMNA_OPCION_D = "opcionD";
    public static final String COLUMNA_RESPUESTA = "respuesta";
    public static final String COLUMNA_NIVEL = "nivel";

    private int id, nivel;
    private String pregunta, opcionA, opcionB, opcionC, opcionD, respuesta;

    // Create table SQL query
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMNA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMNA_PREGUNTA + " TEXT,"
                    + COLUMNA_OPCION_A + " TEXT,"
                    + COLUMNA_OPCION_B + " TEXT,"
                    + COLUMNA_OPCION_C + " TEXT,"
                    + COLUMNA_OPCION_D + " TEXT,"
                    + COLUMNA_RESPUESTA + " TEXT,"
                    + COLUMNA_NIVEL + " INTEGER"
                    + ")";

    public Questions(){}

    public Questions(String pregunta, String opcionA, String opcionB, String opcionC, String opcionD, String respuesta, int nivel){
        this.pregunta = pregunta;
        this.opcionA = opcionA;
        this.opcionB = opcionB;
        this.opcionC = opcionC;
        this.opcionD = opcionD;
        this.respuesta = respuesta;
        this.nivel = nivel;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setOpcionA(String opcionA) {
        this.opcionA = opcionA;
    }

    public String getOpcionA() {
        return opcionA;
    }

    public void setOpcionB(String opcionB) {
        this.opcionB = opcionB;
    }

    public String getOpcionB() {
        return opcionB;
    }

    public void setOpcionC(String opcionC) {
        this.opcionC = opcionC;
    }

    public String getOpcionC() {
        return opcionC;
    }

    public void setOpcionD(String opcionD) {
        this.opcionD = opcionD;
    }

    public String getOpcionD() {
        return opcionD;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getNivel() {
        return nivel;
    }

}
