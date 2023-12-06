package com.example.emptyyourfridge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val ingredientsTextView = findViewById<TextView>(R.id.ingredientTextView)
        ingredientsTextView.text = IngredientsObject.selectedIngredients().joinToString(", ")

        val categoryTextView = findViewById<TextView>(R.id.catTextView)
        categoryTextView.text = CategoryObject.selectedCategory().toString()
    }
}