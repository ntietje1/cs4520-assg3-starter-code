package com.cs4520.assignment3.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.cs4520.assignment3.R
import com.cs4520.assignment3.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.buttonMVP.setOnClickListener { navigateToMVPFragment() }
        binding.buttonMVVM.setOnClickListener { navigateToMVVMFragment() }
        return binding.root
    }

    private fun navigateToMVPFragment() {
        val navController = findNavController()
        navController.navigate(R.id.action_homeFragment_to_mvpFragment)
    }

    private fun navigateToMVVMFragment() {
        val navController = findNavController()
        navController.navigate(R.id.action_homeFragment_to_mvvmFragment)
    }
}