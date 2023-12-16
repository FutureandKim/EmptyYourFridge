package com.example.emptyyourfridge

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MenuActivity : AppCompatActivity() {
    private lateinit var ingredientsTextView: TextView
    private lateinit var categoryTextView: TextView
    private lateinit var recipeNameEditText: EditText // 이 부분을 추가하세요
    private lateinit var recipeEditText: EditText
    private lateinit var saveButton: Button
    private lateinit var viewRecipesButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        ingredientsTextView = findViewById(R.id.ingredientTextView)
        categoryTextView = findViewById(R.id.catTextView)
        recipeNameEditText = findViewById(R.id.recipeNameEditText)
        recipeEditText = findViewById(R.id.editText)
        saveButton = findViewById(R.id.addButton)
        viewRecipesButton = findViewById(R.id.viewRecipesButton)

        ingredientsTextView.text = IngredientsObject.selectedIngredients().joinToString(", ")
        categoryTextView.text = CategoryObject.selectedCategory().toString()

        saveButton.setOnClickListener {
            val recipeName = recipeNameEditText.text.toString()
            val recipeText = recipeEditText.text.toString()

            if (recipeName.isNotBlank() && recipeText.isNotBlank()) {
                RecipeObject.addRecipe(recipeName, recipeText)
                showToast("레시피가 저장되었습니다!")
                recipeNameEditText.text.clear()
                recipeEditText.text.clear()
            } else {
                showToast("레시피 이름과 텍스트를 모두 입력한 후 저장하세요.")
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
