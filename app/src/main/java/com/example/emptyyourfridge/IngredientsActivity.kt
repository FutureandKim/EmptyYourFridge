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
    private val foodItems = arrayOf("당근", "감자", "양파", "마늘", "브로콜리", "고구마", "시금치", " ", "소고기", "돼지고기", "우유", "콩")
    private val selectedFoodList = ArrayList<String>()
    private lateinit var selectedFoodsTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingredients)

        val gridView: GridView = findViewById(R.id.ingredientsGridView)
        selectedFoodsTextView = findViewById(R.id.selectedFoodsTextView)

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_multiple_choice, foodItems)
        gridView.adapter = adapter

        gridView.setOnItemClickListener { _, _, position, _ ->
            val selectedFood = foodItems[position]

            if (gridView.isItemChecked(position)) {
                // 선택한 음식 추가
                selectedFoodList.add(selectedFood)
            } else {
                // 선택 해제한 음식 제거
                selectedFoodList.remove(selectedFood)
            }

            updateSelectedFoodsText()
            // 추가 동작
        }

        val nextButton: Button = findViewById(R.id.nextButton)
        nextButton.setOnClickListener{
            moveToCategoryActivity()
        }
    }

    private fun updateSelectedFoodsText() {
        val selectedFoodsText = "냉장고 속 음식: ${selectedFoodList.joinToString(", ")}"
        selectedFoodsTextView.text = selectedFoodsText
    }

    private fun moveToCategoryActivity() {
        val intent = Intent(this, CategoryActivity::class.java)

        intent.putStringArrayListExtra("selectedFoodList", selectedFoodList)

        // 다음 화면을 시작합니다.
        startActivity(intent)
    }

}


