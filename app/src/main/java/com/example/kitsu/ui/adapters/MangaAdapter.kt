package com.example.kitsu.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.example.kitsu.base.BaseDiffUtilItemCallback
import com.example.kitsu.databinding.ItemMangaBinding
import com.example.kitsu.models.manga.MangaModel

class MangaAdapter :
    PagingDataAdapter<MangaModel, MangaAdapter.MangaViewHolder>(BaseDiffUtilItemCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MangaViewHolder(
        ItemMangaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: MangaViewHolder, position: Int) {
        holder.onBind(getItem(position)!!)
    }

    class MangaViewHolder(private val binding: ItemMangaBinding) : ViewHolder(binding.root) {
        fun onBind(model: MangaModel) {
            with(binding) {
                ivMangaPoster.load(model.attributes.posterImage.small)
            }

            setupView(model)
        }

        private fun setupView(model: MangaModel) {
            if (binding.tvMangaTitle.maxLines != 1) {
                binding.tvMangaTitle.maxLines = 1
                binding.tvMangaTitle.text = model.attributes.canonicalTitle + "..."
            } else binding.tvMangaTitle.text = model.attributes.canonicalTitle
        }
    }
}