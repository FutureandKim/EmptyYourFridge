package com.example.emptyyourfridge

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class IngredientsActivity : AppCompatActivity() {

    private val foodItems = arrayOf("달걀", "콩나물", "두부", "햄", "양파", "감자", "고구마", "토마토", "참치", "배추")
    private val selectedFoodList = ArrayList<String>()
    private lateinit var selectedFoodsTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingredients)

        val listView: ListView = findViewById(R.id.ingredientsListView)
        selectedFoodsTextView = findViewById(R.id.selectedFoodsTextView)

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_multiple_choice, foodItems)
        listView.adapter = adapter

        listView.setOnItemClickListener { _, _, position, _ ->
            val selectedFood = foodItems[position]

            if (listView.isItemChecked(position)) {
                // 선택된 음식 추가
                selectedFoodList.add(selectedFood)
            } else {
                // 선택 해제된 음식 제거
                selectedFoodList.remove(selectedFood)
            }

            updateSelectedFoodsText()
            // 추가 동작을 수행
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

