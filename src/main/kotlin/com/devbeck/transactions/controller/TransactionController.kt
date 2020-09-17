package com.devbeck.transactions.controller

import com.devbeck.transactions.model.Transaction
import com.devbeck.transactions.service.TransactionServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("")

class TransactionController {

    @Autowired
    lateinit var service: TransactionServiceImpl

    //Endpoint responsável por uma transação, através de um do id, mes e ano
    @CrossOrigin
    @GetMapping(value = ["/{id}/transacoes/{ano}/{mes}"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getTransactionByVariables(@PathVariable("id") id: Int,
                                  @PathVariable("ano") ano: Int,
                                  @PathVariable("mes") mes: Int
    ): ResponseEntity<Any> {
        return ResponseEntity.ok(service.addDuplicateTransactionAndMapToDto(id, mes, ano))
    }

}