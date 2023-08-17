package com.example.technicaltest.domain.dto.request

import com.fasterxml.jackson.annotation.JsonProperty
import javax.validation.Valid
import javax.validation.constraints.NotNull
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size

data class ReqGetBrandDto(
    @field:Valid
    @JsonProperty("getListFilterUnitBrand")
    val filterUnitBrand: FilterUnitBrandDto
)

data class FilterUnitBrandDto(
    @JsonProperty("CD_BRAND")
    @field:Size(max = 10, message = "Invalid input: Maximum length is 10")
    @field:Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Invalid input: Only alphanumeric characters are allowed")
    val CD_BRAND: String? = null,

    @JsonProperty("DESC_BRAND")
    @field:Size(max = 10, message = "Invalid input: Maximum length is 10")
    @field:Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Invalid input: Only alphanumeric characters are allowed")
    val DESC_BRAND: String? = null
)