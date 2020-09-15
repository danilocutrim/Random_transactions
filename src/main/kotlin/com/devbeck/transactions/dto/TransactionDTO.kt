package com.devbeck.transactions.dto

data class TransactionBuildDTO (
        val id: Int,
        val descricao: String,
        val duplicated: Boolean,
        val valor: Int,
        val timestamp: Long
)

