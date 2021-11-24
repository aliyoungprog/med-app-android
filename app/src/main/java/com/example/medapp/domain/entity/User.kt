package com.example.medapp.domain.entity

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class User(
    @Expose
    val id: Int,
    @Expose
    val name: String,
    @Expose
    val lastName: String,
    @Expose
    val birthDate: Date
) : Parcelable
