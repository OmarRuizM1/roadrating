package com.road.rating.rest

import com.road.rating.domain.validation.ValidationException
import mu.KotlinLogging
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

private val log = KotlinLogging.logger {}

@RestControllerAdvice
class RestExceptionHandler {

    @ExceptionHandler(ValidationException::class)
    fun handle(exception: ValidationException): ResponseEntity<Any> {
        log.warn { exception.message }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.message)
    }

}