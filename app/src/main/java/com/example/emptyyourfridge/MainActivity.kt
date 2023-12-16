package com.example.emptyyourfridge

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val goToIngredientsButton: Button = findViewById(R.id.goToIngredientsButton)

        goToIngredientsButton.setOnClickListener {
            startActivity(Intent(this@MainActivity, IngredientsActivity::class.java))
        }
    }
}