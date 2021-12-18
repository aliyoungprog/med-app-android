package com.example.medapp.presentation.main.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.medapp.domain.entity.MedDoctor
import com.example.medapp.utils.setSafeClickListener
import kotlinx.android.synthetic.main.freelance_doctor_view.view.*

class FreelanceDoctorViewHolder(itemView: View, private val onDoctorClicked: (MedDoctor) -> Unit) :
    RecyclerView.ViewHolder(itemView) {
    fun bind(medDoctor: MedDoctor) {
        itemView.sp_component_name_text_view.text = medDoctor.name
        itemView.sp_component_specialist_text_view.text = medDoctor.specialist
        itemView.setSafeClickListener {
            onDoctorClicked.invoke(medDoctor)
        }
    }
}
