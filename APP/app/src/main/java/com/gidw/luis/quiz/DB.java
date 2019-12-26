package com.gidw.luis.quiz;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class DB extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;              // Database Version
    private static final String DATABASE_NAME = "Questions_DB"; // Database Name

    public DB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {

        // CREAMOS LA BASE DE DATOS
        // Solo se ejecuta la primera vez
        db.execSQL(Questions.CREATE_TABLE);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        // Borramos la base de datos antigua
        String DELETE_TABLE = "DROP TABLE IF EXISTS " + Questions.TABLE_NAME;
        db.execSQL(DELETE_TABLE);

        // La creamos de nuevo
        onCreate(db);
    }

    public List<Questions> obtenerQuestiones() {

        List<Questions> listQuestions = new ArrayList<>();

        Questions cuestion1 = new Questions("¿Río más largo del mundo?", "Guadalquivir", "Amazonas", "Nilo", "Salado", "Amazonas", 1);
        Questions cuestion1_1 = new Questions("¿Cómo se llama la capital de Mongolia?", "Ulan Bator", "Madrid", "Paris", "Amsterdam", "Ulan Bator", 1);
        Questions cuestion1_2 = new Questions("¿De qué se alimentan los koalas?", "Arroz", "Pasta", "Hojas de eucalipto", "Frutas", "Hojas de eucalipto", 1);
        Questions cuestion1_3 = new Questions(" ¿Cuál fue la primera película de Walt Disney?", "Pocahontas", "El rey león", "Dumbo", "Blancanieves y los siete enanitos", "Blancanieves y los siete enanitos", 1);

        Questions cuestion2 = new Questions("Pregunta nivel 2 - 1", "Opción A-1", "Opción B-1", "Opción C-1", "Opción D-1", "Opción A-1", 2);
        Questions cuestion2_1 = new Questions("Pregunta nivel 2 - 2", "Opción A", "Opción B-2", "Opción C-2", "Opción D-2", "Opción B-2", 2);
        Questions cuestion2_2 = new Questions("Pregunta nivel 2 - 3", "Opción A-3", "Opción B-3", "Opción C-3", "Opción D-3", "Opción C-3", 2);
        Questions cuestion2_3 = new Questions("Pregunta nivel 2 - 4", "Opción A-4", "Opción B-4", "Opción C-4", "Opción D-4", "Opción D-4", 2);

        Questions cuestion3 = new Questions("Pregunta nivel 3 - 1", "Opción A-1", "Opción B-1", "Opción C-1", "Opción D-1", "Opción A-1", 3);
        Questions cuestion3_1 = new Questions("Pregunta nivel 3 - 2", "Opción A", "Opción B-2", "Opción C-2", "Opción D-2", "Opción B-2", 3);
        Questions cuestion3_2 = new Questions("Pregunta nivel 3 - 3", "Opción A-3", "Opción B-3", "Opción C-3", "Opción D-3", "Opción C-3", 3);
        Questions cuestion3_3 = new Questions("Pregunta nivel 3 - 4", "Opción A-4", "Opción B-4", "Opción C-4", "Opción D-4", "Opción D-4", 3);

        Questions cuestion4 = new Questions("Pregunta nivel 4 - 1", "Opción A-1", "Opción B-1", "Opción C-1", "Opción D-1", "Opción A-1", 4);
        Questions cuestion4_1 = new Questions("Pregunta nivel 4 - 2", "Opción A", "Opción B-2", "Opción C-2", "Opción D-2", "Opción B-2", 4);
        Questions cuestion4_2 = new Questions("Pregunta nivel 4 - 3", "Opción A-3", "Opción B-3", "Opción C-3", "Opción D-3", "Opción C-3", 4);
        Questions cuestion4_3 = new Questions("Pregunta nivel 4 - 4", "Opción A-4", "Opción B-4", "Opción C-4", "Opción D-4", "Opción D-4", 4);

        Questions cuestion5 = new Questions("Pregunta nivel 5 - 1", "Opción A-1", "Opción B-1", "Opción C-1", "Opción D-1", "Opción A-1", 5);
        Questions cuestion5_1 = new Questions("Pregunta nivel 5 - 2", "Opción A", "Opción B-2", "Opción C-2", "Opción D-2", "Opción B-2", 5);
        Questions cuestion5_2 = new Questions("Pregunta nivel 5 - 3", "Opción A-3", "Opción B-3", "Opción C-3", "Opción D-3", "Opción C-3", 5);
        Questions cuestion5_3 = new Questions("Pregunta nivel 5 - 4", "Opción A-4", "Opción B-4", "Opción C-4", "Opción D-4", "Opción D-4", 5);

        Questions cuestion6 = new Questions("Pregunta nivel 6 - 1", "Opción A-1", "Opción B-1", "Opción C-1", "Opción D-1", "Opción A-1", 6);
        Questions cuestion6_1 = new Questions("Pregunta nivel 6 - 2", "Opción A", "Opción B-2", "Opción C-2", "Opción D-2", "Opción B-2", 6);
        Questions cuestion6_2 = new Questions("Pregunta nivel 6 - 3", "Opción A-3", "Opción B-3", "Opción C-3", "Opción D-3", "Opción C-3", 6);
        Questions cuestion6_3 = new Questions("Pregunta nivel 6 - 4", "Opción A-4", "Opción B-4", "Opción C-4", "Opción D-4", "Opción D-4", 6);

        Questions cuestion7 = new Questions("Pregunta nivel 7 - 1", "Opción A-1", "Opción B-1", "Opción C-1", "Opción D-1", "Opción A-1", 7);
        Questions cuestion7_1 = new Questions("Pregunta nivel 7 - 2", "Opción A", "Opción B-2", "Opción C-2", "Opción D-2", "Opción B-2", 7);
        Questions cuestion7_2 = new Questions("Pregunta nivel 7 - 3", "Opción A-3", "Opción B-3", "Opción C-3", "Opción D-3", "Opción C-3", 7);
        Questions cuestion7_3 = new Questions("Pregunta nivel 7 - 4", "Opción A-4", "Opción B-4", "Opción C-4", "Opción D-4", "Opción D-4", 7);

        Questions cuestion8 = new Questions("Pregunta nivel 8 - 1", "Opción A-1", "Opción B-1", "Opción C-1", "Opción D-1", "Opción A-1", 8);
        Questions cuestion8_1 = new Questions("Pregunta nivel 8 - 2", "Opción A", "Opción B-2", "Opción C-2", "Opción D-2", "Opción B-2", 8);
        Questions cuestion8_2 = new Questions("Pregunta nivel 8 - 3", "Opción A-3", "Opción B-3", "Opción C-3", "Opción D-3", "Opción C-3", 8);
        Questions cuestion8_3 = new Questions("Pregunta nivel 8 - 4", "Opción A-4", "Opción B-4", "Opción C-4", "Opción D-4", "Opción D-4", 8);

        Questions cuestion9 = new Questions("Pregunta nivel 9 - 1", "Opción A-1", "Opción B-1", "Opción C-1", "Opción D-1", "Opción A-1", 9);
        Questions cuestion9_1 = new Questions("Pregunta nivel 9 - 2", "Opción A", "Opción B-2", "Opción C-2", "Opción D-2", "Opción B-2", 9);
        Questions cuestion9_2 = new Questions("Pregunta nivel 9 - 3", "Opción A-3", "Opción B-3", "Opción C-3", "Opción D-3", "Opción C-3", 9);
        Questions cuestion9_3 = new Questions("Pregunta nivel 9 - 4", "Opción A-4", "Opción B-4", "Opción C-4", "Opción D-4", "Opción D-4", 9);

        Questions cuestion10 = new Questions("Pregunta nivel 10 - 1", "Opción A-1", "Opción B-1", "Opción C-1", "Opción D-1", "Opción A-1", 10);
        Questions cuestion10_1 = new Questions("Pregunta nivel 10 - 2", "Opción A", "Opción B-2", "Opción C-2", "Opción D-2", "Opción B-2", 10);
        Questions cuestion10_2 = new Questions("Pregunta nivel 10 - 3", "Opción A-3", "Opción B-3", "Opción C-3", "Opción D-3", "Opción C-3", 10);
        Questions cuestion10_3 = new Questions("Pregunta nivel 10 - 4", "Opción A-4", "Opción B-4", "Opción C-4", "Opción D-4", "Opción D-4", 10);


        listQuestions.add(cuestion1);
        listQuestions.add(cuestion1_1);
        listQuestions.add(cuestion1_2);
        listQuestions.add(cuestion1_3);
        listQuestions.add(cuestion2);
        listQuestions.add(cuestion2_1);
        listQuestions.add(cuestion2_2);
        listQuestions.add(cuestion2_3);
        listQuestions.add(cuestion3);
        listQuestions.add(cuestion3_1);
        listQuestions.add(cuestion3_2);
        listQuestions.add(cuestion3_3);
        listQuestions.add(cuestion4);
        listQuestions.add(cuestion4_1);
        listQuestions.add(cuestion4_2);
        listQuestions.add(cuestion4_3);
        listQuestions.add(cuestion5);
        listQuestions.add(cuestion5_1);
        listQuestions.add(cuestion5_2);
        listQuestions.add(cuestion5_3);
        listQuestions.add(cuestion6);
        listQuestions.add(cuestion6_1);
        listQuestions.add(cuestion6_2);
        listQuestions.add(cuestion6_3);
        listQuestions.add(cuestion7);
        listQuestions.add(cuestion7_1);
        listQuestions.add(cuestion7_2);
        listQuestions.add(cuestion7_3);
        listQuestions.add(cuestion8);
        listQuestions.add(cuestion8_1);
        listQuestions.add(cuestion8_2);
        listQuestions.add(cuestion8_3);
        listQuestions.add(cuestion9);
        listQuestions.add(cuestion9_1);
        listQuestions.add(cuestion9_2);
        listQuestions.add(cuestion9_3);
        listQuestions.add(cuestion10);
        listQuestions.add(cuestion10_1);
        listQuestions.add(cuestion10_2);
        listQuestions.add(cuestion10_3);

        return listQuestions;
    }

    public long insertarQuestiones() {
        SQLiteDatabase db = this.getWritableDatabase();

        List<Questions> listQuestions = obtenerQuestiones();
        int contador = 0;

        for(int i=0; i < listQuestions.size(); i++) {

            ContentValues values = new ContentValues();

            values.put(Questions.COLUMNA_PREGUNTA, listQuestions.get(i).getPregunta());
            values.put(Questions.COLUMNA_OPCION_A, listQuestions.get(i).getOpcionA());
            values.put(Questions.COLUMNA_OPCION_B, listQuestions.get(i).getOpcionB());
            values.put(Questions.COLUMNA_OPCION_C, listQuestions.get(i).getOpcionC());
            values.put(Questions.COLUMNA_OPCION_D, listQuestions.get(i).getOpcionD());
            values.put(Questions.COLUMNA_RESPUESTA, listQuestions.get(i).getRespuesta());
            values.put(Questions.COLUMNA_NIVEL, listQuestions.get(i).getNivel());

            db.insert(Questions.TABLE_NAME, null, values);
            contador++;
        }

        db.close();
        System.out.println("BD INSERTADA");
        return contador;
    }

    public List<Questions> getQuestions() {
        List<Questions> questions = new ArrayList<>();

        String query = "SELECT * FROM " + Questions.TABLE_NAME + " ORDER BY " + Questions.COLUMNA_ID + " ASC";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if(cursor.moveToFirst()){
            do {
                Questions question = new Questions();
                question.setPregunta(cursor.getString(cursor.getColumnIndex(Questions.COLUMNA_PREGUNTA)));
                question.setOpcionA(cursor.getString(cursor.getColumnIndex(Questions.COLUMNA_OPCION_A)));
                question.setOpcionB(cursor.getString(cursor.getColumnIndex(Questions.COLUMNA_OPCION_B)));
                question.setOpcionC(cursor.getString(cursor.getColumnIndex(Questions.COLUMNA_OPCION_C)));
                question.setOpcionD(cursor.getString(cursor.getColumnIndex(Questions.COLUMNA_OPCION_D)));
                question.setRespuesta(cursor.getString(cursor.getColumnIndex(Questions.COLUMNA_RESPUESTA)));
                question.setNivel(cursor.getInt(cursor.getColumnIndex(Questions.COLUMNA_NIVEL)));

                questions.add(question);

            } while(cursor.moveToNext());
        }

        db.close();
        return questions;
    }

    public List<Questions> getQuestionsByLevel(Integer level) {
        List<Questions> questions = new ArrayList<>();

        // String query = "SELECT * FROM " + Questions.TABLE_NAME + " ORDER BY " + Questions.COLUMNA_ID + " ASC";
        String query = "SELECT * FROM " + Questions.TABLE_NAME + " WHERE " + Questions.COLUMNA_NIVEL + " = " + level + " ORDER BY " + Questions.COLUMNA_ID + " ASC";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if(cursor.moveToFirst()){
            do {
                Questions question = new Questions();
                question.setPregunta(cursor.getString(cursor.getColumnIndex(Questions.COLUMNA_PREGUNTA)));
                question.setOpcionA(cursor.getString(cursor.getColumnIndex(Questions.COLUMNA_OPCION_A)));
                question.setOpcionB(cursor.getString(cursor.getColumnIndex(Questions.COLUMNA_OPCION_B)));
                question.setOpcionC(cursor.getString(cursor.getColumnIndex(Questions.COLUMNA_OPCION_C)));
                question.setOpcionD(cursor.getString(cursor.getColumnIndex(Questions.COLUMNA_OPCION_D)));
                question.setRespuesta(cursor.getString(cursor.getColumnIndex(Questions.COLUMNA_RESPUESTA)));
                question.setNivel(cursor.getInt(cursor.getColumnIndex(Questions.COLUMNA_NIVEL)));

                questions.add(question);

            } while(cursor.moveToNext());
        }

        db.close();
        return questions;
    }


}
