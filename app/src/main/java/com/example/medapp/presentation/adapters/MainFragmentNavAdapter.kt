package com.example.medapp.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.medapp.R
import com.example.medapp.domain.entity.MedService
import com.example.medapp.presentation.viewholders.MainFragmentNavViewHolder

class MainFragmentNavAdapter(val listOfServices: List<MedService>) : RecyclerView.Adapter<MainFragmentNavViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainFragmentNavViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.main_fragment_nav_item, parent, false)
        return MainFragmentNavViewHolder(itemView = itemView)
    }

    override fun onBindViewHolder(holder: MainFragmentNavViewHolder, position: Int) {

    }

    override fun getItemCount() = listOfServices.size

}
