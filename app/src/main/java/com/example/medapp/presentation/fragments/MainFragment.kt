package com.example.medapp.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.medapp.R
import com.example.medapp.domain.entity.MedCenter
import com.example.medapp.domain.entity.MedServiceBanner
import com.example.medapp.presentation.adapters.MainFragmentFirstBannerItemAdapter
import com.example.medapp.presentation.adapters.MainFragmentSecondBannerItemAdapter
import com.example.medapp.presentation.viewmodel.MainFragmentViewModel
import com.example.medapp.utils.RecyclerViewItemSpace
import com.example.medapp.utils.setSafeClickListener
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_main.*

@AndroidEntryPoint
class MainFragment : Fragment(){

    private val recyclerView get() = main_fragment_first_banner_item
    private val secondBannerRecycler get() = main_fragment_second_banner_item
    private val showAllBnt get() = main_fragment_show_all_btn

    private val viewModel: MainFragmentViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView(){
        initAdapter()
        initListeners()
    }

    private fun initAdapter(){
        recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        val itemSpacing = RecyclerViewItemSpace(16)
        recyclerView.addItemDecoration(itemSpacing)
        recyclerView.adapter = MainFragmentFirstBannerItemAdapter(listOf(
            MedServiceBanner(name = "mock"),
            MedServiceBanner(name = "mock"),
            MedServiceBanner(name = "mock")
        ))
        secondBannerRecycler.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        secondBannerRecycler.addItemDecoration(itemSpacing)
        secondBannerRecycler.adapter = MainFragmentSecondBannerItemAdapter(listOf(MedCenter(name = "MOCK", address = "mock"),
            MedCenter(name = "MOCK", address = "mock"),
            MedCenter(name = "MOCK", address = "mock")))
    }

    private fun initListeners() {
        showAllBnt.setSafeClickListener {
            val action = MainFragmentDirections.actionMainFragmentToAboutMedCentrFragment()
            findNavController().navigate(action)
        }
    }
}
