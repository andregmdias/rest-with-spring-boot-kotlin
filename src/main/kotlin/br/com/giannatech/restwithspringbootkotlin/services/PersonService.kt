package br.com.giannatech.restwithspringbootkotlin.services

import br.com.giannatech.restwithspringbootkotlin.data.vo.v1.PersonVO
import br.com.giannatech.restwithspringbootkotlin.exceptions.UserNotFoundException
import br.com.giannatech.restwithspringbootkotlin.mapper.DozerMapper
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

    fun findAll(): List<PersonVO> {
        logger.info("Retrieving all persons")
        val persons: List<Person> = personRepository.findAll()
        return DozerMapper.parseListObjects(persons, PersonVO::class.java)
    }

    fun findById(id: Long): PersonVO? {
        logger.info("Searching a person with the id: $id ...")
        val fetched: Person? =
                personRepository
                        .findById(id)
                        .orElseThrow {
                            UserNotFoundException("User not found with the given id")
                        }
        return DozerMapper.parseObject(fetched, PersonVO::class.java)
    }

    fun create(personVO: PersonVO): PersonVO {
        val person: Person = DozerMapper.parseObject(personVO, Person::class.java)
        return DozerMapper.parseObject(personRepository.save(person), PersonVO::class.java)
    }

    fun delete(id: Long) = personRepository.deleteById(id)

}