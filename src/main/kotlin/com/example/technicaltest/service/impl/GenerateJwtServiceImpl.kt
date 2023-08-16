package com.example.technicaltest.service.impl

import com.example.technicaltest.domain.dto.request.ReqGenerateJwtDto
import com.example.technicaltest.domain.dto.response.ResBaseDto
import com.example.technicaltest.domain.dto.response.ResGenerateJwtDto
import com.example.technicaltest.domain.entity.TokenEntity
import com.example.technicaltest.repository.GenerateJwtRepository
import com.example.technicaltest.service.GenerateJwtService
import com.example.technicaltest.util.JwtGenerator
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.Date
import java.util.UUID

@Service
class GenerateJwtServiceImpl (
    private val generateJwtRepository: GenerateJwtRepository,
) :GenerateJwtService{
    private var fiveSecond: Date = Date(System.currentTimeMillis() - 5000)
    private var sameResponse: ResGenerateJwtDto = ResGenerateJwtDto()
    override fun generate(reqGenerateJwt: ReqGenerateJwtDto): ResBaseDto<ResGenerateJwtDto> {
        if(fiveSecond.after(Date(System.currentTimeMillis())))
            return ResBaseDto(OUT_DATA = sameResponse)
        val uuidRandom = UUID.randomUUID()
        val exp = 3600000L
        val date = Date(System.currentTimeMillis() + exp)
        val expired = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault())
        val token = JwtGenerator().createJWT(
            uuid = uuidRandom.toString(),
            reqGenerateJwt.grant_type!!,
            exp
        )
        val data = TokenEntity(
            id = uuidRandom,
            access_token = token,
            expired = expired,
            token_type = "Bearer"
        )

        val entity = generateJwtRepository.save(data)
        val response = ResGenerateJwtDto(
            access_token = entity.access_token,
            token_type = entity.token_type,
            expires_in = exp,
        )
        fiveSecond = Date(System.currentTimeMillis() + 10800L)
        sameResponse = response
        return ResBaseDto(OUT_DATA = response)
    }
}