package com.example.medapp.presentation.main.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.medapp.domain.entity.MedServiceBanner
import com.example.medapp.utils.setSafeClickListener
import kotlinx.android.synthetic.main.main_fragment_first_banner_item.view.*

class MainFragmentFirstBannerViewHolder(itemView: View,
                                        private val onBannerClicked: (MedServiceBanner) -> Unit
): RecyclerView.ViewHolder(itemView) {
    fun bind(medServiceBanner: MedServiceBanner) {
        itemView.main_fragment_first_banner_item_text.text = medServiceBanner.name
        itemView.setSafeClickListener {
            onBannerClicked.invoke(medServiceBanner)
        }
    }
}
