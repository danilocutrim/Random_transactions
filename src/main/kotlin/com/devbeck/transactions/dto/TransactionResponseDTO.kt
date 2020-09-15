package com.devbeck.transactions.dto

data class TransactionResponseDTO(
        val descricao: String,
        val data: Long,
        val valor: Int,
        val duplicated: Boolean
)