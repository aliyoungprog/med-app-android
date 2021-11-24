package com.example.medapp.domain.entity

data class MedDoctor(
    val doctorServices: List<WorkingServices> ?= null,
    val workExperience: Int ?= null,
    val about: String ?= null,
    val workingAddress: String ?= null,
    val workingDates: List<String> ?= null,
    val comments: List<String> ?= null,
    val img: String ?= null
)
