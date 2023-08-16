package com.example.technicaltest.service

import com.example.technicaltest.domain.dto.response.ResBaseDto
import com.example.technicaltest.domain.dto.response.ResGetBrandDto

interface BrandService {
    fun getAll() : ResBaseDto<ArrayList<ResGetBrandDto>>

    fun getByCd_Brand(cd_brand : String) : ResBaseDto<ResGetBrandDto>
}