package com.example.kitsu.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.example.kitsu.base.BaseDiffUtilItemCallback
import com.example.kitsu.databinding.ItemAnimeBinding
import com.example.kitsu.models.anime.AnimeModel

class AnimeAdapter :
PagingDataAdapter<AnimeModel, AnimeAdapter.AnimeViewHolder>(BaseDiffUtilItemCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder =
        AnimeViewHolder(
            ItemAnimeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
        holder.onBind(getItem(position)!!)
    }

    inner class AnimeViewHolder(private val binding: ItemAnimeBinding) : ViewHolder(binding.root) {
        fun onBind(model: AnimeModel) {
            binding.ivAnimePoster.load(model.attributes.posterImage.small)

            setupView(model)

        }

        private fun setupView(model: AnimeModel) {
            if (binding.tvAnimeTitle.maxLines != 1) {
                binding.tvAnimeTitle.maxLines = 1
                binding.tvAnimeTitle.text = model.attributes.canonicalTitle + "..."
            } else binding.tvAnimeTitle.text = model.attributes.canonicalTitle
        }
    }
}
