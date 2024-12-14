package com.example.dampmdmtarea2cdva;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.dampmdmtarea2cdva.databinding.CharacterDetailFragmentBinding;
import com.google.android.material.snackbar.Snackbar;


/**
 * Fragmento que muestra los detalles de un personaje seleccionado, incluyendo su imagen, nombre, descripción y habilidades.
 */
public class CharacterDetailFragment extends Fragment {

    /**
     * Binding que permite acceder a los elementos del layout del fragmento.
     */
    private CharacterDetailFragmentBinding binding;

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
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflar el layout para este fragmento
        binding = CharacterDetailFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    /**
     * Método llamado después de que la vista ha sido creada. Obtiene los datos del argumento que inició este fragmento y
     * asigna esos datos a los componentes correspondientes en la vista.
     *
     * @param view               Vista del fragmento.
     * @param savedInstanceState Estado guardado del fragmento.
     */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Obtener datos del argumento que inicia este fragmento
        if (getArguments() != null) {
            // Cambiado a int para IDs de recurso
            int imageResId = getArguments().getInt("image");
            String name = getArguments().getString("name");
            String description = getArguments().getString("description");
            String skills = getArguments().getString("skills");

            // Asignar los datos a los componentes
            binding.image.setImageResource(imageResId);
            binding.name.setText(name);
            binding.description.setText(description);
            binding.skills.setText(skills);

            // Mostrar el Snackbar de personaje seleccionado
            String message = getString(R.string.character_selected, name);
            Snackbar.make(binding.getRoot(), message, Snackbar.LENGTH_LONG).show();
        }
    }

    /**
     * Método llamado cuando el fragmento se ha iniciado. Cambia el título del ActionBar para reflejar el detalle del personaje.
     */
    @Override
    public void onStart() {
        super.onStart();
        // Cambia el título del ActionBar
        if (getActivity() != null) {
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(R.string.characters_detail);
        }
    }
}
