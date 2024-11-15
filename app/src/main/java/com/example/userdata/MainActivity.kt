package com.example.myapp

import android.content.Intent
import android.os.Build.VERSION_CODES.R
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize UI components
        val nameInput = findViewById<EditText>(R.id.name_input)
        val yearInput = findViewById<EditText>(R.id.year_input)
        val submitButton = findViewById<Button>(R.id.submit_button)

        // Handle button click
        submitButton.setOnClickListener {
            val name = nameInput.text.toString()
            val yearOfBirth = yearInput.text.toString()

            if (name.isEmpty() || yearOfBirth.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            } else {
                val year = yearOfBirth.toIntOrNull()
                if (year == null) {
                    Toast.makeText(this, "Enter a valid year", Toast.LENGTH_SHORT).show()
                } else {
                    // Calculate the age
                    val age = 2024 - year
                    // Pass data to DisplayActivity
                    val intent = Intent(this, DisplayActivity::class.java)
                    intent.putExtra("user_name", name)
                    intent.putExtra("user_age", age)
                    startActivity(intent)
                }
            }
        }
    }
}
