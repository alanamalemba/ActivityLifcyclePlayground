package com.example.activitylifcycleplayground

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button_exit).setOnClickListener {
            Log.d("alan", "In exitButton click listener")
            finish()
        }

        findViewById<Button>(R.id.button_open_a_non_full_screen_activity).setOnClickListener {
            Log.d("alan", "In open a non full-screen activity click listener")
            startActivity(Intent(this, ANonFullScreenActivity::class.java))
        }

        Log.d("alan", "In onCreate")
    }

    override fun onRestart() {
        super.onRestart()

        Log.d("alan", "In onRestart")
    }

    override fun onStart() {
        super.onStart()

        Log.d("alan", "In onStart")
    }

    override fun onResume() {
        super.onResume()

        Log.d("alan", "In onResume")
    }

    override fun onPause() {
        super.onPause()

        Log.d("alan", "In onPause")
    }

    override fun onStop() {
        super.onStop()

        Log.d("alan", "In onStop")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.d("alan", "In onDestroy")
    }
}