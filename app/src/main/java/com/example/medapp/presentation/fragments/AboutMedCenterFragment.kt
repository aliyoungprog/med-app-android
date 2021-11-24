package com.example.medapp.presentation.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.medapp.R
import com.example.medapp.domain.entity.MedCenter
import com.example.medapp.presentation.adapters.AboutFragmentBaseItemAdapter
import kotlinx.android.synthetic.main.fragment_about_med_center.*

class AboutMedCenterFragment : Fragment() {

    private val recyclerView get() = fa_recycler_view

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_about_med_center, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(view)
    }

    private fun initView(view: View) {
        initAdapter()
        initListeners(view)
    }

    private fun initAdapter() {
        val items = AboutFragmentBaseItemAdapter(listOf(MedCenter(
            name = "Mock",
            address = "Mock"
        ),
            MedCenter(
                name = "Mock",
                address = "Mock"
            ),
            MedCenter(
                name = "Mock",
                address = "Mock"
            ),
            MedCenter(
                name = "Mock",
                address = "Mock"
            )),
            ::initListeners
        )
        recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = items
    }

    private fun initListeners(view: View) {
        view.setOnClickListener{
            val action = AboutMedCenterFragmentDirections.actionAboutMedCentrFragmentToMedCenterDescriptionFragment()
            findNavController().navigate(action)
        }
    }

}
