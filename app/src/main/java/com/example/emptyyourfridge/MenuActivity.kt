package com.example.emptyyourfridge

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MenuActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val ingredientsTextView: TextView = findViewById(R.id.ingredientTextView)
        val categoryTextView: TextView = findViewById(R.id.catTextView)
        val recipeNameEditText: EditText = findViewById(R.id.recipeNameEditText)
        val recipeEditText: EditText = findViewById(R.id.editText)
        val saveButton:Button = findViewById(R.id.addButton)
        val viewRecipesButton:Button = findViewById(R.id.viewRecipesButton)

        ingredientsTextView.text = IngredientsObject.selectedIngredients().joinToString(", ")
        categoryTextView.text = CategoryObject.selectedCategory().toString()

        saveButton.setOnClickListener {
            val recipeName = recipeNameEditText.text.toString()
            val recipeText = recipeEditText.text.toString()
            val category = categoryTextView.text.toString()
            val ingredients = IngredientsObject.selectedIngredients()

            if (recipeName.isNotBlank() && recipeText.isNotBlank()) {
                RecipeObject.addRecipe(recipeName, recipeText, category, ingredients)
                showToast("Recipe saved!")
                recipeNameEditText.text.clear()
                recipeEditText.text.clear()
            } else {
                showToast("Please write both recipe name and text before saving.")
            }
        }

        viewRecipesButton.setOnClickListener {
            val intent = Intent(this, RecipeActivity::class.java)
            startActivity(intent)
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
