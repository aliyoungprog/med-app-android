package com.example.medapp.presentation.main.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.medapp.R
import kotlinx.android.synthetic.main.image_carousel_view.*


class MedCenterDescriptionFragment : Fragment() {
    private val carouselView get() = carousel_view

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_med_center_discription, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initCarousel()
    }

    private fun initCarousel() {
        val imageList = listOf(R.drawable.ic_baseline_image_24, R.drawable.ic_baseline_health_and_safety_24)
        carouselView.setImageListener { position, imageView ->
            imageView.setImageResource(imageList[position])
        }
        carouselView.pageCount = imageList.size
    }
}
