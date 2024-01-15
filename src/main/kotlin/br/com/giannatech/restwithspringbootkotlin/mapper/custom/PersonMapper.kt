package br.com.giannatech.restwithspringbootkotlin.mapper.custom

import br.com.giannatech.restwithspringbootkotlin.data.vo.v2.PersonVO
import br.com.giannatech.restwithspringbootkotlin.model.Person
import org.springframework.stereotype.Service

@Service
class PersonMapper {
    fun mapEntityToVo(person: Person, personVO: PersonVO): PersonVO? {
        return null;
    }
}