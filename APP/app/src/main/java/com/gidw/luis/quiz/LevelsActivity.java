package com.gidw.luis.quiz;

import android.content.SharedPreferences;
import android.content.Context;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class LevelsActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    // Para indicar el botón pulsado en la siguiente pagina
    public final static String LevelPulsado = "com.gidw.luis.quiz.MESSAGE";
    int nivel = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_levels);

        final SharedPreferences score = getSharedPreferences("ScoreActivity", Context.MODE_PRIVATE);
        final int nivel = score.getInt("nivel", 0);

        String txtToast = "Su nivel es " + nivel;
        Toast.makeText(this, txtToast, Toast.LENGTH_SHORT).show();

        /* -------- Actualizar la información del navigation drawer según el login -------- */
        actualizarHeaderNavigationDrawer();

        /* -------- Declaramos los diferentes botones -------- */
        final Button boton1 = findViewById(R.id.levelsButton1);
        final Button boton2 = findViewById(R.id.levelsButton2);
        final Button boton3 = findViewById(R.id.levelsButton3);
        final Button boton4 = findViewById(R.id.levelsButton4);
        final Button boton5 = findViewById(R.id.levelsButton5);
        final Button boton6 = findViewById(R.id.levelsButton6);
        final Button boton7 = findViewById(R.id.levelsButton7);
        final Button boton8 = findViewById(R.id.levelsButton8);
        final Button boton9 = findViewById(R.id.levelsButton9);
        final Button boton10 = findViewById(R.id.levelsButton10);

        // Funcionalidad para cuando pulsamos el boton 1
        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Creamos el enlace
                Intent levelsIntent = new Intent(LevelsActivity.this, TestActivity.class);
                // Mandamos el botón que ha sido pulsado
                levelsIntent.putExtra(LevelPulsado, 1);
                // Iniciamos la actividad
                startActivity(levelsIntent);
            }
        });
        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent levelsIntent = new Intent(LevelsActivity.this, TestActivity.class);
                levelsIntent.putExtra(LevelPulsado, 2);
                startActivity(levelsIntent);
            }
        });
        boton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent levelsIntent = new Intent(LevelsActivity.this, TestActivity.class);
                levelsIntent.putExtra(LevelPulsado, 3);
                startActivity(levelsIntent);
            }
        });
        boton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent levelsIntent = new Intent(LevelsActivity.this, TestActivity.class);
                levelsIntent.putExtra(LevelPulsado, 4);
                startActivity(levelsIntent);
            }
        });
        boton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Hay que superar los anteriores niveles para poder jugar
                if(nivel < 5) {
                    String txtToast2 = "Su nivel es insuficente";
                    Toast.makeText(LevelsActivity.this, txtToast2, Toast.LENGTH_SHORT).show();
                } else {
                    Intent levelsIntent = new Intent(LevelsActivity.this, TestActivity.class);
                    levelsIntent.putExtra(LevelPulsado, 5);
                    startActivity(levelsIntent);
                }
            }
        });
        boton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Hay que superar los anteriores niveles para poder jugar
                if(nivel < 5) {
                    String txtToast2 = "Su nivel es insuficente";
                    Toast.makeText(LevelsActivity.this, txtToast2, Toast.LENGTH_SHORT).show();
                } else {
                    Intent levelsIntent = new Intent(LevelsActivity.this, TestActivity.class);
                    levelsIntent.putExtra(LevelPulsado, 6);
                    startActivity(levelsIntent);
                }
            }
        });
        boton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Hay que superar los anteriores niveles para poder jugar
                if(nivel < 5) {
                    String txtToast2 = "Su nivel es insuficente";
                    Toast.makeText(LevelsActivity.this, txtToast2, Toast.LENGTH_SHORT).show();
                } else {
                    Intent levelsIntent = new Intent(LevelsActivity.this, TestActivity.class);
                    levelsIntent.putExtra(LevelPulsado, 7);
                    startActivity(levelsIntent);
                }
            }
        });
        boton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Hay que superar los anteriores niveles para poder jugar
                if(nivel < 5) {
                    String txtToast2 = "Su nivel es insuficente";
                    Toast.makeText(LevelsActivity.this, txtToast2, Toast.LENGTH_SHORT).show();
                } else {
                    Intent levelsIntent = new Intent(LevelsActivity.this, TestActivity.class);
                    levelsIntent.putExtra(LevelPulsado, 8);
                    startActivity(levelsIntent);
                }
            }
        });
        boton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Hay que superar los anteriores niveles para poder jugar
                if(nivel < 5) {
                    String txtToast2 = "Su nivel es insuficente";
                    Toast.makeText(LevelsActivity.this, txtToast2, Toast.LENGTH_SHORT).show();
                } else {
                    Intent levelsIntent = new Intent(LevelsActivity.this, TestActivity.class);
                    levelsIntent.putExtra(LevelPulsado, 9);
                    startActivity(levelsIntent);
                }
            }
        });
        boton10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Hay que superar los anteriores niveles para poder jugar
                if(nivel < 10) {
                    String txtToast3 = "Su nivel es insuficente";
                    Toast.makeText(LevelsActivity.this, txtToast3, Toast.LENGTH_SHORT).show();
                } else {
                    Intent levelsIntent = new Intent(LevelsActivity.this, TestActivity.class);
                    levelsIntent.putExtra(LevelPulsado, 10);
                    startActivity(levelsIntent);
                }
            }
        });
    }

    private void actualizarHeaderNavigationDrawer() {

        // Referenciamos el navigation drawer
        NavigationView navigationView = findViewById(R.id.navigation_levels_nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // Recogemos la info compartida en el login - registro
        SharedPreferences infoPrincipal = getSharedPreferences("Contenido_principal", Context.MODE_PRIVATE);

        /* -------- Actualizar la información del navigation drawer según el login -------- */

        // Recuperamos la info almacenada
        String nombre_navigationDrawer = infoPrincipal.getString("nombre", "Nombre");
        String email_navigationDrawer = infoPrincipal.getString("email", "email@gmail.com");
        String genero_navigationDrawer = infoPrincipal.getString("genero", "Hombre");

        // Tomamos la referencia del header del navigation
        View header_navigation = navigationView.getHeaderView(0);

        // Tomamos la referencia de los diferentes campos del header
        ImageView imagen_header_navigation = header_navigation.findViewById(R.id.image_header_navigation_levels);
        TextView nombre_header_navigation = header_navigation.findViewById(R.id.name_header_navigation_levels);
        TextView email_header_navigation = header_navigation.findViewById(R.id.email_header_navigation_levels);

        // Asignamos la info almacenada a cada campo
        nombre_header_navigation.setText(nombre_navigationDrawer);
        email_header_navigation.setText(email_navigationDrawer);
        if(genero_navigationDrawer.equals("Mujer")) imagen_header_navigation.setImageResource(R.drawable.mujer_navigation_levels);
        else imagen_header_navigation.setImageResource(R.drawable.hombre_navigation_levels);

    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        if(id == R.id.score_menu) {
            Intent navigationIntent = new Intent(this, ScoreActivity.class);
            startActivity(navigationIntent);
        }

        return true;
    }
}
