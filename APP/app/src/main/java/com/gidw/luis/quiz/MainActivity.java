package com.gidw.luis.quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.Context;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String nombre_shared, pass_shared, email_shared, genero_shared;
    Boolean statusSharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Referenciamos de preferencias compartidas
        final SharedPreferences infoPrincipal = getSharedPreferences("Contenido_principal", Context.MODE_PRIVATE);
        //SharedPreferences score = getSharedPreferences("Score", Context.MODE_PRIVATE);

        // Comprobamos si ya se ha registrado
        statusSharedPreferences = comprobarSharedPreferences(infoPrincipal);

        //System.out.println("\n\n\n HEREEE  \n\n\n" + statusSharedPreferences);

        // Actuamos en funcion de status
        if(!statusSharedPreferences) {  // Registrar
            setContentView(R.layout.activity_main_registrar);

            // Declaramos los campos editables y el botón
            final EditText usuarioRegistrar = findViewById(R.id.mainEditUsuarioRegistrar);
            final EditText passwordRegistrar = findViewById(R.id.mainEditPassRegistrar);
            final Button botonRegistrar = findViewById(R.id.mainButtonRegistrar);

            botonRegistrar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(usuarioRegistrar.getText().toString().equals("") || passwordRegistrar.getText().toString().equals("")) {

                        // Si no hay datos, limpiamos y notificamos
                        usuarioRegistrar.setText("");
                        passwordRegistrar.setText("");
                        Toast.makeText(MainActivity.this, "Por favor introduce los datos", Toast.LENGTH_SHORT).show();

                    } else {

                        // Copiamos los datos al sharedPreferences
                        SharedPreferences.Editor editorInfoPrincipal = infoPrincipal.edit();
                        editorInfoPrincipal.putString("nombre", usuarioRegistrar.getText().toString());
                        editorInfoPrincipal.putString("contraseña", passwordRegistrar.getText().toString());
                        //editorInfoPrincipal.putString("email", "emailRandom@gmail.es");
                        //editorInfoPrincipal.putString("genero", "Hombre");
                        editorInfoPrincipal.commit();

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
        //email_shared = infoPrincipal.getString("email", "");
        //genero_shared = infoPrincipal.getString("genero", "");

        System.out.println("FUNCION SHARED PREFERENCES: ");
        System.out.println(nombre_shared);
        System.out.println(pass_shared);
        System.out.println(" FIN FUNCION SHARED PREFERENCES: ");

        //return (!nombre_shared.equals("") || !pass_shared.equals("") || !email_shared.equals("") || !genero_shared.equals(""));
        return (!nombre_shared.equals("") || !pass_shared.equals(""));
    }

    /*private boolean compruebaPassword(Editable usuario, Editable password, SharedPreferences infoPrincipal) {
        return (!usuario.toString().equals(infoPrincipal.getString("nombre", ""))
                && !password.toString().equals(infoPrincipal.getString("contraseña", "")));
    }*/


}
