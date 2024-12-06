package com.example.dampmdmtarea2cdva;

import android.os.Bundle;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dampmdmtarea2cdva.databinding.ActivityMainBinding;

import java.util.Arrays;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Inflar el layout con ViewBinding
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Definir el LayoutManager, en este caso un LinearLayoutManager para la lista
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Lista de items
        List<CharacterData> characters = Arrays.asList(
                new CharacterData(R.drawable.mario, "Mario", "Fontanero y héroe del Reino Champiñón", "Es capaz de saltar muy alto"),
                new CharacterData(R.drawable.luigi, "Luigi", "Hermano de Mario", "Aunque es un poco miedica, salta también muy alto"),
                new CharacterData(R.drawable.peach, "Peach", "Princesa del Reino Champiñón", "Posee habilidades mágicas"),
                new CharacterData(R.drawable.toad, "Toad", "Consejero de la princesa Peach", "Aunque no lo pareca, tiene una fuerza extraordinaria")
        );

        // Asignar el adaptador al RecyclerView
        binding.recyclerView.setAdapter(new RecyclerViewAdapter(characters));
    }
}
