package com.example.emptyyourfridge

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class RecipeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe)

        val recipeTextView = findViewById<TextView>(R.id.recipeTextView)

        val recipes = RecipeObject.getAllRecipes()

        val recipeText = recipes.joinToString("\n\n") {
            "<${it.name}>\n" +
            "- Category: ${it.category}\n" +
            "- Ingredients: ${it.ingredients.joinToString(", ")}\n" +
            "- Recipe: \n ${it.text}\n"
        }
        recipeTextView.text = recipeText

        val nextButton: Button = findViewById(R.id.mainButton)
        nextButton.setOnClickListener {
            moveToCategoryActivity()
        }
    }
    private fun moveToCategoryActivity() {
        startActivity(Intent(this, MainActivity::class.java))
    }
}
