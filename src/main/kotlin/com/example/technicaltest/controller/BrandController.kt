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
    fun get(@Valid @RequestBody reqGetBrandDto: ReqGetBrandDto): ResponseEntity<out Any> {
        val filterUnit = reqGetBrandDto.filterUnitBrand!!
        if(filterUnit.CD_BRAND != "" && filterUnit.CD_BRAND != null){
            val response = brandService.getByCd_Brand(reqGetBrandDto.filterUnitBrand.CD_BRAND!!)
            return ResponseEntity.ok().body(response)
        }
        if(filterUnit.DESC_BRAND != "" && filterUnit.DESC_BRAND != null){
            val response = brandService.getByDesc_Brand(reqGetBrandDto.filterUnitBrand.DESC_BRAND!!)
            return ResponseEntity.ok().body(response)
        }
        val response = brandService.getAll()
        return ResponseEntity.ok().body(response)
    }
}