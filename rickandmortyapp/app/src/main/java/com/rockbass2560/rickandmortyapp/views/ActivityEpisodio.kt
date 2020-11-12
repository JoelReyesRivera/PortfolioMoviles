package com.rockbass2560.rickandmortyapp.views

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import com.rockbass2560.rickandmortyapp.BASE_URL
import com.rockbass2560.rickandmortyapp.R
import com.rockbass2560.rickandmortyapp.models.CharacterView
import com.rockbass2560.rickandmortyapp.models.Episode
import com.rockbass2560.rickandmortyapp.repositories.RickAndMortyRepository
import com.rockbass2560.rickandmortyapp.viewmodels.MainActivityViewModel
import com.rockbass2560.rickandmortyapp.viewmodels.ViewModelEpisode

class ActivityEpisodio: AppCompatActivity() {

    val viewModelEpisode : ViewModelEpisode by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.card_episodio)
        var id: String? = intent.extras?.getString("episodeName")
        val url = BASE_URL + "episode/" + id

        viewModelEpisode.getEpisode(url)
        val data = viewModelEpisode.rickAndMortyListLiveData
    }
}