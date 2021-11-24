package com.example.medapp.presentation.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.medapp.domain.entity.MedCenter
import com.example.medapp.utils.setSafeClickListener
import kotlinx.android.synthetic.main.about_med_center_base_component.view.*

class AboutFragmentBaseItemViewHolder(itemView: View,
                                      private val onItemClicked: (View) -> Unit) : RecyclerView.ViewHolder(itemView) {
    fun bind(medCenter: MedCenter) {
        itemView.am_component_name_text_view.text = medCenter.name
        itemView.am_component_address_text_view.text = medCenter.address
        itemView.setSafeClickListener {
            onItemClicked.invoke(itemView)
        }
    }
}
