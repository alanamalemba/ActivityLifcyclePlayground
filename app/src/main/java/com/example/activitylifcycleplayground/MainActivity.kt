package com.example.activitylifcycleplayground

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.activitylifcycleplayground.databinding.ActivityMainBinding
import java.io.File

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.buttonExit.setOnClickListener {
            finish()
        }
    }

    override fun onStop() {
        super.onStop()

        val userMessage = binding.editTextMessage.text.toString()

        File(filesDir, "user_message.txt").writeText(userMessage, Charsets.UTF_8)
    }
}