package com.cs4520.assignment3

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.cs4520.assignment3.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)

    }
}