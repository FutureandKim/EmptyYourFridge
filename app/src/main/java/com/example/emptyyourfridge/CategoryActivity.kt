package com.example.emptyyourfridge

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class CategoryActivity : AppCompatActivity() {
    private var selectedButton: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)

        // print ingredientList
        val ingredientsTextView = findViewById<TextView>(R.id.ingredientsTextView)
        ingredientsTextView.text = IngredientsObject.selectedIngredients().joinToString(", ")


        // button click
        val buttonIds = listOf(R.id.button, R.id.button2, R.id.button3, R.id.button4, R.id.button5, R.id.button6)
        for (buttonId in buttonIds) {
            val button = findViewById<Button>(buttonId)
            button.setOnClickListener {
                handleButtonClick(button)
            }
        }

        val nextButton: Button = findViewById(R.id.nextButton)
        nextButton.setOnClickListener {
            moveToMenuActivity()
        }
    }

    private fun moveToMenuActivity() {
        startActivity(Intent(this, MenuActivity::class.java))
    }

    private fun handleButtonClick(button: Button) {
        if (selectedButton != null) {
            // 이미 선택된 버튼이 있는 경우
            selectedButton?.setBackgroundColor(Color.parseColor("#848484"))
            CategoryObject.removeCategory(selectedButton?.text.toString()) //이전 선택 해제
        }

        // 새로운 버튼 선택하고 리스트에 추가
        selectedButton = button
        button.setBackgroundColor(Color.parseColor("#FE9A2E"))
        CategoryObject.addCategory(button.text.toString())

    }

}