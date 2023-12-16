package com.example.emptyyourfridge

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.GridView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class IngredientsActivity : AppCompatActivity() {

    //ingredients list
    private val vegetableItems = arrayOf("Avocado", "Bean sprouts", "Broccoli", "Cabbage", "Carrot", "Cucumber", "Garlic", "Green onion", "Mushroom", "Onion", "Pepper", "Potato", "Pumpkin", "Soybean", "Spinach", "Sweet potato", "Tofu", "Tomato")
    private val meatItems = arrayOf("Beef", "Chicken", "Pork")
    private val proteinItems = arrayOf("Egg", "Salmon", "Shrimp", "Squid", "Tuna")
    private val dairyItems = arrayOf("Milk", "Cheddar", "Mozzarella")

    private lateinit var ingredientsTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingredients)

        val gridView1: GridView = findViewById(R.id.vegetableGridView)
        val gridView2: GridView = findViewById(R.id.meatGridView)
        val gridView3: GridView = findViewById(R.id.proteinGridView)
        val gridView4: GridView = findViewById(R.id.dairyGridView)
        ingredientsTextView = findViewById(R.id.selectedFoodsTextView)

        val adapter1 = ArrayAdapter(this, android.R.layout.simple_list_item_multiple_choice, vegetableItems)
        gridView1.adapter = adapter1

        val adapter2 = ArrayAdapter(this, android.R.layout.simple_list_item_multiple_choice, meatItems)
        gridView2.adapter = adapter2

        val adapter3 = ArrayAdapter(this, android.R.layout.simple_list_item_multiple_choice, proteinItems)
        gridView3.adapter = adapter3

        val adapter4 = ArrayAdapter(this, android.R.layout.simple_list_item_multiple_choice, dairyItems)
        gridView4.adapter = adapter4


        gridView1.setOnItemClickListener { _, _, position, _ ->
            handleItemClick(vegetableItems[position])
        }

        // Set click listener for foodItems2
        gridView2.setOnItemClickListener { _, _, position, _ ->
            handleItemClick(meatItems[position])
        }

        gridView3.setOnItemClickListener { _, _, position, _ ->
            handleItemClick(proteinItems[position])
        }

        gridView4.setOnItemClickListener { _, _, position, _ ->
            handleItemClick(dairyItems[position])
        }

        val nextButton: Button = findViewById(R.id.nextButton)
        nextButton.setOnClickListener{
            moveToCategoryActivity()
        }
    }

    private fun handleItemClick(ingredients: String) {
        if (IngredientsObject.selectedIngredients().contains(ingredients)) {
            IngredientsObject.removeIngredients(ingredients) // remove food already on the list
        } else {
            IngredientsObject.addIngredients(ingredients)
        }
        updateIngredients()
    }

    private fun updateIngredients() {
        ingredientsTextView.text = "CHOICE: ${IngredientsObject.selectedIngredients().joinToString(" ")}"
    }

    private fun moveToCategoryActivity() {
        startActivity(Intent(this, CategoryActivity::class.java))
    }
}


