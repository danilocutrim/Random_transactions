package com.devbeck.transactions.service

import com.devbeck.transactions.model.Transaction

/*
Interface responsável por determinar os metodos que devem ser
implementados em nossa classe de service, assim como seus parametros
e também o tipo de retorno esperado
 */

interface TransactionService {

    fun generateAleatoryTransactions(id: Int, mes: Int, ano: Int): List<Transaction>

    fun updateTranction(transaction: Transaction)

}