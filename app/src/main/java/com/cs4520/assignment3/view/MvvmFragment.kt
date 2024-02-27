package com.cs4520.assignment3.view

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import com.cs4520.assignment3.databinding.FragmentMvvmBinding
import com.cs4520.assignment3.viewmodel.CalculatorViewModel

class MvvmFragment : Fragment() {
    private val viewModel: CalculatorViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentMvvmBinding.inflate(inflater, container, false)

        binding.addButton.setOnClickListener { viewModel.add() }
        binding.subtractButton.setOnClickListener { viewModel.subtract() }
        binding.multiplyButton.setOnClickListener { viewModel.multiply() }
        binding.divideButton.setOnClickListener { viewModel.divide() }

        binding.num1Field.addTextChangedListener(MyTextWatcher(viewModel.num1))
        binding.num2Field.addTextChangedListener(MyTextWatcher(viewModel.num2))

        viewModel.result.observe(viewLifecycleOwner) {
            if (it.isNaN()) {
                Toast.makeText(context, it.toString(), Toast.LENGTH_SHORT).show()
                binding.resultField.text = ""
            } else {
                binding.resultField.text = it.toString()
            }
        }
        return binding.root
    }
}

private class MyTextWatcher(private val data: MutableLiveData<Double>) : TextWatcher {
    private var lastValue: Double? = null
    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        lastValue = data.value
    }

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

    override fun afterTextChanged(s: Editable?) {
        val newValue = s.toString().toDoubleOrNull()
        if (lastValue == newValue) return
        data.value = s.toString().toDoubleOrNull()
    }
}