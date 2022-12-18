package com.example.kitsu.ui.fragments.detailanime

import com.example.kitsu.base.BaseViewModel
import com.example.kitsu.data.repositories.AnimeRepository
import javax.inject.Inject

class DetailAnimeViewModel @Inject constructor(private val repository: AnimeRepository) :
    BaseViewModel() {

        fun fetchAnimeById(id: String) = repository.fetchAnimeById(id)

}