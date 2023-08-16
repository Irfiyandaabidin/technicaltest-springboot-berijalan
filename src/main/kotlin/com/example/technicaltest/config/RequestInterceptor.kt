package com.example.technicaltest.config

import com.example.technicaltest.util.JwtGenerator
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.stereotype.Component
import org.springframework.web.servlet.HandlerInterceptor
import java.util.Date
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class RequestInterceptor : HandlerInterceptor {
    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        fun convertObjectToJson(obj: Any) : String {
            val objectMapper = ObjectMapper()
            return objectMapper.writeValueAsString(obj)
        }
        val apiKey = request.getHeader("APIKey")
        val authBearer = request.getHeader("Authorization")
        val tokenBearer = authBearer.substring(7)
        try {
            val claims = JwtGenerator().decodeJWT(token = apiKey) ?: throw Exception()
            val claimsBearer = JwtGenerator().decodeJWT(token = tokenBearer) ?: throw Exception()
            if(claims.expiration.before(Date(System.currentTimeMillis())) || claimsBearer!!.expiration.before(Date(System.currentTimeMillis())))
                throw Exception()
            if(!authBearer.startsWith("Bearer "))
                throw Exception()
            return true
        } catch (e: Exception) {
            val result = mapOf<String, String>("status" to "False", "message" to e.message!!)
            val jsonResult = convertObjectToJson(result)
            response.writer.write(jsonResult)
            response.characterEncoding = "UTF-8"
            response.status = 403
            return false
        }
    }
}