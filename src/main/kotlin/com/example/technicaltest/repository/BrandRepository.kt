package com.example.technicaltest.repository

import com.example.technicaltest.domain.entity.BrandEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface BrandRepository : JpaRepository <BrandEntity, String> {
    @Query(value = "SELECT b FROM BrandEntity b WHERE b.cd_brand = :cd_brand")
    fun findByCdBrand(cd_brand: String): BrandEntity?
}