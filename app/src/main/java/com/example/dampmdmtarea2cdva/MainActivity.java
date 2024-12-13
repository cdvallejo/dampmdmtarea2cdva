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

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.dampmdmtarea2cdva.databinding.ActivityMainBinding;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Detecta el idioma del dispositivo
        Locale currentLocale = getResources().getConfiguration().locale;
        Log.d("Language", "Current device language: " + currentLocale.getLanguage());

        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Configura el NavController
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController);
    }

    // Método para manejar el clic en un personaje
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

    @Override
    public boolean onSupportNavigateUp() {
        // Utiliza el método navigateUp del NavController
        return navController.navigateUp() || super.onSupportNavigateUp();
    }

    // Inflar el menú en la ActionBar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    // Manejar la selección de elementos del menú
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
