package com.example.technicaltest.domain.dto.response

data class ResBaseErrorDto<T>(
        val errors : T? = null,
        val message : String = "error",
        val code : Int? = 400
)
