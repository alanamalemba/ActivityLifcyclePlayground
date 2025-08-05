package com.example.activitylifcycleplayground

import android.os.Build
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.activitylifcycleplayground.databinding.ActivityMainBinding
import java.io.File

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                val userMessage = binding.editTextMessage.text.toString()
                File(filesDir, "user_message.txt").writeText(userMessage, Charsets.UTF_8)
                finish()
            }
        }

        onBackPressedDispatcher.addCallback(this, callback)


        binding.buttonExit.setOnClickListener {
            finish()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}