package com.gidw.luis.quiz;

import android.content.SharedPreferences;
import android.content.Context;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class LevelsActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    // Para indicar el botón pulsado en la siguiente pagina
    public final static String LevelPulsado = "com.gidw.luis.quiz.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_levels);

        /* -------- Inicialización de los componentes de la vista -------- */
        Toolbar toolbar_appbar = findViewById(R.id.toolbar_appbar_navigation_levels);
        //setSupportActionBar(toolbar_appbar);
        DrawerLayout drawer_navigation = findViewById(R.id.navigation_levels);
        //ActionBarDrawerToggle toggleDrawer = new ActionBarDrawerToggle(this, drawer_navigation, toolbar_appbar, R.string.openToggle, R.string.closeToggle);
        //toggleDrawer.syncState();

        /* -------- Actualizar la información del navigation drawer según el login -------- */
        actualizarHeaderNavigationDrawer();

        /* -------- Declaramos los diferentes botones -------- */
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

    private void actualizarHeaderNavigationDrawer() {

        // Referenciamos el navigation drawer
        NavigationView navigationView = findViewById(R.id.navigation_levels_nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // Recogemos la info compartida en el login - registro
        SharedPreferences infoPrincipal = getSharedPreferences("Contenido_principal", Context.MODE_PRIVATE);
        //SharedPreferences sp = getSharedPreferences("Score", Context.MODE_PRIVATE);

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

        if(id == R.id.about_us_menu) {
            Intent navigationIntent = new Intent(this, AboutUs.class);
            startActivity(navigationIntent);
        }

        // Cerramos el Drawer
        DrawerLayout drawer_navigation = findViewById(R.id.navigation_levels);
        drawer_navigation.closeDrawer(GravityCompat.START);
        return true;
    }
}
