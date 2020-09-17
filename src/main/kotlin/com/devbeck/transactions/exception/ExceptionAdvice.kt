package com.devbeck.transactions.exception

import org.springframework.http.HttpHeaders
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import org.springframework.http.HttpStatus.BAD_REQUEST
import java.time.LocalDateTime

@ControllerAdvice
class ExceptionAdvice : ResponseEntityExceptionHandler() {

    @ExceptionHandler(value = [Exception::class])
    fun handleExcepetion(e: Exception, request: WebRequest): ResponseEntity<ExceptionBody> {
        val ourError = ExceptionBody(e.localizedMessage, BAD_REQUEST, LocalDateTime.now())
        return ResponseEntity(ourError, HttpHeaders(), ourError.status)
    }

}