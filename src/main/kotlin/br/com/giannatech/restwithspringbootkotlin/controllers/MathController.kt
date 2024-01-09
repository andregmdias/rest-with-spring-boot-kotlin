package br.com.giannatech.restwithspringbootkotlin.controllers

import br.com.giannatech.restwithspringbootkotlin.services.MathService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/math")
class MathController(
        @Autowired
        val mathService: MathService
) {
    @GetMapping(value = ["/sum/{numberOne}/{numberTwo}"])
    fun sum(@PathVariable(value = "numberOne") numberOne: String,
            @PathVariable(value = "numberTwo") numberTwo: String): Double {

        return mathService.sum(numberOne, numberTwo)
    }

    @GetMapping(value = ["/sub/{numberOne}/{numberTwo}"])
    fun subtraction(@PathVariable(value = "numberOne") numberOne: String,
                     @PathVariable(value = "numberTwo") numberTwo: String): Double {
        return mathService.subtraction(numberOne, numberTwo)
    }

    @GetMapping(value = ["/div/{numberOne}/{numberTwo}"])
    fun div(@PathVariable(value = "numberOne") numberOne: String,
            @PathVariable(value = "numberTwo") numberTwo: String): Double {
        return mathService.division(numberOne, numberTwo)
    }

    @GetMapping(value = ["/multi/{numberOne}/{numberTwo}"])
    fun multiplication(@PathVariable(value = "numberOne") numberOne: String,
                       @PathVariable(value = "numberTwo") numberTwo: String): Double {
        return mathService.multiplication(numberOne, numberTwo)
    }

    @GetMapping(value = ["/mean/{numberOne}/{numberTwo}"])
    fun mean(@PathVariable(value = "numberOne") numberOne: String,
             @PathVariable(value = "numberTwo") numberTwo: String): Double {
        return mathService.mean(numberOne, numberTwo)
    }

    @GetMapping(value = ["/sqrt/{numberOne}"])
    fun square(@PathVariable(value = "numberOne") numberOne: String): Double {
        return mathService.square(numberOne)
    }
}