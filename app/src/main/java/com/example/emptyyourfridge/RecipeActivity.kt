package com.example.emptyyourfridge

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class RecipeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe)

        // Assuming you have a TextView with the id "recipeTextView" in your layout
        val recipeTextView = findViewById<TextView>(R.id.recipeTextView)

        // Get all recipes from RecipeObject
        val recipes = RecipeObject.getAllRecipes()

        // Display recipes in the TextView
        recipeTextView.text = recipes.joinToString("\n")
    }
}