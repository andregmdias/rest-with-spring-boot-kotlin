package br.com.giannatech.restwithspringbootkotlin.controllers

import br.com.giannatech.restwithspringbootkotlin.model.Person
import br.com.giannatech.restwithspringbootkotlin.services.PersonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/persons")
class PersonController {

    @Autowired
    private lateinit var personService: PersonService

    @GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    fun index(): ResponseEntity<List<Person>> = ResponseEntity.ok(personService.findAll())


    @GetMapping("/{id}", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun show(@PathVariable(value = "id") id: Long): ResponseEntity<Person> =
            ResponseEntity.ok(personService.findById(id))

    @PostMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    fun create(@RequestBody person: Person): ResponseEntity<Person> =
            ResponseEntity.status(HttpStatus.CREATED).body(personService.create(person))


    @DeleteMapping("/{id}")
    fun delete(@PathVariable(value = "id") id: Long): ResponseEntity<Nothing> {
        personService.delete(id)
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build()
    }
}