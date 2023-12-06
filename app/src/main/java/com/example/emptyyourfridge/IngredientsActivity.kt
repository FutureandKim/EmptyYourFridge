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
    private val vegetableItems = arrayOf("감자", "고구마", "당근", "대파", "마늘", "브로콜리", "시금치", "새송이", "양파", "콩나물", "팽이버섯")
    private val meatItems = arrayOf("닭고기", "돼지고기", "소고기")
    private val proteinItems = arrayOf("계란", "두부", "생선", "콩")
    private val dairyItems = arrayOf("우유", "치즈")

    private lateinit var ingredientsTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingredients)

        val gridView1: GridView = findViewById(R.id.vegetableGridView)
        val gridView2: GridView = findViewById(R.id.meatGridView)
        val gridView3: GridView = findViewById(R.id.proteinGridView)
        val gridView4: GridView = findViewById(R.id.dairyGridView)
        ingredientsTextView = findViewById(R.id.selectedFoodsTextView)

        // Set up adapter for foodItems
        val adapter1 = ArrayAdapter(this, android.R.layout.simple_list_item_multiple_choice, vegetableItems)
        gridView1.adapter = adapter1

        // Set up adapter for foodItems2
        val adapter2 = ArrayAdapter(this, android.R.layout.simple_list_item_multiple_choice, meatItems)
        gridView2.adapter = adapter2

        val adapter3 = ArrayAdapter(this, android.R.layout.simple_list_item_multiple_choice, proteinItems)
        gridView3.adapter = adapter3

        val adapter4 = ArrayAdapter(this, android.R.layout.simple_list_item_multiple_choice, dairyItems)
        gridView4.adapter = adapter4

        // Set click listener for foodItems
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
        ingredientsTextView.text = "선택한 식재료: ${IngredientsObject.selectedIngredients().joinToString(", ")}"
    }

    private fun moveToCategoryActivity() {
        startActivity(Intent(this, CategoryActivity::class.java))
    }
}


