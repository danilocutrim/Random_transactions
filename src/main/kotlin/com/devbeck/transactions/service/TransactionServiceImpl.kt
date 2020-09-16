package com.devbeck.transactions.service

import com.devbeck.transactions.dto.TransactionResponseDTO
import com.devbeck.transactions.model.Transaction
import com.github.javafaker.Faker
import org.springframework.stereotype.Service
import java.lang.IllegalArgumentException
import java.sql.Timestamp
import java.time.LocalDate
import java.time.temporal.TemporalAdjusters
import java.util.*

@Service
class TransactionServiceImpl : TransactionService {
    companion object {
        var transactionList: MutableList<Transaction> = mutableListOf()

    }

    override fun generateAleatoryTransactions(id: Int, mes: Int, ano: Int): List<Transaction> {
        val firstIntervalDate = LocalDate.of(ano, mes, 1).atStartOfDay()
        val secondIntervalDate = firstIntervalDate.with(TemporalAdjusters.lastDayOfMonth()).plusMinutes(1439)
        val firtIntervalTime = Timestamp.valueOf(firstIntervalDate).time
        val secondIntervalTime = Timestamp.valueOf(secondIntervalDate).time

        val faker = Faker(Random(id.toLong()))
        val tamanhoLista = Random(id.toLong()).nextInt(100) + 1
        val list = mutableListOf<Transaction>()
        for (i in 1..tamanhoLista) {
            val transaction = Transaction(
                    id,
                    faker.regexify("([bcdfghjklmnpqrstvxyz][aeiou]){10,120}"),
                    false,
                    faker.number().numberBetween(-9999999, 9999999),
                    faker.number().numberBetween(firtIntervalTime, secondIntervalTime).toLong()

            )
            list.add(transaction)
        }
        return list
    }

    override fun findByParameters(id: Int, timestamp: Long): List<TransactionResponseDTO> {
        val trasactions = transactionList

        val trancationFiltering = trasactions
                .filter {
                    it.id.equals(id)
                }.filter {
                    it.timestamp.equals(timestamp)
                }

        if (trancationFiltering.isEmpty()) {
            throw IllegalArgumentException()
        }

        return trancationFiltering.map {
            TransactionResponseDTO(
                    it.descricao,
                    it.timestamp,
                    it.valor,
                    it.duplicated
            )
        }
    }

    override fun findAllTransactions(): List<TransactionResponseDTO> {
        val transactions = transactionList

        if (transactions.isEmpty()) {
            throw IllegalArgumentException()
        }

        return transactions.map {
            TransactionResponseDTO(
                    it.descricao,
                    it.timestamp,
                    it.valor,
                    it.duplicated
            )
        }
    }

    override fun saveTransaction(transaction: Transaction): Boolean {
        when {

            (transaction.valor !in -9999999..9999999) -> throw IllegalArgumentException("Valor fora dos limites")
            (transaction.id !in 1000..100000000) -> throw IllegalArgumentException("O ID não permitido")
            (transaction.descricao.length !in 10..60) -> throw IllegalArgumentException("Descrição com tamanho incorreto")
            else -> return transactionList.add(transaction)

        }
    }

    override fun updateTranction(transaction: Transaction) {
        TODO("Not yet implemented")
    }


}