package com.rockbass2560.rickandmortyapp.models

data class EpisodeView (
    val name : String,
    val episode : String,
    val characters : List<String>,
    val date : String
)
