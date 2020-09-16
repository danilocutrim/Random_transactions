package com.devbeck.transactions.controller

import com.devbeck.transactions.model.Transaction
import com.devbeck.transactions.service.TransactionServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("")
class TransactionController {
    @Autowired
    lateinit var service: TransactionServiceImpl

    @GetMapping(value = ["/{id}/transacoes/{ano}/{mes}"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getTransaction(@PathVariable("id") id: Int,
                       @PathVariable("ano") ano: Int,
                       @PathVariable("mes") mes: Int
    ): ResponseEntity<List<Transaction>> {

        return ResponseEntity.ok(service.generateAleatoryTransactions(id,mes,ano))

    }

}