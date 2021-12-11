package com.example.medapp.domain.entity

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    @Expose
    val id: Int? = null,
    @Expose
    val name: String? = null,
    @Expose
    val lastName: String? = null,
    @Expose
    val cellNumber: Int? = null
) : Parcelable
