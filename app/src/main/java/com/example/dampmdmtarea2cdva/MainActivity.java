package com.example.dampmdmtarea2cdva;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.dampmdmtarea2cdva.databinding.ActivityMainBinding;

import java.util.Locale;

/**
 * Actividad principal que maneja la navegación entre fragmentos y la configuración de la interfaz de usuario.
 * Esta actividad maneja el cambio de idioma y la interacción con los elementos del menú.
 */
public class MainActivity extends AppCompatActivity {

    /**
     * Controlador de navegación utilizado para gestionar la navegación entre fragmentos.
     */
    private NavController navController;

    private ActionBarDrawerToggle toggle;
    private Object binding;

    /**
     * Se llama cuando la actividad es creada.
     * Inicializa la interfaz de usuario, configura el NavController y detecta el idioma del dispositivo.
     *
     * @param savedInstanceState El estado guardado de la actividad, si existe.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Detecta el idioma del dispositivo
        Locale currentLocale = getResources().getConfiguration().locale;
        Log.d("Language", "Current device language: " + currentLocale.getLanguage());

        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Configura el NavController para la navegación
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController);

        // Configurar el icono del menú en la ActionBar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    /**
     * Maneja el clic en un personaje de la lista y navega al detalle del personaje.
     * Pasa los datos del personaje al fragmento de detalles mediante un Bundle.
     *
     * @param character El objeto que contiene los datos del personaje seleccionado.
     * @param view La vista sobre la que se hizo clic.
     */
    public void gameClicked(CharacterData character, View view) {
        // Crear un Bundle para pasar los datos al CharacterDetailFragment
        Bundle bundle = new Bundle();
        bundle.putInt("image", character.getImage()); // Pasa la imagen del personaje
        bundle.putString("name", character.getName()); // Pasa el nombre del personaje
        bundle.putString("description", character.getDescription()); // Pasa la descripción del personaje
        bundle.putString("skill", character.getSkills()); // Pasa las habilidades del personaje

        // Navegar al CharacterDetailFragment con el Bundle
        Navigation.findNavController(view).navigate(R.id.characterDetailFragment, bundle);
    }

    /**
     * Permite la navegación hacia atrás en el ActionBar.
     *
     * @return true si la navegación fue exitosa, false si no.
     */
    @Override
    public boolean onSupportNavigateUp() {
        return navController.navigateUp() || super.onSupportNavigateUp();
    }

    /**
     * Infla el menú en la ActionBar de la actividad.
     *
     * @param menu El objeto del menú que será inflado.
     * @return true si el menú fue inflado correctamente.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    /**
     * Maneja la selección de un ítem del menú en la ActionBar.
     *
     * @param item El ítem del menú seleccionado.
     * @return true si el ítem fue manejado correctamente.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_about) {
            Toast.makeText(
                    this,
                    R.string.about_text,
                    Toast.LENGTH_LONG
            ).show();
            return true;
        } else if (item.getItemId() == R.id.action_change_language) {
            changeLanguage();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    /**
     * Cambia el idioma de la aplicación entre español e inglés.
     * Actualiza la configuración de idioma y reinicia la actividad para aplicar el cambio.
     */
    private void changeLanguage() {
        // Obtener el idioma actual del dispositivo
        Locale currentLocale = getResources().getConfiguration().locale;

        // Cambiar al otro idioma (si es español, cambiar a inglés, y viceversa)
        Locale newLocale = currentLocale.getLanguage().equals("es") ? new Locale("en") : new Locale("es");

        // Cambiar la configuración de idioma
        Locale.setDefault(newLocale);
        Configuration config = new Configuration();
        config.setLocale(newLocale);

        // Usar el método recomendado para cambiar el idioma sin usar APIs obsoletas
        Context context = createConfigurationContext(config);

        // Aplicar el contexto actualizado
        getResources().updateConfiguration(config, getResources().getDisplayMetrics());

        // Reiniciar la actividad para aplicar el nuevo idioma
        recreate();
    }
}
