package com.devbeck.transactions.model

data class Transaction(
        val id: Int,
        val descricao: String,
        val duplicated: Boolean,
        val valor: Int,
        val timestamp: Long
)

