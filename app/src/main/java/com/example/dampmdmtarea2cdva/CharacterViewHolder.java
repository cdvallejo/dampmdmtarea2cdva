package com.example.dampmdmtarea2cdva;

import android.annotation.SuppressLint;

import androidx.recyclerview.widget.RecyclerView;
import com.example.dampmdmtarea2cdva.databinding.CharacterCardviewBinding;

/**
 * ViewHolder para los elementos del RecyclerView que representan los personajes.
 * Mantiene una referencia al binding del layout de cada cardview de personaje.
 */
public class CharacterViewHolder extends RecyclerView.ViewHolder {

    /**
     * Binding del layout del cardview que representa un personaje.
     */
    private final CharacterCardviewBinding binding;

    /**
     * Constructor del ViewHolder que recibe el binding del cardview.
     * Llama al constructor de la clase base `RecyclerView.ViewHolder` pasando la raíz del layout.
     *
     * @param binding El binding del layout del cardview.
     */
    public CharacterViewHolder(CharacterCardviewBinding binding) {
        // Llama al constructor de la clase base pasando la vista raíz
        super(binding.getRoot());
        this.binding = binding;
    }

    /**
     * Método que enlaza los datos del personaje con el layout del cardview.
     * Este método se llama cuando el ViewHolder necesita mostrar los datos de un personaje específico.
     *
     * @param character El objeto CharacterData que contiene los datos del personaje.
     */
    public void bind(CharacterData character) {
        // Asigna la imagen y el nombre del personaje al cardview
        binding.image.setImageResource(character.getImage());
        binding.name.setText(character.getName());

        // Asegura que los cambios en el layout se apliquen inmediatamente
        binding.executePendingBindings();
    }
}
