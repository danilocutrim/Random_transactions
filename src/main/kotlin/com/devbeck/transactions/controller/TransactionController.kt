package com.devbeck.transactions.controller

import com.devbeck.transactions.dto.TransactionResponseDTO
import com.devbeck.transactions.model.Transaction
import com.devbeck.transactions.service.TransactionServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("")
class TransactionController {
    @Autowired
    lateinit var service: TransactionServiceImpl

    @GetMapping(value = ["/{id}/transacoes/ano/mes"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getTransaction(@PathVariable("id") id: Int,
                       @PathVariable("ano") ano: Int,
                       @PathVariable("mes") mes: Int
    ): ResponseEntity<List<TransactionResponseDTO>> {
        return ResponseEntity.ok(service.findByParameters(id,timestamp = ano.toLong()))
    }

    @GetMapping(value = ["list"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getTransaction(): ResponseEntity<List<TransactionResponseDTO>> {
        return ResponseEntity.ok(service.findAllTransactions())
    }

    @PostMapping(value = ["newtransaction"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun createTransaction(@RequestBody transaction: Transaction): ResponseEntity<Boolean> {
        return ResponseEntity.ok(service.saveTransaction(transaction))
    }
}