package com.example.emptyyourfridge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val ingredientsList = IngredientListClass.selectedIngredients()
        val ingredientsTextView = findViewById<TextView>(R.id.ingredientTextView)
        ingredientsTextView.text = ingredientsList.subList(0, ingredientsList.size - 1).joinToString(", ") // 마지막 요소(음식 종류) 제외

        val categoryTextView = findViewById<TextView>(R.id.catTextView)
        categoryTextView.text = "${IngredientListClass.selectedIngredients().last()}"
    }
}