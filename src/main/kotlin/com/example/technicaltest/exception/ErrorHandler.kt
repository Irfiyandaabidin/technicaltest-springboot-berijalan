package com.example.technicaltest.exception

import com.example.technicaltest.domain.dto.response.ResBaseDto
import com.example.technicaltest.domain.dto.response.ResBaseErrorDto
import com.example.technicaltest.exception.CustomExceptionHandler
import org.springframework.core.Ordered
import org.springframework.core.annotation.Order
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.sql.DriverManager.println

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)

class ErrorHandler {
    @ExceptionHandler(Exception::class)
    fun handlerException(exception: Exception): ResponseEntity<ResBaseErrorDto<Nothing>> {
        println("Error General!!")
        exception.printStackTrace()
        val result = ResBaseErrorDto(errors = null, message = "Something Went Wrong")
        return ResponseEntity.badRequest().body(result)
    }
    @ExceptionHandler(CustomExceptionHandler::class)
    fun handleCustomException(exception: RuntimeException) : ResponseEntity<Any> {
        val result = ResBaseErrorDto(errors = null, message = exception.message.toString())
        return ResponseEntity.badRequest().body(result)
    }

    @ExceptionHandler (MethodArgumentNotValidException::class)
    fun handleArgumentNotValidException(exception: MethodArgumentNotValidException): ResponseEntity<ResBaseErrorDto<MutableList<String>>> {
        val errors = mutableListOf<String>()
        exception.bindingResult.fieldErrors.forEach {
            errors.add(it.defaultMessage!!)
        }
        val error = errors[0].split(",")
        val result = ResBaseErrorDto(errors, message = "Invalid input")
        return ResponseEntity.badRequest().body(result)
    }
}