package com.example.medapp.domain.entity

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MedDoctor(
    //val doctorServices: List<WorkingServices> ?= null,
    val workExperience: Int ?= null,
    @Expose
    val specialist: String ?= null,
    val workingAddress: String ?= null,
    val workingDates: List<String> ?= null,
    val comments: List<String> ?= null,
    val img: String ?= null,
    @Expose
    val fname: String ?= null,
): Parcelable
