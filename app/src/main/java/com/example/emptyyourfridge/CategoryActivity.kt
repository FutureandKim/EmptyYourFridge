package com.example.emptyyourfridge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class CategoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)

        // get data by Intent
        val selectedFoodList = intent.getStringArrayListExtra("selectedFoodList")

        // UI에서 데이터를 표시할 TextView
        val selectedFoodTextView = findViewById<TextView>(R.id.selectedFoodTextView)

        // 받아온 데이터를 TextView에 설정
        if (selectedFoodList != null) {
            val foodListText = "Selected Food List: ${selectedFoodList.joinToString(", ")}"
            selectedFoodTextView.text = foodListText
        }
    }
}