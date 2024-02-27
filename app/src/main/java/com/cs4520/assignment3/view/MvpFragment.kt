package com.cs4520.assignment3.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.cs4520.assignment3.databinding.FragmentMvpBinding
import com.cs4520.assignment3.presenter.CalculatorPresenter

class MvpFragment: Fragment(), CalculatorView {
    private lateinit var presenter: CalculatorPresenter
    private lateinit var binding: FragmentMvpBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMvpBinding.inflate(inflater, container, false)
        presenter = CalculatorPresenter(this)
        binding.addButton.setOnClickListener {
            presenter.add(binding.num1Field.text.toString().toDoubleOrNull(), binding.num2Field.text.toString().toDoubleOrNull())
        }
        binding.subtractButton.setOnClickListener {
            presenter.subtract(binding.num1Field.text.toString().toDoubleOrNull(), binding.num2Field.text.toString().toDoubleOrNull())
        }
        binding.multiplyButton.setOnClickListener {
            presenter.multiply(binding.num1Field.text.toString().toDoubleOrNull(), binding.num2Field.text.toString().toDoubleOrNull())
        }
        binding.divideButton.setOnClickListener {
            presenter.divide(binding.num1Field.text.toString().toDoubleOrNull(), binding.num2Field.text.toString().toDoubleOrNull())
        }
        return binding.root
    }

    override fun displayResult(result: String) {
        binding.resultField.text = result
    }

    override fun displayError(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}