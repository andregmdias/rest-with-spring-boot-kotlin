package br.com.giannatech.restwithspringbootkotlin.services.v2

import br.com.giannatech.restwithspringbootkotlin.data.vo.v2.PersonVO
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

    fun create(personVO: PersonVO): PersonVO {
        val person: Person = DozerMapper.parseObject(personVO, Person::class.java)
        return DozerMapper.parseObject(personRepository.save(person), PersonVO::class.java)
    }


}