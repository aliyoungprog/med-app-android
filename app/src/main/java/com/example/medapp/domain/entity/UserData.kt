package com.example.medapp.domain.entity

data class UserData(
    var name: String ?= null,
    var secondName: String ?= null,
    var cellNumber: String ?= null,
    var iin: String ?= null,
    var cardNumber: String ?= null
)
