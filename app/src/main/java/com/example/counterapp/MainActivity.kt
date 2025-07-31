package com.example.counterapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    private var count = 0
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val numberText = findViewById<TextView>(R.id.text)
        val inc = findViewById<Button>(R.id.increment)
        val dec = findViewById<Button>(R.id.decrement)
        val reset = findViewById<Button>(R.id.reset)

        inc.setOnClickListener {
            count++
            numberText.text = count.toString()
        }
        dec.setOnClickListener {
            count--
            numberText.text = count.toString()

        }
        reset.setOnClickListener {
            count = 0
            numberText.text = count.toString()
        }
    }
}