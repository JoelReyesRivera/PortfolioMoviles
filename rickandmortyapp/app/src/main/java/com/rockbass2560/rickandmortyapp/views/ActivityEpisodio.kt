package com.rockbass2560.rickandmortyapp.views

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.rockbass2560.rickandmortyapp.BASE_URL
import com.rockbass2560.rickandmortyapp.R
import com.rockbass2560.rickandmortyapp.adapters.Episode_CharacterAdapter
import com.rockbass2560.rickandmortyapp.databinding.CardEpisodioBinding
import com.rockbass2560.rickandmortyapp.databinding.CardPersonajeEpisodioBinding
import com.rockbass2560.rickandmortyapp.models.CharacterView
import com.rockbass2560.rickandmortyapp.models.Episode
import com.rockbass2560.rickandmortyapp.models.Results
import com.rockbass2560.rickandmortyapp.repositories.RickAndMortyRepository
import com.rockbass2560.rickandmortyapp.viewmodels.MainActivityViewModel
import com.rockbass2560.rickandmortyapp.viewmodels.ViewModelEpisode

class ActivityEpisodio: AppCompatActivity() {

    val viewModelEpisode : ViewModelEpisode by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val cardEpisodioBinding = CardEpisodioBinding.inflate(layoutInflater)
        setContentView(cardEpisodioBinding.root)
        var id: String? = intent.extras?.getString("episodeName")
        val url = BASE_URL + "episode/" + id
        viewModelEpisode.getEpisode(url)

        viewModelEpisode.rickAndMortyListLiveData.observe(this,
            Observer<Episode> { episode ->
                cardEpisodioBinding.episode = episode
                viewModelEpisode.getCharactersByEpisode(episode.characters)
            })

        val recyclerView = cardEpisodioBinding.recylerPersonajes
        recyclerView.layoutManager = LinearLayoutManager(this)

        viewModelEpisode.liveDataCharactares.observe(this, Observer<List<Results>> {personajes ->
            val adapter = Episode_CharacterAdapter(personajes)
            recyclerView.adapter=adapter
            adapter.notifyDataSetChanged()
        })
    }
}