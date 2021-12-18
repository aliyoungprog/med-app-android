package com.example.medapp.presentation.main.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.medapp.presentation.main.fragments.CommentsFragment
import com.example.medapp.presentation.main.fragments.TabFreelanceDoctorsFragment

class AboutFragmentPageAdapter(fm: Fragment) : FragmentStateAdapter(fm) {
    override fun getItemCount() = 2

    override fun createFragment(position: Int): Fragment {
        return if (position == 0) TabFreelanceDoctorsFragment.getInstance()
        else CommentsFragment.getInstance()
    }
}
