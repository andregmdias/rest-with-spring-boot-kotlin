package br.com.giannatech.restwithspringbootkotlin.repositories

import br.com.giannatech.restwithspringbootkotlin.model.Person
import org.springframework.data.jpa.repository.JpaRepository

interface PersonRepository : JpaRepository<Person, Long> {}