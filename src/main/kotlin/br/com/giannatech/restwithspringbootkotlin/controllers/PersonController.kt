package br.com.giannatech.restwithspringbootkotlin.controllers

import br.com.giannatech.restwithspringbootkotlin.model.Person
import br.com.giannatech.restwithspringbootkotlin.services.PersonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/persons")
class PersonController {

    @Autowired
    private lateinit var personService: PersonService

    @GetMapping("/{id}", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun show(@PathVariable(value = "id") id: Long): ResponseEntity<Person> {
        val fetched = personService.findById(id)

        return ResponseEntity.ok(fetched)
    }

}