package com.example.medapp.presentation.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.medapp.domain.entity.MedServiceBanner
import kotlinx.android.synthetic.main.main_fragment_first_banner_item.view.*

class MainFragmentFirstBannerViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    fun bind(medServiceBanner: MedServiceBanner) {
        itemView.main_fragment_first_banner_item_text.text = medServiceBanner.name
    }
}
