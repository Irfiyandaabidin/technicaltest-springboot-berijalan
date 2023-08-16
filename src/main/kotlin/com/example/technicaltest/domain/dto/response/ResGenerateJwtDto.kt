package com.example.technicaltest.domain.dto.response

data class ResGenerateJwtDto(
    val access_token :String? = null,
    val token_type :String? = null,
    val expires_in :Long? = null
)
