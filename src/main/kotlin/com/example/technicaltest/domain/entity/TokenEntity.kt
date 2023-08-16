package com.example.technicaltest.domain.entity

import java.time.LocalDateTime
import java.util.UUID
import javax.persistence.*

@Entity
@Table(name = "jwt_token")
data class TokenEntity(
    @Id
    @field:Column(name = "uuid", columnDefinition = "uuid")
    val id : UUID? = null,

    @field:Column(name = "access_token", columnDefinition = "varchar")
    val access_token : String? = null,

    @field:Column(name = "token_type", columnDefinition = "varchar")
    val token_type : String? = null,

    @field:Column(name = "expires_in", columnDefinition = "timestamp")
    val expired : LocalDateTime? = null,

    @field:Column(name = "scope", columnDefinition = "varchar(100)")
    val scope: String? = null,
)
