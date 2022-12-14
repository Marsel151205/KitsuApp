package com.example.kitsu.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kitsu.databinding.ActivityMainBinding
import com.example.kitsu.ui.adapters.PagerAdapter
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val pagerAdapter = PagerAdapter(this)
        binding.viewPager.adapter = pagerAdapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "Manga"
                1 -> "Anime"

                else -> "Error"
            }
        }.attach()
    }
}