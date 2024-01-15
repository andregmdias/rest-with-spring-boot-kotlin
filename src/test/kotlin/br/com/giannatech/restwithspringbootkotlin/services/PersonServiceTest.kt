package br.com.giannatech.restwithspringbootkotlin.services

import br.com.giannatech.restwithspringbootkotlin.data.vo.v1.PersonVO
import br.com.giannatech.restwithspringbootkotlin.exceptions.UserNotFoundException
import br.com.giannatech.restwithspringbootkotlin.model.Person
import br.com.giannatech.restwithspringbootkotlin.repositories.PersonRepository
import br.com.giannatech.restwithspringbootkotlin.services.v1.PersonService
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.util.*

class PersonServiceTest {

    private val personRepository: PersonRepository = mockk(relaxed = true)

    private val personService: PersonService = PersonService(personRepository)

    private val person1: Person = Person(
            1L,
            "André Luiz",
            "Dias",
            "Rua dos Mecânicos",
            "Male"
    )

    private val person2: Person = Person(
            2L,
            "Heitor",
            "Dias",
            "Rua dos Mecânicos",
            "Male"
    )



    @Test
    @DisplayName("PersonService.findAll() -> when has no person in database, should return an empty list")
    fun testFindAll_whenHasNoPersonInDatabase_shouldReturnAnEmptyList() {

        every { personRepository.findAll() } returns emptyList()

        val result = personService.findAll()
        verify(exactly = 1) { personRepository.findAll() }
        assertEquals(result.size, 0)
        assertInstanceOf(List::class.java, result)
    }

    @Test
    @DisplayName("PersonService.findAll() -> when has persons in database, should return then all")
    fun testFindAll_whenHasPersonsInDatabase_shouldReturnThenAll() {

        every { personRepository.findAll() } returns listOf(person1, person2)

        val result = personService.findAll()
        verify(exactly = 1) { personRepository.findAll() }
        assertEquals(result.size, 2)
    }

    @Test
    @DisplayName("PersonService.findById() -> when has person in database with the given id, should return it")
    fun testFindById_whenHasPersonWithTheGivenId_shouldReturnIt() {
        every { personRepository.findById(1) } returns Optional.of(person1)

        val result = personService.findById(1)
        verify(exactly = 1) { personRepository.findById(1) }
        assertNotNull(result)
        assertInstanceOf(PersonVO::class.java, result)
        assertEquals(person1.id, result?.id)
    }

    @Test
    @DisplayName("PersonService.findById() -> when has no person in database with the given id, should throws an exception")
    fun testFindById_whenHasPersonWithTheGivenId_shouldThrowsAnException() {
        every { personRepository.findById(99) } returns Optional.empty()


        val result: Exception = assertThrows(UserNotFoundException::class.java) { personService.findById(99) }

        verify(exactly = 1) { personRepository.findById(99) }
        val errorMessage = result.message
        assertEquals("User not found with the given id", errorMessage)
    }

    @Test
    @DisplayName("PersonService.update -> when has no person with the given id, should update the person with the update params")
    fun testUpdate_whenHasPersonWithTheGivenId_shouldUpdatethePersonWithTheUpdateParams() {
        val updateParams: Person = Person(address = "Rua dos Funileiros")


    }

    @Test
    fun create() {
    }

    @Test
    fun delete() {
    }
}

