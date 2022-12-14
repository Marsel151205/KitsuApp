package com.example.kitsu.data.repositories

import android.net.Uri
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.kitsu.data.remote.apiservices.AnimeApiService
import com.example.kitsu.data.remote.apiservices.MangaApiService
import com.example.kitsu.models.anime.AnimeModel
import com.example.kitsu.models.manga.MangaModel
import retrofit2.HttpException
import java.io.IOException

class AnimePagingSource(
    private val animeApiService: AnimeApiService
) : PagingSource<Int, AnimeModel>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, AnimeModel> {
        val page = params.key ?: 20
        return try {
            val response = animeApiService.fetchAnime(params.loadSize, page)
            val nextPage = Uri.parse(response.links.next).getQueryParameter("page[offset]")!!.toInt()
            LoadResult.Page(
                data = response.data,
                prevKey = null, nextKey = nextPage
            )

        } catch (io: IOException) {
            LoadResult.Error(io)
        } catch (http: HttpException) {
            LoadResult.Error(http)
        }
    }


    override fun getRefreshKey(state: PagingState<Int, AnimeModel>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}