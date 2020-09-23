package com.devback.transactions.exception

import org.springframework.http.HttpStatus
import java.time.LocalDateTime

data class ExceptionBody(val detail: String? = null,
                         val status: HttpStatus,
                         val timestamp: LocalDateTime)