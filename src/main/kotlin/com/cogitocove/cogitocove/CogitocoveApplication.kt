package com.cogitocove.cogitocove

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class CogitocoveApplication

fun main(args: Array<String>) {
	runApplication<CogitocoveApplication>(*args)
}

@RestController
class MessageController {

	@GetMapping("/")
	fun index(@RequestParam(name = "name", required = false) name: String?): String {
		return if (name.isNullOrBlank()) {
			"Hello, unnamed!"
		} else {
			"Hello, $name!"
		}
	}
}
