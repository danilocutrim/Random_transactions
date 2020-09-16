package com.devbeck.transactions.service

import com.devbeck.transactions.model.Transaction
import com.github.javafaker.Faker
import org.springframework.stereotype.Service
import java.sql.Timestamp
import java.time.LocalDate
import java.time.temporal.TemporalAdjusters
import java.util.*

/*Implementação da interface Transaction service
* */

@Service
class TransactionServiceImpl : TransactionService {

    override fun generateAleatoryTransactions(id: Int, mes: Int, ano: Int): List<Transaction> {
        validator(id, mes, ano)
        //Esta variável é responsável por guarda o valor do primeiro dia do mês e ano passados via parametros
        val firstIntervalDate = LocalDate.of(ano, mes, 1).atStartOfDay()

        //Esta variável é responsável por guardar o valor do ultimo dia do mê e ano passados
        val secondIntervalDate = firstIntervalDate.with(TemporalAdjusters.lastDayOfMonth()).plusMinutes(1439)

        //Esta variável é responsável por guarda o valor de timestamp em millisseconds do primeiro intervalo de tempo
        val firtIntervalTime = Timestamp.valueOf(firstIntervalDate).time

        //Esta variável é responsável por guarda o valor de timestamp em millisseconds do segundo intervalo de tempo
        val secondIntervalTime = Timestamp.valueOf(secondIntervalDate).time

        val faker = Faker(Random(id.toLong()))

        //Valor da semente utilizado como parametro para função Random, para tornar o seu resultado deterministico
        val seed = firtIntervalTime + id.toLong()

        val listSize = Random(seed).nextInt(100) + 1

        //Lista responsável por armazenar as transações geradas para um @ID em um determinanod mês de um ano
        val list = mutableListOf<Transaction>()

        for (i in 1..listSize) {
            val transaction = Transaction(
                    id,
                    faker.regexify("([bcdfghjklmnpqrstvxyz][aeiou]){10,120}"),
                    false,
                    faker.number().numberBetween(-9999999, 9999999),
                    faker.number().numberBetween(firtIntervalTime, secondIntervalTime)
            )
            list.add(transaction)
        }
        return list
    }

    override fun updateTranction(transaction: Transaction) {
        TODO("Not yet implemented")
    }

    override fun validator(id: Int, mes: Int, anos: Int) {
        when {

            ((id !in 1000..100000000) && (mes !in 1..12)) -> throw IllegalArgumentException("Informações não permitidas")
            (id !in 1000..100000000) -> throw IllegalArgumentException("O ID informado não é permitido")
            (mes !in 1..12) -> throw IllegalArgumentException("O mês inserido não é permitido")

        }
    }


}