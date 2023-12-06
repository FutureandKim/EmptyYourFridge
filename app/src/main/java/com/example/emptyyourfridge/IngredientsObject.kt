package com.example.emptyyourfridge

object IngredientsObject {
    private val IngredientsList = ArrayList<String>()
    fun selectedIngredients(): List<String> {
        return IngredientsList.toList()
    }
    fun addIngredients(food: String) {
        IngredientsList.add(food)
    }
    fun removeIngredients(food: String) {
        IngredientsList.remove(food)
    }
}