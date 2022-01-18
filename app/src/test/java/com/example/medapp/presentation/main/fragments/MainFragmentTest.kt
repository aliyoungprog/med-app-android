package com.example.medapp.presentation.main.fragments

import androidx.test.espresso.Espresso
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.medapp.R
import com.example.medapp.presentation.main.activity.MainActivity
import org.junit.Rule
import org.junit.Test

class MainFragmentTest {

    @get: Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testRecyclerIsVisible() {
        Espresso.onView(ViewMatchers.withId(R.id.main_fragment_first_banner_item))
    }
}
