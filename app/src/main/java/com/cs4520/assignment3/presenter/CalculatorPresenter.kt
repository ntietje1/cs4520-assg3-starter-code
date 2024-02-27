package com.cs4520.assignment3.presenter

import com.cs4520.assignment3.view.CalculatorView

class CalculatorPresenter(private val view: CalculatorView) {
    fun add(num1: Double?, num2: Double?) {
        performOperation(num1, num2) { a, b -> a + b }
    }

    fun subtract(num1: Double?, num2: Double?) {
        performOperation(num1, num2) { a, b -> a - b }
    }

    fun multiply(num1: Double?, num2: Double?) {
        performOperation(num1, num2) { a, b -> a * b }
    }

    fun divide(num1: Double?, num2: Double?) {
        performOperation(num1, num2) { a, b -> if (b != 0.0) a / b else Double.NaN }
    }

    private fun performOperation(a: Double?, b: Double?, operation: (Double, Double) -> Double) {
        try {
            if (a == null || b == null) {
                throw NullPointerException()
            } else {
                val res = operation(a, b)
                view.displayResult(res.toString())
            }

        } catch (e: NumberFormatException) {
            view.displayError("NaN")
            view.displayResult("")
        } catch (e: NullPointerException) {
            view.displayError("NaN")
            view.displayResult("")
        }
    }
}