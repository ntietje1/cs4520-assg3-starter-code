package com.cs4520.assignment3.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CalculatorViewModel: ViewModel() {
    val num1 = MutableLiveData<Double>()
    val num2 = MutableLiveData<Double>()
    val result = MutableLiveData<Double>()

    fun add() {
        performOperation { a, b -> a + b }
    }

    fun subtract() {
        performOperation { a, b -> a - b }
    }

    fun multiply() {
        performOperation { a, b -> a * b }
    }

    fun divide() {
        performOperation { a, b -> if (b != 0.0) a / b else Double.NaN }
    }

    private fun performOperation(operation: (Double, Double) -> Double) {
        try {
            val a = num1.value?.toDouble()
            val b = num2.value?.toDouble()

            if (a == null || b == null) {
                throw NullPointerException()
            } else {
                result.value = operation(a, b)
            }

        } catch (e: NumberFormatException) {
            result.value = Double.NaN
        } catch (e: NullPointerException) {
            result.value = Double.NaN
        }
    }
}