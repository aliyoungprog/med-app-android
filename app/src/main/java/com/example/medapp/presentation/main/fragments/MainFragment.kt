package com.example.medapp.presentation.main.fragments

import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.medapp.R
import com.example.medapp.domain.entity.MedCenter
import com.example.medapp.domain.entity.NetworkResult
import com.example.medapp.presentation.main.adapters.MainFragmentSecondBannerItemAdapter
import com.example.medapp.presentation.main.viewmodel.MainFragmentViewModel
import com.example.medapp.presentation.registration.activity.RegistrationActivity
import com.example.medapp.utils.RecyclerViewItemSpace
import com.example.medapp.utils.observeEvent
import com.example.medapp.utils.setSafeClickListener
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.main_fragment_nav_bar_menu.*
import org.koin.android.viewmodel.ext.android.sharedViewModel

class MainFragment : Fragment() {

    private val recyclerView get() = main_fragment_first_banner_item
    private val secondBannerRecycler get() = main_fragment_second_banner_item
    private val showAllBnt get() = main_fragment_show_all_btn
    private val navBarClinic get() = main_nav_bar_clinic
    private val navBarSpecialist get() = main_nav_bar_specialist
    private val navBarService get() = main_nav_bar_service
    private val navBarSymptoms get() = main_nav_bar_symptom
    private val navBarLogin get() = main_tool_bar_login
    private val secondBannerLoader get() = main_fragment_second_banner_loader
    private val navBarGreeting get() = main_tool_bar_greeting

    private val mainFragmentViewModel: MainFragmentViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAll()
    }

    override fun onResume() {
        super.onResume()
        initView()
    }

    private fun initAll() {
        initView()
        initViewModel()
        initAdapter()
        initListeners()
        initObservers()
    }

    private fun initAdapter() {
        recyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        recyclerView.addItemDecoration(RecyclerViewItemSpace(16))
        secondBannerRecycler.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        secondBannerRecycler.addItemDecoration(RecyclerViewItemSpace(16))
    }

    private fun initListeners() {
        showAllBnt.setSafeClickListener {
//            findNavController()
//                .navigate(MainFragmentDirections.actionMainFragmentToAboutMedCentrFragment())
        }
        navBarClinic.setSafeClickListener {
            AboutMedCenterFragment.getInstance()
                .show(requireActivity().supportFragmentManager, "clinics")
        }
        navBarSpecialist.setSafeClickListener { }
        navBarService.setSafeClickListener { }
        navBarSymptoms.setSafeClickListener { }
        navBarLogin.setSafeClickListener {
            requireActivity().startActivity(Intent(context, RegistrationActivity::class.java))
        }
    }

    private fun initObservers() {

        mainFragmentViewModel.bestMedCenters.observe(viewLifecycleOwner, {
            when (it) {
                is NetworkResult.Success -> setAdapterForSuccess(it.data!!)
                is NetworkResult.Error -> setAdapterForFailure()
                is NetworkResult.Loading -> setAdapterForLoading()
            }
        })

        mainFragmentViewModel.medCenter.observeEvent(viewLifecycleOwner, { medCenter ->
            findNavController().navigate(
                MainFragmentDirections.actionMainFragmentToMedCenterDescriptionFragment(
                    medCenter
                )
            )
        })
    }

    private fun setAdapterForSuccess(medCenterList: List<MedCenter>) {
        secondBannerLoader.visibility = View.GONE
        secondBannerRecycler.adapter = MainFragmentSecondBannerItemAdapter(medCenterList)
    }

    private fun setAdapterForFailure() {
        secondBannerLoader.visibility = View.GONE
        // TODO
    }

    private fun setAdapterForLoading() {
        secondBannerLoader.visibility = View.VISIBLE
    }

    private fun initViewModel() {
        mainFragmentViewModel.getBestMedCenters()
    }

    private fun initView() {
        val pref = context?.getSharedPreferences("user_data", MODE_PRIVATE)
        val phoneNumber = pref?.getString("user_phoneNumber", "")
        val fname = pref?.getString("user_fname", "")
        if (!phoneNumber.isNullOrBlank()) {
            navBarLogin.visibility = View.GONE
            navBarGreeting.visibility = View.VISIBLE
            navBarGreeting.text = "Привет, $fname!"
        } else {
            navBarLogin.visibility = View.VISIBLE
            navBarGreeting.visibility = View.GONE
        }
    }
}
