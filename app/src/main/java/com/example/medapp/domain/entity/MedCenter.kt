package com.example.medapp.domain.entity

data class MedCenter(
    val name: String ?= null,
    val img: String ?= null,
    val rating: Double ?= null,
    val workingDates: List<String> ?= null,
    val address: String ?= null,
    val doctorList: List<MedDoctor> ?= null,
    val workingServices: List<WorkingServices> ?= null
)
