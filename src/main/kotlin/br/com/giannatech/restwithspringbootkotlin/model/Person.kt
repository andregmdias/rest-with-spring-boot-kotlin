package br.com.giannatech.restwithspringbootkotlin.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Table
import jakarta.persistence.Id


@Entity
@Table(name = "tb_persons")
data class Person(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = 0,
        @Column(name = "first_name", nullable = false, length = 80)
        var firstName: String = "",
        @Column(name = "last_name", nullable = false, length = 80)
        var lastName: String = "",
        @Column(nullable = false, length = 100)
        var address: String = "",
        @Column(nullable = false, length = 6)
        var gender: String = ""
)