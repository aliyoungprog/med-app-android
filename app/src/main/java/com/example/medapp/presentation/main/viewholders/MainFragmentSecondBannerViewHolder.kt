package com.example.medapp.presentation.main.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.medapp.domain.entity.MedCenter
import kotlinx.android.synthetic.main.main_fragment_second_banner_item.view.*

class MainFragmentSecondBannerViewHolder(val viewItem: View): RecyclerView.ViewHolder(viewItem) {
    fun bind(medCenter: MedCenter) {
        viewItem.banner_head_text_view.text = medCenter.name
        viewItem.banner_child_text_view.text = medCenter.address
    }
}
