package com.gidw.luis.quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Button;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.Context;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String nombre_shared, pass_shared, email_shared, genero_shared;
    Boolean statusSharedPreferences;
    String[] generos = {"Hombre", "Mujer"};
    String genero;

    // DB
    private DB db;
    private List<Questions> listQuestions = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Referenciamos de preferencias compartidas
        final SharedPreferences infoPrincipal = getSharedPreferences("Contenido_principal", Context.MODE_PRIVATE);
        final SharedPreferences score = getSharedPreferences("ScoreActivity", Context.MODE_PRIVATE);

        // Comprobamos si ya se ha registrado
        statusSharedPreferences = comprobarSharedPreferences(infoPrincipal);
        System.out.println("StatusSharedPreferences: " + statusSharedPreferences);

        // Actuamos en funcion de status
        if(!statusSharedPreferences) {  // Registrar
            setContentView(R.layout.activity_main_registrar);

            // Como es nuestra primera vez, creamos la BD
            db = new DB(this);
            db.insertarQuestiones();

            // Declaramos los campos editables y el botón
            final EditText usuarioRegistrar = findViewById(R.id.mainEditUsuarioRegistrar);
            final EditText passwordRegistrar = findViewById(R.id.mainEditPassRegistrar);
            final EditText emailRegistrar = findViewById(R.id.mainEditEmailRegistrar);
            final Button botonRegistrar = findViewById(R.id.mainButtonRegistrar);

                // Configuramos spinner genero
            Spinner generoRegistrar = findViewById(R.id.mainSpinnerGeneroRegistrar);
            ArrayAdapter<String> adapterSpinnnerGenero = new ArrayAdapter<>(this, R.layout.spinner_genero, generos);
            adapterSpinnnerGenero.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
            generoRegistrar.setAdapter(adapterSpinnnerGenero);
            generoRegistrar.setOnItemSelectedListener(new SpinnerActivity());

            botonRegistrar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(usuarioRegistrar.getText().toString().equals("") || passwordRegistrar.getText().toString().equals("")) {

                        // Si no hay datos, limpiamos y notificamos
                        usuarioRegistrar.setText("");
                        passwordRegistrar.setText("");
                        Toast.makeText(MainActivity.this, "Por favor introduce los datos", Toast.LENGTH_SHORT).show();

                    } else {

                        // Copiamos los datos del usuario al sharedPreferences
                        SharedPreferences.Editor editorInfoPrincipal = infoPrincipal.edit();
                        editorInfoPrincipal.putString("nombre", usuarioRegistrar.getText().toString());
                        editorInfoPrincipal.putString("contraseña", passwordRegistrar.getText().toString());
                        editorInfoPrincipal.putString("email", emailRegistrar.getText().toString());
                        editorInfoPrincipal.putString("genero", genero);
                        editorInfoPrincipal.commit();

                        // Iniciamos la info del score
                        SharedPreferences.Editor editorScore = score.edit();
                        editorScore.putInt("nivel", 1);
                        editorScore.putInt("score_level_1", 0);
                        editorScore.putInt("score_level_2", 0);
                        editorScore.putInt("score_level_3", 0);
                        editorScore.putInt("score_level_4", 0);
                        editorScore.putInt("score_level_5", 0);
                        editorScore.putInt("score_level_6", 0);
                        editorScore.putInt("score_level_7", 0);
                        editorScore.putInt("score_level_8", 0);
                        editorScore.putInt("score_level_9", 0);
                        editorScore.putInt("score_level_10", 0);
                        editorScore.commit();

                        // Creamos e iniciamos la nueva actividad
                        Intent mainIntent = new Intent(MainActivity.this, LevelsActivity.class);
                        startActivity(mainIntent);
                    }
                }
            });
        } else { // Login
            setContentView(R.layout.activity_main_login);

            // Declaramos los campos editables y el botón
            final EditText usuarioLogin = findViewById(R.id.mainEditUsuarioLogin);
            usuarioLogin.setText(infoPrincipal.getString("nombre", ""));
            final EditText passwordLogin = findViewById(R.id.mainEditPassLogin);
            final Button botonLogin = findViewById(R.id.mainButtonLogin);

            botonLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    System.out.println("FUNCION LOGIN: ");
                    System.out.println(infoPrincipal.getString("contraseña", ""));
                    System.out.println(passwordLogin.getText().toString());
                    System.out.println(" FIN FUNCION LOGIN: ");

                    if( passwordLogin.getText().toString().equals(infoPrincipal.getString("contraseña", "")) ) {

                        // Creamos e iniciamos la nueva actividad
                        Intent mainIntent = new Intent(MainActivity.this, LevelsActivity.class);
                        startActivity(mainIntent);

                    } else {

                        // Limpiamos los campos si no son correctos
                        // usuario.setText("");
                        passwordLogin.setText("");

                    }
                }
            });
        }   // fin else
    } // fin onCreate

    private boolean comprobarSharedPreferences(SharedPreferences infoPrincipal) {

        nombre_shared = infoPrincipal.getString("nombre", ""); // Por defecto vacio (en el caso de que no haya nada)
        pass_shared = infoPrincipal.getString("contraseña", "");
        email_shared = infoPrincipal.getString("email", "");
        genero_shared = infoPrincipal.getString("genero", "");

        return (!nombre_shared.equals("") || !pass_shared.equals("") || !email_shared.equals("") || !genero_shared.equals(""));
    }

    // Spinner class para seleccionar el spinner y tambien el genero
    class SpinnerActivity implements AdapterView.OnItemSelectedListener {

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            genero = parent.getItemAtPosition(position).toString();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {
            // Cuando no seleccionamos nada
            Toast.makeText(getApplicationContext(), "Por favor selecciona el género", Toast.LENGTH_SHORT).show();
        }
    }
}


