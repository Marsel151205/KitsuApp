package com.example.kitsu.ui.fragments.detailanime

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kitsu.R
import com.example.kitsu.base.BaseFragment
import com.example.kitsu.databinding.FragmentDetailAnimeBinding

class DetailAnimeFragment : BaseFragment<FragmentDetailAnimeBinding, DetailAnimeViewModel>(R.layout.fragment_detail_anime) {

    override val binding by viewBinding(FragmentDetailAnimeBinding::bind)
    override val viewModel: DetailAnimeViewModel by viewModels()

    override fun initialize() {
        setupView()
    }

    override fun setupSubscribe() {
        subscribeToFetchAnimeById()
    }

    private fun setupView() {

    }

    private fun subscribeToFetchAnimeById() {

    }
}
