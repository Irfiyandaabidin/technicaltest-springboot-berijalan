package com.example.technicaltest.controller

import com.example.technicaltest.domain.dto.request.ReqGenerateJwtDto
import com.example.technicaltest.domain.dto.response.ResBaseDto
import com.example.technicaltest.domain.dto.response.ResGenerateJwtDto
import com.example.technicaltest.service.GenerateJwtService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/apiservice/oauth")
class GenerateJwtController (
    private val generateJwtService: GenerateJwtService
) {
    @PostMapping("/token")
    fun createToken(@ModelAttribute reqGenerateJwt: ReqGenerateJwtDto) : ResponseEntity<ResBaseDto<ResGenerateJwtDto>> {
        if(
            reqGenerateJwt.grant_type != "client_credentials1" &&
            reqGenerateJwt.grant_type != "client_credentials2" &&
            reqGenerateJwt.grant_type != "client_credentials3"
            )
            return ResponseEntity.status(401).body(ResBaseDto(OUT_MESS = "Invalid_Client", code = 401))
        val response = generateJwtService.generate(reqGenerateJwt)
        return ResponseEntity.ok().body(response)
    }
}