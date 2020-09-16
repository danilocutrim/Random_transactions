package com.devbeck.transactions.model

import java.util.*

data class Transaction (
        val id: Int,
        val descricao: String,
        val duplicated: Boolean,
        val valor: Int,
        val timestamp: Long
)

