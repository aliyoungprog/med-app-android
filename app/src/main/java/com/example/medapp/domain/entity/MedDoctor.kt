package com.example.medapp.domain.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MedDoctor(
    //val doctorServices: List<WorkingServices> ?= null,
    val workExperience: Int ?= null,
    val specialist: String ?= null,
    val workingAddress: String ?= null,
    val workingDates: List<String> ?= null,
    val comments: List<String> ?= null,
    val img: String ?= null,
    val name: String ?= null,
): Parcelable
