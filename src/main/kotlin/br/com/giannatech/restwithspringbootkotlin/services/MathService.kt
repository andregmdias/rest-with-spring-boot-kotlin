package br.com.giannatech.restwithspringbootkotlin.services

import br.com.giannatech.restwithspringbootkotlin.exceptions.UnsupportedMathOperationException
import org.springframework.stereotype.Service
import kotlin.math.sqrt

@Service
class MathService {
    
    fun sum(numberOne: String, numberTwo: String): Double {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw UnsupportedMathOperationException("Please set a numeric value!")

        return convertToDouble(numberOne) + convertToDouble(numberTwo)
    }

    fun subtraction(numberOne: String, numberTwo: String): Double {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw UnsupportedMathOperationException("Please set a numeric value!")

        return convertToDouble(numberOne) - convertToDouble(numberTwo)
    }

    fun multiplication(numberOne: String, numberTwo: String): Double {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw UnsupportedMathOperationException("Please set a numeric value!")

        return convertToDouble(numberOne) * convertToDouble(numberTwo)
    }

    fun division(numberOne: String, numberTwo: String): Double {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw UnsupportedMathOperationException("Please set a numeric value!")

        return convertToDouble(numberOne) / convertToDouble(numberTwo)
    }

    fun mean(numberOne: String, numberTwo: String): Double {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw UnsupportedMathOperationException("Please set a numeric value!")

        return (convertToDouble(numberOne) + convertToDouble(numberTwo)) / 2
    }

    fun square(numberOne: String): Double {
        if (!isNumeric(numberOne))
            throw UnsupportedMathOperationException("Please set a numeric value!")

        return sqrt(convertToDouble(numberOne))
    }

    private fun convertToDouble(strNumber: String): Double {
        if (strNumber.isBlank()) return 0.0

        val number = strNumber.replace(",", ".")

        return if (isNumeric(number)) number.toDouble() else 0.0
    }

    private fun isNumeric(strNumber: String): Boolean {
        if (strNumber.isBlank()) return false

        val number = strNumber.replace(",".toRegex(), ".")

        return number.matches("""[-+]?[0-9]*\.?[0-9]+""".toRegex())
    }
}