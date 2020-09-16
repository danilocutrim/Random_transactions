package com.devbeck.transactions.service

import com.devbeck.transactions.model.Transaction

interface TransactionService {

    fun generateAleatoryTransactions(id: Int, mes: Int, ano: Int): List<Transaction>

    fun updateTranction(transaction: Transaction)

}