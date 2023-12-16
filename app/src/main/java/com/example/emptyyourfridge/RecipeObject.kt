package com.example.emptyyourfridge

object RecipeObject {
    data class Recipe(val name: String, val text: String)

    private val recipes: MutableList<Recipe> = mutableListOf()

    // Add a recipe to the list
    fun addRecipe(name: String, text: String) {
        val recipe = Recipe(name, text)
        recipes.add(recipe)
    }

    // Get all recipes as a list
    fun getAllRecipes(): List<Recipe> {
        return recipes.toList()
    }

    // Optionally, you can add other methods for managing recipes
    // For example, you might want to clear all recipes or remove a specific recipe.
}
