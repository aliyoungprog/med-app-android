package com.example.medapp.presentation.main.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.medapp.domain.entity.MedService
import kotlinx.android.synthetic.main.services_item_view.view.*

class ServiceItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    fun bind(medService: MedService) {
        itemView.service_item_txt.text = medService.serviceName.toString()
    }
}
