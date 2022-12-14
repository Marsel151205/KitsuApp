package com.example.kitsu.ui.fragments.manga

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
import com.example.kitsu.databinding.FragmentMangaBinding
import com.example.kitsu.ui.adapters.MangaAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MangaFragment : BaseFragment<FragmentMangaBinding, MangaViewModel>(R.layout.fragment_manga) {

    override val binding by viewBinding(FragmentMangaBinding::bind)
    override val viewModel: MangaViewModel by viewModels()
    private val mangaAdapter = MangaAdapter()

    override fun initialize() {
        setupRecyclerView()
    }

    override fun setupSubscribe() {
        subscribeToManga()
    }

    private fun setupRecyclerView() {
        binding.rvManga.adapter = mangaAdapter

    }

    private fun subscribeToManga() {
        lifecycleScope.launch {
            viewModel.getMangaPagingData().collect {
                lifecycleScope.launch {
                    mangaAdapter.submitData(it)
                }
            }
        }
    }
}