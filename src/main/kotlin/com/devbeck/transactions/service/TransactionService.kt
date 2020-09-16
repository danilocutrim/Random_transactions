package com.devbeck.transactions.service

import com.devbeck.transactions.dto.TransactionResponseDTO
import com.devbeck.transactions.model.Transaction

interface TransactionService {

    fun generateAleatoryTransactions(id: Int, mes: Int, ano: Int): List<Transaction>

    fun findByParameters(id: Int, timestamp: Long): List<TransactionResponseDTO>

    fun findAllTransactions(): List<TransactionResponseDTO>

    fun saveTransaction(transaction: Transaction): Boolean

    fun updateTranction(transaction: Transaction)


}