package br.com.giannatech.restwithspringbootkotlin.repositories

import br.com.giannatech.restwithspringbootkotlin.model.Person
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonRepository : JpaRepository<Person, Long>