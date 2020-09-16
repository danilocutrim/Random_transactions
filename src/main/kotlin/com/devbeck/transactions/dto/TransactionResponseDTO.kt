package com.devbeck.transactions.dto

/*
classe responsável por modelar o responsebody que
 será serializado como JSON na requisição na api
 */

data class TransactionResponseDTO(
        val descricao: String,
        val data: Long,
        val valor: Int,
        val duplicated: Boolean
)