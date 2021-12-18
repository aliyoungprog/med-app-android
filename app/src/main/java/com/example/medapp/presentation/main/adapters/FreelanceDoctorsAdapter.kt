package com.example.medapp.presentation.main.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.medapp.R
import com.example.medapp.domain.entity.MedDoctor
import com.example.medapp.presentation.main.viewholders.FreelanceDoctorViewHolder


class FreelanceDoctorsAdapter(
    private val itemList: List<MedDoctor>,
    private val onDoctorClicked: (MedDoctor) -> Unit
) : RecyclerView.Adapter<FreelanceDoctorViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FreelanceDoctorViewHolder {
        return FreelanceDoctorViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.freelance_doctor_view, parent, false),
            onDoctorClicked
        )
    }

    override fun onBindViewHolder(holder: FreelanceDoctorViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}
