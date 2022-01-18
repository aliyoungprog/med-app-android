package com.example.medapp.presentation.main.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.medapp.R
import com.example.medapp.domain.entity.MedCenter
import com.example.medapp.domain.entity.NetworkResult
import com.example.medapp.domain.entity.News
import com.example.medapp.presentation.main.adapters.MainFragmentSecondBannerItemAdapter
import com.example.medapp.presentation.main.adapters.NewsAdapter
import com.example.medapp.presentation.main.viewmodel.MainFragmentViewModel
import kotlinx.android.synthetic.main.news_fragment.*
import org.koin.android.viewmodel.ext.android.viewModel

class NewsFragment : Fragment() {

    private val newsViewModel: MainFragmentViewModel by viewModel()
    private val newsRecycler get() = news_recycler_view

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.news_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        newsViewModel.getAllNews()
        newsRecycler.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        newsViewModel.news.observe(viewLifecycleOwner, {
            when (it) {
                is NetworkResult.Success -> setAdapterForSuccess(it.data!!)
                is NetworkResult.Error -> {}
                is NetworkResult.Loading -> {}
            }
        })
    }

    private fun setAdapterForSuccess(newsList: List<News>) {
        newsRecycler.adapter = NewsAdapter(newsList)
    }

}
