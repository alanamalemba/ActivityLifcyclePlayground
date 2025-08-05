package com.example.activitylifcycleplayground

import android.os.Bundle
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.activitylifcycleplayground.databinding.ActivityMainBinding
import java.io.File

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpBackButtonListener()

        binding.buttonExit.setOnClickListener {
            finish()
        }
    }

    private fun setUpBackButtonListener() {
        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                showDialog()
            }
        }

        onBackPressedDispatcher.addCallback(this, callback)
    }

    fun showDialog() {
        AlertDialog.Builder(this).setTitle("Warning!").setMessage("Leave App ?")
            .setView(R.layout.dialog_warning).setPositiveButton("Yes") { _, _ ->
                finish()
            }.setNegativeButton("No") { dialog, _ ->
                dialog.dismiss()
            }.setNeutralButton("More") { dialog, _ ->
                dialog.dismiss()
            }.show()
    }
}
