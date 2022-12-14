package com.example.kitsu.ui.fragments.anime

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kitsu.R
import com.example.kitsu.base.BaseFragment
import com.example.kitsu.common.Resource
import com.example.kitsu.databinding.FragmentAnimeBinding
import com.example.kitsu.databinding.FragmentMangaBinding
import com.example.kitsu.ui.adapters.AnimeAdapter
import com.example.kitsu.ui.adapters.MangaAdapter
import com.example.kitsu.ui.fragments.manga.MangaViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AnimeFragment : BaseFragment<FragmentAnimeBinding, AnimeViewModel>(R.layout.fragment_anime) {

    override val binding by viewBinding(FragmentAnimeBinding::bind)
    override val viewModel: AnimeViewModel by viewModels()
    private val animeAdapter = AnimeAdapter()
    private var offset = 1

    override fun initialize() {
        setupRecyclerView()
    }

    override fun setupSubscribe() {
        subscribeToManga()
    }

    private fun setupRecyclerView() {
        binding.rvAnime.adapter = animeAdapter
    }

    private fun subscribeToManga() {
        lifecycleScope.launch {
            viewModel.getAnimePagingData().collect {
                lifecycleScope.launch {
                    animeAdapter.submitData(it)
                }
            }
        }
    }
}