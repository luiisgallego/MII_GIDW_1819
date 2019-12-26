package com.gidw.luis.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    Boolean subeNivel;
    Integer numAcertadas, score, incorrectas;

    TextView scoreTxt, totalPreguntasTxt, correctasTxt, incorrectasTxt, resultadoFinalTxt, subeNivelTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        scoreTxt = findViewById(R.id.resultScore);
        totalPreguntasTxt = findViewById(R.id.totalPreguntas);
        correctasTxt = findViewById(R.id.correctasPreguntas);
        incorrectasTxt = findViewById(R.id.incorrectasPreguntas);
        resultadoFinalTxt = findViewById(R.id.resultFinal);
        subeNivelTxt = findViewById(R.id.subeNivel);

        // Recibimos la info del intent
        Intent testIntent = getIntent();
        subeNivel = testIntent.getBooleanExtra(TestActivity.subeNivelPut, false);
        numAcertadas = testIntent.getIntExtra(TestActivity.numAcertadasPut, 0);

        // Preparamos los datos
        score = numAcertadas * 25;
        incorrectas = 4 - numAcertadas;

        // Lanzamos los datos
        scoreTxt.setText("ScoreActivity : " + score);
        totalPreguntasTxt.setText(" " + 4);
        correctasTxt.setText(" " + numAcertadas);
        incorrectasTxt.setText(" " + incorrectas);

        if(score < 50) {
            resultadoFinalTxt.setText("Necesitas mejorar!");
            subeNivelTxt.setText("No subes de nivel");
        } else if(score < 75) {
            resultadoFinalTxt.setText("Lo conseguiste!");
            subeNivelTxt.setText("¡Subes de nivel!");
        } else {
            resultadoFinalTxt.setText("Eres brillante!");
            subeNivelTxt.setText("¡Subes de nivel!");
        }

        final Button boton = findViewById(R.id.buttonVolver);
        // Volvemos al inicio al pulsar el botón
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent(ResultActivity.this, LevelsActivity.class);
                startActivity(resultIntent);
            }
        });

    }
}
