package com.rockbass2560.rickandmortyapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rockbass2560.rickandmortyapp.R
import com.rockbass2560.rickandmortyapp.databinding.CardCharacterBinding
import com.rockbass2560.rickandmortyapp.databinding.CardPersonajeEpisodioBinding
import com.rockbass2560.rickandmortyapp.models.CharacterView
import com.rockbass2560.rickandmortyapp.models.Results

class Episode_CharacterAdapter (val listResults : List<Results>): RecyclerView.Adapter<Episode_CharacterAdapter.Episode_CharacterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Episode_CharacterViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cardPersonajeEpisodioBinding = CardPersonajeEpisodioBinding.inflate(layoutInflater, parent, false)
        return Episode_CharacterViewHolder(cardPersonajeEpisodioBinding)
    }

    override fun onBindViewHolder(holder: Episode_CharacterViewHolder, position: Int) {
        var results = listResults[position]
        holder.onBind(results)
    }

    override fun getItemCount(): Int {
        return listResults.size;
    }

    inner class Episode_CharacterViewHolder(private val cardPersonajeEpisodioBinding: CardPersonajeEpisodioBinding) :
        RecyclerView.ViewHolder(cardPersonajeEpisodioBinding.root){

        fun onBind(results : Results){
            cardPersonajeEpisodioBinding.character = results
            cardPersonajeEpisodioBinding.executePendingBindings()
        }
    }


}