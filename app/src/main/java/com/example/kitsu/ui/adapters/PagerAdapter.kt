package com.example.kitsu.ui.adapters

import android.content.res.Resources
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.kitsu.ui.fragments.anime.AnimeFragment
import com.example.kitsu.ui.fragments.auth.AuthFragment
import com.example.kitsu.ui.fragments.manga.MangaFragment

class PagerAdapter(fm: Fragment) : FragmentStateAdapter(fm) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> MangaFragment()
            1 -> AnimeFragment()
            else -> {throw Resources.NotFoundException("Position Not Found")}
        }
    }
}