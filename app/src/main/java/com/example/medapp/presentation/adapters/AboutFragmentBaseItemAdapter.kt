package com.example.medapp.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.medapp.R
import com.example.medapp.domain.entity.MedCenter
import com.example.medapp.presentation.viewholders.AboutFragmentBaseItemViewHolder

class AboutFragmentBaseItemAdapter(val itemList: List<MedCenter>,
private val onItemClickListener: (View) -> Unit): RecyclerView.Adapter<AboutFragmentBaseItemViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AboutFragmentBaseItemViewHolder {
        return AboutFragmentBaseItemViewHolder(
            LayoutInflater.from(parent.context)
            .inflate(R.layout.about_med_center_base_component, parent, false), onItemClickListener)
    }

    override fun onBindViewHolder(holder: AboutFragmentBaseItemViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}
