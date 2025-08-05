package com.example.activitylifcycleplayground

import android.os.Bundle
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
        binding.buttonSave.setOnClickListener {
            saveMessage()
        }

        binding.textViewPreview.text = savedInstanceState?.getString("savedTextViewMessage")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val savedTextViewMessage = binding.textViewPreview.text.toString()

        outState.putString("savedTextViewMessage", savedTextViewMessage)
    }

    private fun saveMessage() {

        val userMessage = binding.editTextMessage.text.toString()

        File(filesDir, "user_message.txt").writeText(userMessage)

        binding.textViewPreview.text = getString(R.string.your_message, userMessage)
        binding.editTextMessage.setText("")
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
