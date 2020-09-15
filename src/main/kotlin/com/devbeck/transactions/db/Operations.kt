package com.devbeck.transactions.db

import com.devbeck.transactions.dto.TransactionBuildDTO

interface Operations{
    fun createTransaction(transaction: TransactionBuildDTO):Boolean
    fun queryTransaction(): List<TransactionBuildDTO>
    fun queryByParameters(id: Int, timestam: Long): List<TransactionBuildDTO>
}