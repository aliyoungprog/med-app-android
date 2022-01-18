package com.example.medapp.presentation.main.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.medapp.domain.entity.MedCenter
import com.example.medapp.utils.setSafeClickListener
import kotlinx.android.synthetic.main.about_med_center_base_component.view.*

class AboutFragmentBaseItemViewHolder(
    itemView: View,
    private val onMedCenterClicked: (MedCenter) -> Unit,
    private val onWriteClicked: (MedCenter) -> Unit
) : RecyclerView.ViewHolder(itemView) {
    fun bind(medCenter: MedCenter) {
        itemView.am_component_name_text_view.text = medCenter.name
        itemView.am_component_address_text_view.text = medCenter.address
        itemView.setSafeClickListener {
            onMedCenterClicked.invoke(medCenter)
        }
        itemView.am_component_buttons_registration.setSafeClickListener {
            onMedCenterClicked.invoke(medCenter)
        }
        itemView.am_component_buttons_write.setSafeClickListener {
            onWriteClicked.invoke(medCenter)
        }
    }
}

