package com.example.technicaltest.domain.dto.response

data class ResBaseDto<T>(
    val OUT_STAT :Boolean = true,
    val OUT_MESS :String = "success",
    val OUT_DATA : T? = null,
    val code : Int = 200
)
