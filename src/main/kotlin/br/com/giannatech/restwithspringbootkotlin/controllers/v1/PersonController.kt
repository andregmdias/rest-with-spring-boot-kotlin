package br.com.giannatech.restwithspringbootkotlin.controllers.v1

import br.com.giannatech.restwithspringbootkotlin.data.vo.v1.PersonVO
import br.com.giannatech.restwithspringbootkotlin.services.v1.PersonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/persons")
class PersonController {

    @Autowired
    private lateinit var personService: PersonService

    @GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    fun index(): ResponseEntity<List<PersonVO>> = ResponseEntity.ok(personService.findAll())


    @GetMapping("/{id}", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun show(@PathVariable(value = "id") id: Long): ResponseEntity<PersonVO> =
            ResponseEntity.ok(personService.findById(id))

    @PostMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    fun create(@RequestBody personVO: PersonVO): ResponseEntity<PersonVO> =
            ResponseEntity.status(HttpStatus.CREATED).body(personService.create(personVO))


    @DeleteMapping("/{id}")
    fun delete(@PathVariable(value = "id") id: Long): ResponseEntity<Nothing> {
        personService.delete(id)
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build()
    }
}