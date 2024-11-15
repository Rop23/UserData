package com.example.myapp

import android.R
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DisplayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)


        // Initialize the TextView
        val displayText = findViewById<TextView>(R.id.display_text)

        // Get data from the Intent
        val name = intent.getStringExtra("user_name")
        val age = intent.getIntExtra("user_age", 0)

        // Display the data
        displayText.text = "Name: $name\nAge: $age"
    }
}
