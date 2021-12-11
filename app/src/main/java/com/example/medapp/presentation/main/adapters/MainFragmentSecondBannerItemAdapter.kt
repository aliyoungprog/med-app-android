package com.example.medapp.presentation.main.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.medapp.R
import com.example.medapp.domain.entity.MedCenter
import com.example.medapp.presentation.main.viewholders.MainFragmentSecondBannerViewHolder

class MainFragmentSecondBannerItemAdapter(val bannerList: List<MedCenter>) :
    RecyclerView.Adapter<MainFragmentSecondBannerViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MainFragmentSecondBannerViewHolder {
        val lInflater = LayoutInflater.from(parent.context)
            .inflate(R.layout.main_fragment_second_banner_item, parent, false)
        return MainFragmentSecondBannerViewHolder(lInflater)
    }

    override fun onBindViewHolder(holder: MainFragmentSecondBannerViewHolder, position: Int) {
        holder.bind(bannerList[position])
    }

    override fun getItemCount(): Int {
        return bannerList.size
    }
}
