package com.example.medapp.presentation.main.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.medapp.R
import com.example.medapp.domain.entity.MedDoctor
import com.example.medapp.domain.entity.MedServiceBanner
import com.example.medapp.presentation.main.viewholders.MainFragmentFirstBannerViewHolder

class MainFragmentFirstBannerItemAdapter(
    private val listOfBanners: List<MedServiceBanner>,
    private val onBannerClicked: (MedServiceBanner) -> Unit
):
    RecyclerView.Adapter<MainFragmentFirstBannerViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MainFragmentFirstBannerViewHolder {
        return MainFragmentFirstBannerViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.main_fragment_first_banner_item, parent, false),
            onBannerClicked
        )
    }

    override fun onBindViewHolder(holder: MainFragmentFirstBannerViewHolder, position: Int) {
        holder.bind(listOfBanners[position])
    }

    override fun getItemCount() = listOfBanners.size
}
