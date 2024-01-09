package br.com.giannatech.restwithspringbootkotlin.services

import br.com.giannatech.restwithspringbootkotlin.exceptions.UserNotFoundException
import br.com.giannatech.restwithspringbootkotlin.model.Person
import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicLong
import java.util.logging.Logger


@Service
class PersonService(
        val counter: AtomicLong = AtomicLong(),
        val p1: Person = Person(
        counter.incrementAndGet(),
        "André",
        "Dias",
        "rua dos mecanicos",
        "Male"
        ),
        val p2: Person = Person(
                counter.incrementAndGet(),
                "André",
                "Dias",
                "rua dos mecanicos",
                "Male"
        ),
        val allPersons: MutableList<Person> = mutableListOf(p1,p2)
) {
    private val logger: Logger = Logger.getLogger(PersonService::class.java.name)

    fun findAll(): List<Person> {
        logger.info("Retrieving all persons")
        return allPersons
    }

    fun findById(id: Long): Person? {
        logger.info("Searching a person with the id: $id ...")
        val fetched: Person? = allPersons.find { person -> person.id == id }

        return fetched
    }

    fun create(person: Person): Person {
        person.id = counter.incrementAndGet()
        allPersons.addLast(person)
        return person
    }

    fun delete(id: Long) {
        val person: Person? = allPersons.find { person -> person.id == id }
        if(null == person) {
            throw UserNotFoundException("User not found with the given id")
        }
        allPersons.remove(person)
    }
}