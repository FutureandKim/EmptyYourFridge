package com.example.emptyyourfridge

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CategoryObject.removeAllCategories()
        IngredientsObject.removeAllIngredients()

        val goToIngredientsButton: Button = findViewById(R.id.goToIngredientsButton)
        val goToRecipeButton: Button = findViewById(R.id.goToRecipeButton)

        goToIngredientsButton.setOnClickListener {
            startActivity(Intent(this@MainActivity, IngredientsActivity::class.java))
        }

        goToRecipeButton.setOnClickListener{
            startActivity(Intent(this@MainActivity, RecipeActivity::class.java))
        }
    }
}