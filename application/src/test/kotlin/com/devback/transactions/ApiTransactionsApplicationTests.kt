package com.devback.transactions

import com.devback.transactions.service.TransactionServiceImpl
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ApiTransactionsApplicationTests {
    @Test
    fun `verifica se a lista de transações é deterministica`() {
        val service = TransactionServiceImpl()
        val fakerTransactionList1 = service.generateAleatoryTransactionsList(4555, 12, 2020)
        val fakerTransactionList2 = service.generateAleatoryTransactionsList(4555, 12, 2020)

        assert(fakerTransactionList1 == fakerTransactionList2)
    }

    @Test
    fun `verifica se as listas diferem entre si`() {
        val service = TransactionServiceImpl()
        val fakerTransactionList1 = service.generateAleatoryTransactionsList(4555, 12, 2020)
        val fakerTransactionList2 = service.generateAleatoryTransactionsList(4556, 12, 2020)

        assert(fakerTransactionList1 != fakerTransactionList2)
    }
}