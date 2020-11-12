package com.rockbass2560.rickandmortyapp.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.rockbass2560.rickandmortyapp.models.CharacterView
import com.rockbass2560.rickandmortyapp.models.Episode
import com.rockbass2560.rickandmortyapp.repositories.RickAndMortyRepository
import kotlinx.coroutines.launch

class ViewModelEpisode (application: Application) : AndroidViewModel(application) {

    val rickAndMortyListLiveData = MutableLiveData<List<Episode>>()
    private val rickAndMortyRepository = RickAndMortyRepository();

    fun getEpisode(url: String) {
            viewModelScope.launch {
                var listEpisodio = mutableListOf<Episode>()
                listEpisodio.add(rickAndMortyRepository.getEpisodeByUrl(url))
                rickAndMortyListLiveData.postValue(listEpisodio)
            }
    }

}
