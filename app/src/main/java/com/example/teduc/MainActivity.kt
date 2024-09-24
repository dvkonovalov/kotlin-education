package com.example.teduc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.teduc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var counter : Int = 0

    private companion object {
        const val KEY_COUNTER = "counter"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        savedInstanceState?.let {
            counter = it.getInt(KEY_COUNTER, 0)
        }

        updateCounterText(binding)

        binding.btnAdd.setOnClickListener{
            counter++
            updateCounterText(binding)
        }

        binding.btnReset.setOnClickListener{
            counter = 0
            updateCounterText(binding)
        }
    }

    private fun updateCounterText(binding: ActivityMainBinding) {
        binding.counterTextView.text = counter.toString()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_COUNTER, counter)
    }
    
}