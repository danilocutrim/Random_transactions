package com.devbeck.transactions

import com.devbeck.transactions.model.Transaction
import com.devbeck.transactions.service.TransactionServiceImpl
import com.github.javafaker.Faker
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import java.sql.Timestamp
import java.time.LocalDate
import java.time.temporal.TemporalAdjusters
import java.util.*

@SpringBootTest
class ApiTransactionsApplicationTests {
	@Test
	fun faker(){
		val faker = Faker(Random(24))
		val rand = Random(24).nextInt(100)+1
		val list = mutableListOf<Transaction>()
		for(i in 1..rand){
			val transaction = Transaction(
					rand,
					faker.regexify("([bcdfghjklmnpqrstvxyz][aeiou]){10,120}"),
					true,
					faker.number().numberBetween(-9999999,9999999),
					faker.number().numberBetween(1577836800,1609459199).toLong()

			)
			list.add(transaction)
		}
		for(i in list){

			println(i.toString())
		}
	}

	@Test
	fun getTimeInterval(){
		val initdate = LocalDate.of(2020,10,1).atStartOfDay()
		val lastday = initdate.with(TemporalAdjusters.lastDayOfMonth()).plusMinutes(1439)
		val times = Timestamp.valueOf(initdate).time
		val times2 = Timestamp.valueOf(lastday).time
		println(times2)
		println(times)


	}

	@Test
	fun test(){
		val classe = TransactionServiceImpl()
		val list = classe.generateAleatoryTransactions(5,10,2020)
		for(i in list)
			println(i)
	}

}
