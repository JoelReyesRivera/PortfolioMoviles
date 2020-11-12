package com.rockbass2560.rickandmortyapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rockbass2560.rickandmortyapp.R
import com.rockbass2560.rickandmortyapp.databinding.CardCharacterBinding
import com.rockbass2560.rickandmortyapp.databinding.CardPersonajeEpisodioBinding
import com.rockbass2560.rickandmortyapp.models.CharacterView
import com.rockbass2560.rickandmortyapp.models.Results

class Episode_CharacterAdapter (val listCharacters : List<CharacterView>): RecyclerView.Adapter<Episode_CharacterAdapter.Episode_CharacterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Episode_CharacterViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cardPersonajeEpisodioBinding = CardPersonajeEpisodioBinding.inflate(layoutInflater, parent, false)
        return Episode_CharacterViewHolder(cardPersonajeEpisodioBinding)
    }

    override fun onBindViewHolder(holder: Episode_CharacterViewHolder, position: Int) {
        var characterView = listCharacters[position]
        holder.onBind(characterView)
    }

    override fun getItemCount(): Int {
        return listCharacters.size;
    }

    inner class Episode_CharacterViewHolder(private val cardPersonajeEpisodioBinding: CardPersonajeEpisodioBinding) :
        RecyclerView.ViewHolder(cardPersonajeEpisodioBinding.root){

        fun onBind(characterView: CharacterView){
            cardPersonajeEpisodioBinding.character = characterView
            cardPersonajeEpisodioBinding.executePendingBindings()
        }
    }


}