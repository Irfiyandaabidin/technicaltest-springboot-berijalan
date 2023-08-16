package com.example.technicaltest.repository

import com.example.technicaltest.domain.entity.TokenEntity
import org.springframework.data.jpa.repository.JpaRepository

interface GenerateJwtRepository : JpaRepository<TokenEntity, String> {
}