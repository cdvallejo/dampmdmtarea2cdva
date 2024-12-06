package com.example.dampmdmtarea2cdva;

import android.annotation.SuppressLint;

import androidx.recyclerview.widget.RecyclerView;
import com.example.dampmdmtarea2cdva.databinding.CharacterCardviewBinding;

// Clase para crear el ViewHolder
public class CharacterViewHolder extends RecyclerView.ViewHolder {

    private final CharacterCardviewBinding binding;

    public CharacterViewHolder(CharacterCardviewBinding binding) {
        // Llama al padre para hacer la construcción del ViewHolder
        super(binding.getRoot());
        this.binding = binding;
    }

    // Constructor que rellena los datos necesarios de cada personaje
    public void bind (CharacterData character) {
        binding.image.setImageResource(character.getImage());
        binding.name.setText(character.getName());
        binding.description.setText(character.getDescription());
        binding.skills.setText(character.getSkills());
        binding.executePendingBindings(); //Asegura que se apliquen los cambios de inmediato
    }
}
