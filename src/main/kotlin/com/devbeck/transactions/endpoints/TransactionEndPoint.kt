package com.devbeck.transactions.endpoints

import com.devbeck.transactions.dto.TransactionBuildDTO
import com.devbeck.transactions.dto.TransactionResponseDTO
import com.devbeck.transactions.transaction.Transaction
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.lang.Exception

@RestController
@RequestMapping("")
class TransactionEndPoint {

    @GetMapping(value = ["/{id}/transacoes/ano/mes"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getTransaction(
            @PathVariable("id") id: Int,
            @PathVariable("ano") ano: Int,
            @PathVariable("mes") mes: Int
    ): ResponseEntity<List<TransactionResponseDTO>> {
        val timestamp = mes
        val transactionList = Transaction.queryTransactionByParameters(id, mes.toLong())

        return if (transactionList.isNotEmpty()) {
            ResponseEntity.ok(transactionList)
        } else {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @GetMapping(value = ["list"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getTransaction(): ResponseEntity<List<TransactionBuildDTO>> {
        val transactionList = Transaction.queryTransaction()

        return if (transactionList.isNotEmpty()) {
            ResponseEntity.ok(transactionList)
        } else {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @PostMapping(value = ["newtransaction"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun createTransaction(@RequestBody transaction: TransactionBuildDTO): ResponseEntity<String> {
        return try {
            ResponseEntity.ok(Transaction.newTransaction(transaction).toString())

        } catch (e: IllegalArgumentException) {
            ResponseEntity.badRequest().body("Transação invalida  - ${e.localizedMessage}")
        }
    }
}