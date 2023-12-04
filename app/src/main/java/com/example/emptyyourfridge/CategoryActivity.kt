package com.example.emptyyourfridge

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class CategoryActivity : AppCompatActivity() {
    private var selectedButton: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)

        // get data by Intent
        val selectedFoodList = intent.getStringArrayListExtra("selectedFoodList")
        val selectedFoodTextView = findViewById<TextView>(R.id.selectedFoodTextView)

        // 받아온 데이터를 TextView에 설정
        if (selectedFoodList != null) {
            val foodListText = "선택한 식재료: ${selectedFoodList.joinToString(", ")}"
            selectedFoodTextView.text = foodListText
        }

        // button
        val buttonIds = listOf(R.id.button, R.id.button2, R.id.button3, R.id.button4, R.id.button5, R.id.button6)
        for (buttonId in buttonIds) {
            val button = findViewById<Button>(buttonId)
            button.setOnClickListener {
                selectedButton?.setBackgroundColor(Color.parseColor("#848484"))
                selectedButton = button
                button.setBackgroundColor(Color.parseColor("#FE9A2E")) // 다른 색상 변경
                handleButtonClick(button)
            }
        }
    }

    private fun handleButtonClick(button: Button) {
        // 클릭한 버튼에 따른 추가적인 동작
    }
}
