package com.example.kitsu.data.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.kitsu.base.BaseRepository
import com.example.kitsu.data.remote.apiservices.MangaApiService
import javax.inject.Inject

class MangaRepository @Inject constructor(private val service: MangaApiService) : BaseRepository() {

    fun getMangaPagingData() = Pager(
        config = PagingConfig(
            pageSize = 10,
            enablePlaceholders = false,
            initialLoadSize = 2
        ),
        pagingSourceFactory = { MangaPagingSource(service) }, initialKey = 1
    ).flow

    fun fetchMangaById(id: String) = doRequest {
        service.fetchMangaById(id)
    }
}