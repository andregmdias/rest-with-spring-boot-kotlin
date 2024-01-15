package br.com.giannatech.restwithspringbootkotlin.data.vo.v2

import java.util.Date

data class PersonVO(
        var id: Long? = null,
        var firstName: String? = null,
        var lastName: String? = null,
        var address: String? = null,
        var gender: String? = null,
        var birthDay: Date? = null
)