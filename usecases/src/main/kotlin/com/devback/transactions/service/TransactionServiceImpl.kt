package com.devback.transactions.service

import com.devback.transactions.dto.TransactionResponseDTO
import com.devback.transactions.model.Transaction
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

    override fun generateAleatoryTransactionsList(id: Int, mes: Int, ano: Int): MutableList<Transaction> {

        validator(id, mes, ano)
        //Guardar o valor do primeiro dia do passado via parametro
        val firstIntervalDate = LocalDate.of(ano, mes, 1).atStartOfDay()

        //Guarda o valor do ultimo dia do mê passado via parametro
        val secondIntervalDate = firstIntervalDate.with(TemporalAdjusters.lastDayOfMonth()).plusMinutes(1439)

        //Guarda o valor de timestamp em millissegundos primeiro intervalo de tempo
        val firtIntervalTime = Timestamp.valueOf(firstIntervalDate).time

        //Guarda o valor de timestamp em millissegundos do segundo intervalo de tempo
        val secondIntervalTime = Timestamp.valueOf(secondIntervalDate).time

        val faker = Faker(Random(id.toLong() * 1000000))

        //Valor da semente utilizado como parametro para função Random, para tornar o seu resultado deterministico
        val seed = firtIntervalTime + id.toLong()

        val listSize = Random(seed).nextInt(100) + 1

        //Lista responsável por armazenar as transações geradas para um @ID em um determinanod mês de um ano
        val list = mutableListOf<Transaction>()

        for (i in 1..listSize) {
            val transaction = Transaction(
                    id,
                    faker.regexify("([bcçdfghjklmnpqrstvwxyz][aeiou]){10,60}"),
                    false,
                    faker.number().numberBetween(-9999999, 9999999),
                    faker.number().numberBetween(firtIntervalTime, secondIntervalTime)
            )
            if (list.contains(transaction))
                transaction.duplicated = true

            list.add(transaction)
        }
        return list
    }

    override fun addDuplicateTransactionAndMapToDto(id: Int, mes: Int, ano: Int): List<TransactionResponseDTO> {

        var list = generateAleatoryTransactionsList(id, mes, ano)
        val seed = id + ano
        val aleatoryElement = Random(seed.toLong() * 1000000).nextInt(list.size - 1)
        var elementCopy = list[aleatoryElement].copy()
        elementCopy.duplicated = true
        list.add(Random(seed.toLong() * 10000000000).nextInt(list.size - 1), elementCopy)

        return list.map {
            TransactionResponseDTO(
                    it.descricao,
                    it.timestamp,
                    it.valor,
                    it.duplicated
            )
        }
    }

    override fun validator(id: Int, mes: Int, anos: Int) {

        when {
            ((id !in 1000..100000000) && (mes !in 1..12)) -> throw IllegalArgumentException("Informações não permitidas")
            (id !in 1000..100000000) -> throw IllegalArgumentException("O ID informado não é permitido")
            (mes !in 1..12) -> throw IllegalArgumentException("O mês inserido não é permitido")
        }
    }


}