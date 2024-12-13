package com.example.dampmdmtarea2cdva;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dampmdmtarea2cdva.databinding.ActivityMainBinding;

import java.util.Arrays;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

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
        if (item.getItemId() == R.id.action_settings) {
            Toast.makeText(
                    this,
                    "Aplicación de Carlos Vallejo para la Tarea 2 de PMDM",
                    Toast.LENGTH_LONG
            ).show();
            return true;
        } else {
                return super.onOptionsItemSelected(item);
            }
        }
}
