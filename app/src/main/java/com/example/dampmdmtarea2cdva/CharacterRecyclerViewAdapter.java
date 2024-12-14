package com.example.dampmdmtarea2cdva;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dampmdmtarea2cdva.databinding.CharacterCardviewBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Adaptador para el RecyclerView que muestra la lista de personajes.
 * Cada elemento de la lista es un objeto de tipo CharacterData.
 */
public class CharacterRecyclerViewAdapter extends RecyclerView.Adapter<CharacterViewHolder> {

    /**
     * Lista que contiene los datos de los personajes.
     */
    private final ArrayList<CharacterData> characters;

    /**
     * Contexto de la aplicación, utilizado para interactuar con la actividad que contiene el RecyclerView.
     */
    private final Context context;

    /**
     * Constructor del adaptador que recibe una lista de personajes y el contexto.
     *
     * @param characters Lista de personajes a mostrar.
     * @param context    Contexto de la aplicación, generalmente la actividad que contiene el RecyclerView.
     */
    public CharacterRecyclerViewAdapter(ArrayList<CharacterData> characters, Context context) {
        this.characters = characters;
        this.context = context;
    }

    /**
     * Método llamado para crear el ViewHolder que mantiene las vistas para cada elemento del RecyclerView.
     * Este ViewHolder se utiliza para representar un elemento de la lista de personajes.
     *
     * @param parent   El ViewGroup donde el ViewHolder será insertado.
     * @param viewType El tipo de la vista (en este caso, solo existe un tipo de vista).
     * @return Un nuevo ViewHolder con el binding inflado para el cardview de personaje.
     */
    @NonNull
    @Override
    public CharacterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Infla el layout de un cardview para cada elemento de la lista
        CharacterCardviewBinding binding = CharacterCardviewBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false
        );
        return new CharacterViewHolder(binding);
    }

    /**
     * Método llamado para enlazar los datos del personaje con las vistas del ViewHolder.
     * Este método se ejecuta cada vez que un ViewHolder necesita mostrar un nuevo personaje.
     *
     * @param holder   El ViewHolder donde se deben enlazar los datos.
     * @param position La posición en la lista de personajes que se debe mostrar.
     */
    @Override
    public void onBindViewHolder(@NonNull CharacterViewHolder holder, int position) {
        CharacterData currentCharacter = this.characters.get(position);
        holder.bind(currentCharacter);

        // Maneja el evento de clic en el item
        holder.itemView.setOnClickListener(view -> itemClicked(currentCharacter, view));
    }

    /**
     * Método que devuelve la cantidad de elementos en la lista de personajes.
     *
     * @return El tamaño de la lista de personajes.
     */
    @Override
    public int getItemCount() {
        return characters.size();
    }

    /**
     * Método que maneja el clic en un personaje, llamando a un método en la actividad principal
     * para manejar el clic y pasar los datos del personaje.
     *
     * @param currentCharacter El personaje que fue clickeado.
     * @param view             La vista donde ocurrió el clic.
     */
    private void itemClicked(CharacterData currentCharacter, View view) {
        // Llama a la función gameClicked de MainActivity, pasando el personaje y la vista
        ((MainActivity) context).gameClicked(currentCharacter, view);
    }
}
