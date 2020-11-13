package com.rockbass2560.rickandmortyapp.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.rockbass2560.rickandmortyapp.models.CharacterView
import com.rockbass2560.rickandmortyapp.models.Episode
import com.rockbass2560.rickandmortyapp.models.Results
import com.rockbass2560.rickandmortyapp.repositories.RickAndMortyRepository
import kotlinx.coroutines.launch

class ViewModelEpisode (application: Application) : AndroidViewModel(application) {

    val rickAndMortyListLiveData = MutableLiveData<Episode>()
    private val rickAndMortyRepository = RickAndMortyRepository();
    val liveDataCharactares = MutableLiveData<List<Results>>()


    fun getEpisode(url: String) {
            viewModelScope.launch {
                var episode = rickAndMortyRepository.getEpisodeByUrl(url)
                rickAndMortyListLiveData.postValue(episode)
            }
    }

    fun getCharactersByEpisode(urls : List<String>){
        viewModelScope.launch {
            var lista = urls.map{url -> rickAndMortyRepository.getCharacterByUrl(url)}
            liveDataCharactares.postValue(lista)
        }
    }
}
