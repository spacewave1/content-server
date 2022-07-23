package com.spacewave.contentserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ContentServerApplication

fun main(args: Array<String>) {
	runApplication<ContentServerApplication>(*args)
}
