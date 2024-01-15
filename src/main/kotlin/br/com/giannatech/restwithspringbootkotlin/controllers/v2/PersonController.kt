package br.com.giannatech.restwithspringbootkotlin.controllers.v2

import br.com.giannatech.restwithspringbootkotlin.data.vo.v2.PersonVO
import br.com.giannatech.restwithspringbootkotlin.services.v2.PersonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v2persons")
class PersonController {

    @Autowired
    private lateinit var personService: PersonService

    @PostMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    fun create(@RequestBody personVO: PersonVO): ResponseEntity<PersonVO> =
            ResponseEntity.status(HttpStatus.CREATED).body(personService.create(personVO))

}