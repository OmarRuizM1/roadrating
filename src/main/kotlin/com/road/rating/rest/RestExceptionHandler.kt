package com.road.rating.rest

import com.road.rating.domain.validation.exceptions.RatingException
import com.road.rating.domain.validation.exceptions.RegexException
import mu.KotlinLogging
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

private val log = KotlinLogging.logger {}

@RestControllerAdvice
class RestExceptionHandler {

    @ExceptionHandler(RatingException::class)
    fun handle(exception: RatingException): ResponseEntity<Any> {
        log.warn { exception.message }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.message)
    }

    @ExceptionHandler(RegexException::class)
    fun handle(exception: RegexException): ResponseEntity<Any> {
        log.warn { exception.message }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.message)
    }

}