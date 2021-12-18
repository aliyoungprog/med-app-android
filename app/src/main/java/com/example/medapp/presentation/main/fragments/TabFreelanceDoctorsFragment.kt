package com.example.medapp.presentation.main.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.medapp.R
import com.example.medapp.domain.entity.MedDoctor
import com.example.medapp.presentation.main.adapters.FreelanceDoctorsAdapter
import kotlinx.android.synthetic.main.tab_freelance_doctors_fragment.*

class TabFreelanceDoctorsFragment : Fragment() {

    private val spRecyclerView get() = sp_recycler_view
    private lateinit var spAdapter: FreelanceDoctorsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.tab_freelance_doctors_fragment, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        spAdapter = FreelanceDoctorsAdapter(
            listOf(
                MedDoctor(name = "Александр Александров", specialist = "Окушер, гинеколог"),
                MedDoctor(name = "Иван Иванов", specialist = "Стамотолог")
            ),
            ::medDoctorClicked
        )
        spRecyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        spRecyclerView.adapter = spAdapter
    }

    private fun medDoctorClicked(medDoctor: MedDoctor) {

    }

    companion object {
        fun getInstance() = TabFreelanceDoctorsFragment()
    }
}
