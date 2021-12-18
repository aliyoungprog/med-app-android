package com.example.medapp.presentation.main.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.medapp.R
import com.example.medapp.presentation.main.adapters.AboutFragmentPageAdapter
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_med_center_discription.*
import kotlinx.android.synthetic.main.image_carousel_view.carousel_view


class MedCenterDescriptionFragment : Fragment() {
    private val carouselView get() = carousel_view
    private val viewPagerAdapter get() = fmc_view_pager
    private val tabLayout get() = fmc_tab_layout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_med_center_discription, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initCarousel()
        initPager()
    }

    private fun initCarousel() {
        val imageList =
            listOf(R.drawable.ic_baseline_image_24, R.drawable.ic_baseline_health_and_safety_24)
        carouselView.setImageListener { position, imageView ->
            imageView.setImageResource(imageList[position])
        }
        carouselView.pageCount = imageList.size
    }

    private fun initPager() {
        viewPagerAdapter.adapter = AboutFragmentPageAdapter(this)
        TabLayoutMediator(tabLayout, viewPagerAdapter) { tab, position ->
            if (position == 0) tab.text = "Сотрудники"
            else tab.text = "Отзывы"
        }.attach()
    }
}
