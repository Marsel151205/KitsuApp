package com.example.kitsu.ui.fragments.manga

import com.example.kitsu.base.BaseViewModel
import com.example.kitsu.data.remote.apiservices.MangaApiService
import com.example.kitsu.data.repositories.MangaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MangaViewModel @Inject constructor(private val repository: MangaRepository) :
    BaseViewModel() {

    fun getMangaPagingData() = repository.getMangaPagingData()
}