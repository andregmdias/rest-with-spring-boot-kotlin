package br.com.giannatech.restwithspringbootkotlin.exceptions

import java.lang.RuntimeException

class UserNotFoundException(exception: String?): RuntimeException(exception)