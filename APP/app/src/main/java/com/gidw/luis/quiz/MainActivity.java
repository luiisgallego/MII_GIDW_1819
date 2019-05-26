package com.gidw.luis.quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    // Método inicial para el login
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Declaramos los campos editables y el botón
        final EditText usuario = (EditText) findViewById(R.id.mainEditUsuario);
        final EditText password = (EditText) findViewById(R.id.mainEditPass);
        final Button boton = (Button) findViewById(R.id.mainButtonLogin);

        // Funcionalidad para cuando pulsamos el botón
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if( compruebaPassword(usuario.getText(), password.getText()) ) {

                    // Creamos e iniciamos la nueva actividad
                    Intent mainIntent = new Intent(MainActivity.this, LevelsActivity.class);
                    startActivity(mainIntent);

                } else {
                    // Limpiamos los campos si no son correctos
                    usuario.setText("");
                    password.setText("");
                }

            }
        });
    } // Fin onCreate()

    private boolean compruebaPassword(Editable usuario, Editable password) {
        // Añadir valores
        return (usuario.toString().equals("") && password.toString().equals(""));
    }

    // Para cuando la actividad vuelve a ser mostrada
    @Override
    protected void onRestart() {
        super.onRestart();

        final EditText usuario = (EditText) findViewById(R.id.mainEditUsuario);
        final EditText password = (EditText) findViewById(R.id.mainEditPass);

        usuario.setText("");
        password.setText("");
    }
}
