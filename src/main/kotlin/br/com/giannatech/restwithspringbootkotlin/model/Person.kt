package br.com.giannatech.restwithspringbootkotlin.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Table
import jakarta.persistence.Id
import java.util.*


@Entity
@Table(name = "tb_persons")
data class Person(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,
        @Column(name = "first_name", nullable = false, length = 80)
        var firstName: String? = null,
        @Column(name = "last_name", nullable = false, length = 80)
        var lastName: String? = null,
        @Column(nullable = false, length = 100)
        var address: String? = null,
        @Column(nullable = false, length = 6)
        var gender: String? = null,
        @Column
        var birthday: Date? = null
){
        constructor(firstName: String, lastName: String, address: String, gender: String):
                this(null, firstName, lastName, address, gender)
        constructor(firstName: String, lastName: String, address: String, gender: String, birthday: Date):
                this(null, firstName, lastName, address, gender, birthday)

}

