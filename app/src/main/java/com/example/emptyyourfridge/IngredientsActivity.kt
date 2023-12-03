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
    private val vegetableItems = arrayOf("감자", "고구마", "당근", "대파", "마늘", "브로콜리", "시금치", "양파", "콩나물") //야채
    private val meatItems = arrayOf("닭고기", "돼지고기", "소고기") //고기
    private val proteinItems = arrayOf("계란", "두부", "생선", "콩") //단백질
    private val dairyItems = arrayOf("우유", "치즈") //유제품


    private val selectedFoodList = ArrayList<String>()
    private lateinit var selectedFoodsTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingredients)

        val gridView1: GridView = findViewById(R.id.vegetableGridView)
        val gridView2: GridView = findViewById(R.id.meatGridView)
        val gridView3: GridView = findViewById(R.id.proteinGridView)
        val gridView4: GridView = findViewById(R.id.dairyGridView)
        selectedFoodsTextView = findViewById(R.id.selectedFoodsTextView)

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

    private fun handleItemClick(selectedFood: String) {
        if (selectedFoodList.contains(selectedFood)) {
            selectedFoodList.remove(selectedFood)
        } else {
            selectedFoodList.add(selectedFood)
        }

        updateSelectedFoodsText()
    }

    private fun updateSelectedFoodsText() {
        val selectedFoodsText = "냉장고 속 음식: ${selectedFoodList.joinToString(", ")}"
        selectedFoodsTextView.text = selectedFoodsText
    }

    private fun moveToCategoryActivity() {
        val intent = Intent(this, CategoryActivity::class.java)
        intent.putStringArrayListExtra("selectedFoodList", selectedFoodList)
        startActivity(intent)
    }
}


