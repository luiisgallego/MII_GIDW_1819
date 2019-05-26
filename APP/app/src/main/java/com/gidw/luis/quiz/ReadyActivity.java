package com.gidw.luis.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ReadyActivity extends AppCompatActivity {

    String level;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Llamamos a la vista
        setContentView(R.layout.activity_ready);

        // Toast.makeText(this, R.string.iniReady, Toast.LENGTH_SHORT).show();

        Intent levelsIntent = getIntent();
        level = levelsIntent.getStringExtra(LevelsActivity.LevelPulsado);

        String txtToast = "El nivel es " + level;
        Toast.makeText(this, txtToast, Toast.LENGTH_SHORT).show();

        // Declaramos el boton
        final Button botonReady = findViewById(R.id.readyButton);

        botonReady.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Creamos e iniciamos la nueva actividad
                Intent readyIntent = new Intent(ReadyActivity.this, TestActivity.class);
                startActivity(readyIntent);

            }
        });
    }
}
