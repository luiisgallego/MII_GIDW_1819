package com.gidw.luis.quiz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class TestActivity extends AppCompatActivity {

    public final static String numAcertadasPut = "com.gidw.luis.quiz.MESSAGE";
    public final static String subeNivelPut = "com.gidw.luis.quiz.MESSAGE";

    private DB dbTest;
    private List<Questions> listQuestions = new ArrayList<>();

    Button playButton, opcionA, opcionB, opcionC, opcionD;
    TextView pregunta;

    String respuesta = null, opA, opB, opC, opD;
    int level, visibilidad = 0, variable = 0, numPregunta = 0, acertadas = 0;
    boolean terminar = false, subeNivel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        // Recibimos el nivel seleccionado por el intent
        Intent levelsIntent = getIntent();
        level = levelsIntent.getIntExtra(LevelsActivity.LevelPulsado, 0);
        String txtToast = "El nivel seleccionado es " + level;
        Toast.makeText(this, txtToast, Toast.LENGTH_SHORT).show();

        // Cargamos la base de datos. -- Anteriormente habrá sido creada...
        dbTest = new DB(this);
        listQuestions.addAll(dbTest.getQuestionsByLevel(level));

        System.out.println("NÚMERO DE PREGUNTAS: " + listQuestions.size() );

        // Referenciamos texto y botones
        opcionA = findViewById(R.id.buttonTestA);
        opcionB = findViewById(R.id.buttonTestB);
        opcionC = findViewById(R.id.buttonTestC);
        opcionD = findViewById(R.id.buttonTestD);
        pregunta = findViewById(R.id.textViewPregunta);
        // Botón para empezar a jugar
        playButton = findViewById(R.id.play_button);
    }

    public void onClick(View vista) {

        if(visibilidad == 0) {

            // Mostramos los botones ocultos
            opcionA.setVisibility(View.VISIBLE);
            opcionB.setVisibility(View.VISIBLE);
            opcionC.setVisibility(View.VISIBLE);
            opcionD.setVisibility(View.VISIBLE);
            pregunta.setVisibility(View.VISIBLE);
            // Ocultamos el de play
            playButton.setVisibility(View.GONE);
            visibilidad = 1;

        } // visibilidad

        // Evaluamos la respuesta
        if(respuesta != null) { // HAY PREGUNTA

            // CAMBIAR A SWITCH
            if(respuesta.equals(opA)) {
                if(vista.getId() == R.id.buttonTestA) {
                    Snackbar.make(vista, "RESPUESTA CORRECTA", Snackbar.LENGTH_SHORT).show();
                    acertadas++;
                } else {
                    Snackbar.make(vista, "RESPUESTA INCORRECTA", Snackbar.LENGTH_SHORT).show();
                }
            } else if(respuesta.equals(opB)) {
                if(vista.getId() == R.id.buttonTestB) {
                    Snackbar.make(vista, "RESPUESTA CORRECTA", Snackbar.LENGTH_SHORT).show();
                    acertadas++;
                } else {
                    Snackbar.make(vista, "RESPUESTA INCORRECTA", Snackbar.LENGTH_SHORT).show();
                }
            } else if(respuesta.equals(opC)) {
                if(vista.getId() == R.id.buttonTestC) {
                    Snackbar.make(vista, "RESPUESTA CORRECTA", Snackbar.LENGTH_SHORT).show();
                    acertadas++;
                } else {
                    Snackbar.make(vista, "RESPUESTA INCORRECTA", Snackbar.LENGTH_SHORT).show();
                }
            } else if(respuesta.equals(opD)) {
                if(vista.getId() == R.id.buttonTestD) {
                    Snackbar.make(vista, "RESPUESTA CORRECTA", Snackbar.LENGTH_SHORT).show();
                    acertadas++;
                } else {
                    Snackbar.make(vista, "RESPUESTA INCORRECTA", Snackbar.LENGTH_SHORT).show();
                }
            }
        }

        if(listQuestions.size() > numPregunta) {
            // Mostramos preguntas en funcion del nivel

            // Actualizamos los textos
            Questions actual = listQuestions.get(numPregunta);
            pregunta.setText(actual.getPregunta());
            opA = actual.getOpcionA();
            opcionA.setText(actual.getOpcionA());
            opB = actual.getOpcionB();
            opcionB.setText(actual.getOpcionB());
            opC = actual.getOpcionC();
            opcionC.setText(actual.getOpcionC());
            opD = actual.getOpcionD();
            opcionD.setText(actual.getOpcionD());
            respuesta = actual.getRespuesta();
            //System.out.println("RESPUESTA :" + respuesta);

            numPregunta++;
        } else {
            // Hemos mostrado todas las preguntas, pasamos a Result

            // Calculamos score y actulizamos nivel
            subeNivel = calculaScore(acertadas, level);

            // Cambiamos de pantalla
            Intent resultIntent = new Intent(TestActivity.this, ResultActivity.class);
            // Enviamos los datos necesarios
            resultIntent.putExtra(subeNivelPut, subeNivel);
            resultIntent.putExtra(numAcertadasPut, acertadas);
            startActivity(resultIntent);
            finish();
        }

    }

    public boolean calculaScore(int acertadas, int level) {

        int porcentajeAcertadas = 0, nivel;
        String txtScoreLevel = "score_level_" + level;
        boolean subeNivel = false;

        SharedPreferences score = getSharedPreferences("ScoreActivity", Context.MODE_PRIVATE);
        nivel = score.getInt("nivel", 0);
        SharedPreferences.Editor editorScore = score.edit();

        // Como tenemos 4 preguntas por nivel multiplicamos por 25
        porcentajeAcertadas = acertadas * 25;
        // Guardamos el resultado

        editorScore.putInt(txtScoreLevel, porcentajeAcertadas);

        // Subimos de nivel si acierta más de la mitad
        if(porcentajeAcertadas >= 50) {
            nivel++;
            editorScore.putInt("nivel", nivel);
            subeNivel = true;
        }

        editorScore.commit();
        return subeNivel;
    }
}
