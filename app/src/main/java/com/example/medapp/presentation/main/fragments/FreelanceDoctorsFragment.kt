package com.example.medapp.presentation.main.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.medapp.R
import com.example.medapp.domain.entity.MedDoctor
import com.example.medapp.domain.entity.NetworkResult
import com.example.medapp.presentation.main.adapters.FreelanceDoctorsAdapter
import com.example.medapp.presentation.main.viewmodel.DoctorViewModel
import kotlinx.android.synthetic.main.freelance_doctors_fragment.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.android.viewmodel.ext.android.viewModel

class FreelanceDoctorsFragment : Fragment() {

    private val spRecyclerView get() = specialist_recycler_view
    private val doctorProgress get() = freelance_doctors_progress
    private val doctorViewModel: DoctorViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.freelance_doctors_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
        initView()
    }

    private fun initView() {
        spRecyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        doctorViewModel.medDoctors.observe(viewLifecycleOwner, {
            when (it) {
                is NetworkResult.Success -> {
                    spRecyclerView.adapter = FreelanceDoctorsAdapter(it.data!!, ::medDoctorClicked)
                }
                is NetworkResult.Loading -> {

                }
                is NetworkResult.Error -> {
                }
            }
        })
    }

    private fun medDoctorClicked(medDoctor: MedDoctor) {
        CoroutineScope(Dispatchers.Main).launch {
            doctorProgress.visibility = View.VISIBLE
            delay(2000)
            Toast.makeText(context, "Вы успешно записались!", Toast.LENGTH_SHORT).show()
            findNavController().popBackStack()
        }
    }

    private fun initViewModel() {
        doctorViewModel.getAllDoctors()
    }
}
