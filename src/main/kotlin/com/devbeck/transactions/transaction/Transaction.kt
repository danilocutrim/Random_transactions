package com.devbeck.transactions.transaction

import com.devbeck.transactions.db.LocalTransactions
import com.devbeck.transactions.dto.TransactionBuildDTO
import com.devbeck.transactions.dto.TransactionResponseDTO
import java.lang.IllegalArgumentException

class Transaction {
    companion object : LocalTransactions() {
        fun newTransaction(transaction: TransactionBuildDTO): Boolean {

            return createTransaction(validateTransaction(transaction))

        }

        fun queryTransactionByParameters(id: Int, timestamp: Long): List<TransactionResponseDTO> {

            return queryTransactionByParameters(id, timestamp )
                    .map { TransactionResponseDTO(
                    it.descricao,
                    it.data,
                    it.valor,
                    it.duplicated
            ) }
        }

        fun validateTransaction(transaction: TransactionBuildDTO): TransactionBuildDTO{
            when{
                (transaction.valor !in -9999999..9999999) -> throw IllegalArgumentException("Valor fora dos limites")
                (transaction.id !in 1000..100000000) -> throw IllegalArgumentException("O ID não permitido")
                (transaction.descricao.length !in 10..120) -> throw IllegalArgumentException("Descrição com tamanho incorreto")
                else-> return transaction
            }

        }

    }
}