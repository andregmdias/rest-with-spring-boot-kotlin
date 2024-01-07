package br.com.giannatech.restwithspringbootkotlin.services

import br.com.giannatech.restwithspringbootkotlin.model.Person
import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicLong
import java.util.logging.Logger


@Service
class PersonService {


    private val counter: AtomicLong = AtomicLong()

    private val logger: Logger = Logger.getLogger(PersonService::class.java.name)

    fun findById(id: Long): Person {
        logger.info("Searching a person with the id: $id ...")
        return Person(
                counter.incrementAndGet(),
                "André",
                "Dias",
                "rua dos mecanicos",
                "Male"
        )
    }
}