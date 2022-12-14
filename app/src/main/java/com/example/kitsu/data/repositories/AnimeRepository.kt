package com.example.kitsu.data.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.kitsu.base.BaseRepository
import com.example.kitsu.data.remote.apiservices.AnimeApiService
import javax.inject.Inject

class AnimeRepository @Inject constructor(private val service: AnimeApiService): BaseRepository() {

    fun getAnimePagingData() = Pager(
        config = PagingConfig(
            pageSize = 10,
            enablePlaceholders = false,
            initialLoadSize = 2
        ),
        pagingSourceFactory = { AnimePagingSource(service) }, initialKey = 1
    ).flow
}