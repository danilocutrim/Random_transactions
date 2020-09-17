package com.devbeck.transactions.service

import com.devbeck.transactions.dto.TransactionResponseDTO
import com.devbeck.transactions.model.Transaction

/*
Interface responsável por determinar os metodos que devem ser
implementados em nossa classe de service, assim como seus parametros
e também o tipo de retorno esperado
 */

interface TransactionService {

    fun generateAleatoryTransactionsList(id: Int, mes: Int, ano: Int): List<Transaction>

    fun addDuplicateTransactionAndMapToDto(id: Int, mes: Int, ano: Int): List<TransactionResponseDTO>

    fun validator(id: Int, mes: Int, anos: Int)

}