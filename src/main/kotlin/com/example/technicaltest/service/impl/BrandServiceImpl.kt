package com.example.technicaltest.service.impl

import com.example.technicaltest.domain.dto.response.ResBaseDto
import com.example.technicaltest.domain.dto.response.ResGetBrandDto
import com.example.technicaltest.repository.BrandRepository
import com.example.technicaltest.service.BrandService
import org.springframework.stereotype.Service

@Service
class BrandServiceImpl (
    private val brandRepository: BrandRepository
): BrandService {
    override fun getAll(): ResBaseDto<ArrayList<ResGetBrandDto>> {
        val data = brandRepository.findAll()
        if(data.isEmpty())
            return ResBaseDto(true, "Data not found.")
        val response : ArrayList<ResGetBrandDto> = ArrayList()
        data.forEach {
            response.add(
                ResGetBrandDto(
                    CD_BRAND = it.cd_brand!!,
                    DESC_BRAND = it.desc_brand!!
                )
            )
        }
        return ResBaseDto(OUT_DATA = response)
    }

    override fun getByCd_Brand(cd_brand: String): ResBaseDto<ResGetBrandDto> {
        val data = brandRepository.findByCdBrand(cd_brand)
        if(data == null)
            return ResBaseDto(false, "Data not found")
        val response = ResGetBrandDto(
            CD_BRAND = data.cd_brand,
            DESC_BRAND = data.desc_brand
        )
        return ResBaseDto(OUT_DATA = response)
    }
}