package com.devbeck.transactions

import org.springframework.boot.Banner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@ComponentScan(basePackages = ["com.devbeck.transactions"])
@EnableAutoConfiguration
@SpringBootApplication
class ApiTransactionsApplication

fun main(args: Array<String>) {

	val app = SpringApplication(ApiTransactionsApplication::class.java)
	app.setBannerMode(Banner.Mode.OFF)
	app.run(*args)
}
