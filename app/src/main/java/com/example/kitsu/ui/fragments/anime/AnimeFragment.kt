package com.example.kitsu.ui.fragments.anime

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kitsu.R
import com.example.kitsu.base.BaseFragment
import com.example.kitsu.databinding.FragmentAnimeBinding
import com.example.kitsu.models.anime.AnimeModel
import com.example.kitsu.ui.adapters.AnimeAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AnimeFragment : BaseFragment<FragmentAnimeBinding, AnimeViewModel>(R.layout.fragment_anime) {

    override val binding by viewBinding(FragmentAnimeBinding::bind)
    override val viewModel: AnimeViewModel by viewModels()
    private val animeAdapter = AnimeAdapter()

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