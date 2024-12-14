package com.example.dampmdmtarea2cdva;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.dampmdmtarea2cdva.databinding.CharacterListFragmentBinding;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class CharacterListFragment extends Fragment {

    private CharacterListFragmentBinding binding; // Binding para el layout
    private ArrayList<CharacterData> characters; // Lista de juegos
    private CharacterRecyclerViewAdapter adapter; // Adaptador del RecyclerView

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflar el layout utilizando el binding
        binding = CharacterListFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Inicializa la lista de juegos
        loadCharacters(); // Cargar los juegos (puedes implementar esta función para obtener datos)

        // Configurar el RecyclerView
        adapter = new CharacterRecyclerViewAdapter(characters, getActivity());
        binding.charactersRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.charactersRecyclerview.setAdapter(adapter);

        // Mostrar el Snackbar de bienvenida cuando se carga la lista
        Snackbar.make(binding.getRoot(), R.string.welcome_message, Snackbar.LENGTH_LONG).show();
    }

    // Método para cargar personajes (multiidioma)
    private void loadCharacters() {
        characters = new ArrayList<>();

        // Llenar la lista con datos de videojuegos usando recursos de strings
        characters.add(new CharacterData(
                R.drawable.mario,
                getString(R.string.character_mario_name),
                getString(R.string.character_mario_description),
                getString(R.string.character_mario_skill)
        ));

        characters.add(new CharacterData(
                R.drawable.luigi,
                getString(R.string.character_luigi_name),
                getString(R.string.character_luigi_description),
                getString(R.string.character_luigi_skill)
        ));

        characters.add(new CharacterData(
                R.drawable.peach,
                getString(R.string.character_peach_name),
                getString(R.string.character_peach_description),
                getString(R.string.character_peach_skill)
        ));

        characters.add(new CharacterData(
                R.drawable.toad,
                getString(R.string.character_toad_name),
                getString(R.string.character_toad_description),
                getString(R.string.character_toad_skill)
        ));

    }

    @Override
    public void onStart() {
        super.onStart();
        // Cambia el título del ActionBar
        if (getActivity() != null) {
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(R.string.characters_list);
        }
    }
}
