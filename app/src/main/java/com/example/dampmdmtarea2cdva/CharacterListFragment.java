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

/**
 * Fragmento que muestra una lista de personajes, con sus imágenes, nombres, descripciones y habilidades.
 * También muestra un mensaje de bienvenida cuando se carga la lista.
 */
public class CharacterListFragment extends Fragment {

    /**
     * Binding que permite acceder a los elementos del layout del fragmento.
     */
    private CharacterListFragmentBinding binding;

    /**
     * Lista que contiene los datos de los personajes.
     */
    private ArrayList<CharacterData> characters;

    /**
     * Adaptador para el RecyclerView que muestra los personajes.
     */
    private CharacterRecyclerViewAdapter adapter;

    /**
     * Método llamado para crear la vista del fragmento. Infla el layout del fragmento utilizando el binding.
     *
     * @param inflater           Inflador de vistas.
     * @param container          Contenedor al que se agregará la vista.
     * @param savedInstanceState Estado guardado del fragmento.
     * @return Vista inflada para el fragmento.
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflar el layout utilizando el binding
        binding = CharacterListFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    /**
     * Método llamado después de que la vista ha sido creada. Inicializa la lista de personajes, configura el RecyclerView
     * y muestra un mensaje de bienvenida utilizando un Snackbar.
     *
     * @param view               Vista del fragmento.
     * @param savedInstanceState Estado guardado del fragmento.
     */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Inicializa la lista de personajes
        loadCharacters();

        // Configurar el RecyclerView
        adapter = new CharacterRecyclerViewAdapter(characters, getActivity());
        binding.charactersRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.charactersRecyclerview.setAdapter(adapter);

        // Mostrar el Snackbar de bienvenida cuando se carga la lista
        Snackbar.make(binding.getRoot(), R.string.welcome_message, Snackbar.LENGTH_LONG).show();
    }

    /**
     * Método que carga los personajes en la lista utilizando recursos de strings para obtener la información
     * de cada personaje (nombre, descripción y habilidades).
     */
    private void loadCharacters() {
        characters = new ArrayList<>();

        // Llenar la lista con datos de personajes
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

    /**
     * Método llamado cuando el fragmento se ha iniciado. Cambia el título del ActionBar para reflejar la lista de personajes.
     */
    @Override
    public void onStart() {
        super.onStart();
        // Cambia el título del ActionBar
        if (getActivity() != null) {
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(R.string.characters_list);
        }
    }
}
