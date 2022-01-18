package com.example.medapp.domain.entity

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.android.parcel.Parcelize

@Parcelize
data class News(
   @Expose
   var description: String
): Parcelable
