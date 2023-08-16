package com.example.technicaltest.domain.entity

import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "brands")
data class BrandEntity(
    @Id
    @field:Column(name = "uuid", columnDefinition = "varchar")
    val id : UUID? = null,

    @field:Column(name = "cd_brand", columnDefinition = "varchar")
    val cd_brand : String? = null,

    @field:Column(name = "desc_brand", columnDefinition = "varchar")
    val desc_brand : String? = null,
)
