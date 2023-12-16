package com.example.emptyyourfridge

object RecipeObject {
    data class Recipe(val name: String, val text: String, val category: String, val ingredients: List<String>)

    private val recipes: MutableList<Recipe> = mutableListOf()

    fun addRecipe(name: String, text: String, category: String, ingredients: List<String>) {
        val recipe = Recipe(name, text, category, ingredients)
        recipes.add(recipe)
    }

    fun getAllRecipes(): List<Recipe> {
        return recipes.toList()
    }

}
