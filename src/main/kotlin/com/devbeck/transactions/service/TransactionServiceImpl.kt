package com.devbeck.transactions.service

import com.devbeck.transactions.model.Transaction
import com.github.javafaker.Faker
import org.springframework.stereotype.Service
import java.sql.Timestamp
import java.time.LocalDate
import java.time.temporal.TemporalAdjusters
import java.util.*

@Service
class TransactionServiceImpl : TransactionService {

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

    override fun updateTranction(transaction: Transaction) {
        TODO("Not yet implemented")
    }

}