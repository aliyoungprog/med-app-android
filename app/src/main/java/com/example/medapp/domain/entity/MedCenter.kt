package com.example.medapp.domain.entity

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MedCenter(
    @Expose
    var id: Int ?= null,
    @Expose
    var name: String? = null,
    //@Expose
    //var img: String? = null,
    @Expose
    var rating: Double? = null,
    @Expose
    var workingDates: List<String>? = null,
    @Expose
    var address: String? = null,
    //@Expose
    //val doctorList: List<MedDoctor>? = null,
    //@Expose
    //val workingServices: List<WorkingServices>? = null
) : Parcelable
