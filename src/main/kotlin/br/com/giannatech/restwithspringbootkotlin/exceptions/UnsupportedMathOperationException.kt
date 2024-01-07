package br.com.giannatech.restwithspringbootkotlin.exceptions

import java.lang.RuntimeException

class UnsupportedMathOperationException(exception: String?): RuntimeException(exception)