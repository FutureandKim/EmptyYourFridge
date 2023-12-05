package com.example.emptyyourfridge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        // Intent에서 값 추출
        val selectedButtonText = intent.getStringExtra("selectedButtonText")
        // 화면에 출력
        val resultTextView = findViewById<TextView>(R.id.selectedFoodTextViewInMenu)
        resultTextView.text = "$selectedButtonText"
    }
}