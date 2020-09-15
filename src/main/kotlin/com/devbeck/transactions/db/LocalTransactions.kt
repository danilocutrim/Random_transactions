package com.devbeck.transactions.db

import com.devbeck.transactions.dto.TransactionBuildDTO

open class LocalTransactions : Operations {
    companion object {
        private var transactionList: MutableList<TransactionBuildDTO> = mutableListOf()

    }

    override fun queryTransaction(): List<TransactionBuildDTO> {
        return LocalTransactions.transactionList
    }

    override fun queryByParameters(id: Int, timestamp: Long): List<TransactionBuildDTO> {
        val lisTransactions = LocalTransactions.transactionList
        val transactionFiltering = lisTransactions.filter {
            it.id.equals(id)
        }.filter {
            it.timestamp.equals(timestamp)
        }

        return transactionFiltering
    }

    override fun createTransaction(transaction: TransactionBuildDTO): Boolean {
        return LocalTransactions.transactionList.add(transaction)
    }
}