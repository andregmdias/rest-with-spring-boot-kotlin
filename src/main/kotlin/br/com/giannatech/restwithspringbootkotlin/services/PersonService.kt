package br.com.giannatech.restwithspringbootkotlin.services

import br.com.giannatech.restwithspringbootkotlin.exceptions.UserNotFoundException
import br.com.giannatech.restwithspringbootkotlin.model.Person
import br.com.giannatech.restwithspringbootkotlin.repositories.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.logging.Logger


@Service
class PersonService(
        @Autowired
        val personRepository: PersonRepository
) {
    private val logger: Logger = Logger.getLogger(PersonService::class.java.name)

    fun findAll(): List<Person> {
        logger.info("Retrieving all persons")
        return personRepository.findAll()
    }

    fun findById(id: Long): Person? {
        logger.info("Searching a person with the id: $id ...")
        val fetched: Person? =
                personRepository
                        .findById(id)
                        .orElseThrow{
                            UserNotFoundException("User not found with the given id")
                        }
        return fetched
    }

    fun create(person: Person): Person = personRepository.save(person)

    fun delete(id: Long) = personRepository.deleteById(id)
}