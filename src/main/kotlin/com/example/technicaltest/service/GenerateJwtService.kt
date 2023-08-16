package com.example.technicaltest.service

import com.example.technicaltest.domain.dto.request.ReqGenerateJwtDto
import com.example.technicaltest.domain.dto.response.ResBaseDto
import com.example.technicaltest.domain.dto.response.ResGenerateJwtDto

interface GenerateJwtService {
    fun generate(reqGenerateJwt: ReqGenerateJwtDto) : ResBaseDto<ResGenerateJwtDto>
}