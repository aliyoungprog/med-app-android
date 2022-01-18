package com.example.medapp.presentation.main.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.medapp.R
import com.example.medapp.domain.entity.MedCenter
import com.example.medapp.domain.entity.NetworkResult
import com.example.medapp.presentation.main.adapters.AboutFragmentBaseItemAdapter
import com.example.medapp.presentation.main.viewmodel.AboutMedCenterViewModel
import com.example.medapp.presentation.main.viewmodel.MainFragmentViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.about_med_center_base_component.*
import kotlinx.android.synthetic.main.fragment_about_med_center.*
import org.koin.android.viewmodel.ext.android.sharedViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class AboutMedCenterFragment : BottomSheetDialogFragment() {

    private val recyclerView get() = fa_recycler_view
    private val assignBtn get() = am_component_buttons_registration
    private val mainFragmentViewModel: MainFragmentViewModel by sharedViewModel()
    private val aboutMedCenterViewModel: AboutMedCenterViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_about_med_center, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initViewModel()
        initListeners()
    }

    private fun initView() {
        initAdapter()
    }

    private fun initAdapter() {
        recyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
    }

    private fun medCenterClicked(medCenter: MedCenter) {
        mainFragmentViewModel.selectMedCenterFromAdapter(medCenter)
        this.dismiss()
    }

    private fun onWriteClicked(medCenter: MedCenter) {
        // TODO
    }

    private fun initViewModel() {
        aboutMedCenterViewModel.getAllMedCenters()
    }

    private fun initListeners() {
        aboutMedCenterViewModel.medCenters.observe(viewLifecycleOwner, {
            when (it) {
                is NetworkResult.Success -> {
                    setAdapterForSuccess(it.data!!)
                }
                is NetworkResult.Error -> {
                }
                is NetworkResult.Loading -> {
                }
            }
        })
    }

    private fun setAdapterForSuccess(medCenterList: List<MedCenter>) {
        recyclerView.adapter = AboutFragmentBaseItemAdapter(
            medCenterList, ::medCenterClicked,
            ::onWriteClicked
        )
    }

    private fun setAdapterForFailure() {
        // TODO
    }

    private fun setAdapterForLoading() {
        // TODO
    }

    companion object {
        fun getInstance() = AboutMedCenterFragment()
    }
}
