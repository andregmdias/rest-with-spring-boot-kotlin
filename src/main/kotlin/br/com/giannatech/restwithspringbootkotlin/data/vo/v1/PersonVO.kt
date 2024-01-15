package br.com.giannatech.restwithspringbootkotlin.data.vo.v1


data class PersonVO(
        var id: Long? = null,
        var firstName: String? = null,
        var lastName: String? = null,
        var address: String? = null,
        var gender: String? = null
)

