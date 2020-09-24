package com.devback.transactions.model

/*
Classe responsável por modelar a transação que será serializada para JSON
 */

data class Transaction(
        val id: Int,
        val descricao: String,
        var duplicated: Boolean,
        val valor: Int,
        val timestamp: Long
)

