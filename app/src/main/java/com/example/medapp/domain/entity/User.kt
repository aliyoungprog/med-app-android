package com.example.medapp.domain.entity

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class User(
    @Expose
    val user_id: Int? = null,
    @Expose
    val fname: String? = null,
    @Expose
    val lname: String? = null,
    @Expose
    val phone_number: String? = null,
    @Expose
    val user_doctor_id: Int ?= null
) : Parcelable
