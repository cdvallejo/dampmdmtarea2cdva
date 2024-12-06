package com.example.dampmdmtarea2cdva;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dampmdmtarea2cdva.databinding.CharacterCardviewBinding;

import java.util.ArrayList;
import java.util.List;

public class CharacterRecyclerViewAdapter extends RecyclerView.Adapter<CharacterViewHolder> {

    // ArrayList con los personajes guardados
    private final ArrayList<CharacterData> characters;
    private final Context context;

    // Constructor del Adaptador que rellena el ArrayList de los datos a guardar
    public CharacterRecyclerViewAdapter (ArrayList<CharacterData> characters, Context context) {
        this.characters = characters;
        this.context = context;
    }

    // Método que crea el ViewHolder
    @NonNull
    @Override
    public CharacterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CharacterCardviewBinding binding = CharacterCardviewBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false
        );
        return new CharacterViewHolder(binding);
    }

    // Método para enlazar datos con el ViewHolder según la posición que viene
    @Override
    public void onBindViewHolder(@NonNull CharacterViewHolder holder, int position) {
        CharacterData currentCharacter = this.characters.get(position);
        holder.bind(currentCharacter);
    }

    @Override
    public int getItemCount() {
        return characters.size();
    }
}
