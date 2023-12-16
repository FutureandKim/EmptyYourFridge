package com.example.emptyyourfridge

object IngredientsObject {
    private val IngredientsList = ArrayList<String>()
    fun selectedIngredients(): List<String> {
        return IngredientsList.toList()
    }
    fun addIngredients(ingredients: String) {
        IngredientsList.add(ingredients)
    }
    fun removeIngredients(ingredients: String) {
        IngredientsList.remove(ingredients)
    }
    fun removeAllIngredients() {
        IngredientsList.clear()
    }

}