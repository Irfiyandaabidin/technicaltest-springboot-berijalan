package com.example.technicaltest.controller

import com.example.technicaltest.domain.dto.request.ReqGetBrandDto
import com.example.technicaltest.domain.dto.response.ResBaseDto
import com.example.technicaltest.domain.dto.response.ResGetBrandDto
import com.example.technicaltest.service.BrandService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/apiservice/unit")
class BrandController(
    private val brandService: BrandService
) {
    @PostMapping("/getbrand")
    fun get(@Valid @RequestBody reqGetBrandDto: ReqGetBrandDto): ResponseEntity<out ResBaseDto<out Any>> {
        if(reqGetBrandDto.filterUnitBrand.CD_BRAND == ""){
            val response = brandService.getAll()
            return ResponseEntity.ok().body(response)
        }
        val response = brandService.getByCd_Brand(reqGetBrandDto.filterUnitBrand.CD_BRAND!!)
        return ResponseEntity.ok().body(response)
    }
}