package com.example.medapp.presentation.main.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.medapp.R
import com.example.medapp.domain.entity.MedService
import com.example.medapp.presentation.main.viewholders.ServiceItemViewHolder

class ServiceItemAdapter(private val listOfServices: List<MedService>) :
    RecyclerView.Adapter<ServiceItemViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ServiceItemViewHolder {
        return ServiceItemViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.services_item_view, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ServiceItemViewHolder, position: Int) {
        holder.bind(listOfServices[position])
    }

    override fun getItemCount() = listOfServices.size
}
