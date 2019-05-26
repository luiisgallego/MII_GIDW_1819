package com.gidw.luis.quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.content.Intent;
import android.widget.GridView;
import android.widget.AdapterView;
import android.widget.ListAdapter;

import java.util.ArrayList;
import java.util.Arrays;

public class LevelsActivity extends AppCompatActivity {

    // Para indicar el botón pulsado en la siguiente pagina
    public final static String LevelPulsado = "com.gidw.luis.quiz.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_levels);

        // Declaramos los diferentes botones
        final Button boton1 = findViewById(R.id.levelsButton1);
        final Button boton2 = findViewById(R.id.levelsButton2);

        // Funcionalidad para cuando pulsamos el boton 1
        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Creamos el enlace
                Intent levelsIntent = new Intent(LevelsActivity.this, ReadyActivity.class);
                // Mandamos el botón que ha sido pulsado
                levelsIntent.putExtra(LevelPulsado, "1");
                // Iniciamos la actividad
                startActivity(levelsIntent);

            }
        });

        // Funcionalidad para cuando pulsamos el boton 2
        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Creamos el enlace
                Intent levelsIntent = new Intent(LevelsActivity.this, ReadyActivity.class);
                // Mandamos el botón que ha sido pulsado
                levelsIntent.putExtra(LevelPulsado, "2");
                // Iniciamos la actividad
                startActivity(levelsIntent);

            }
        });
    }
}
