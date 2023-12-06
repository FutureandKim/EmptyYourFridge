package com.example.emptyyourfridge

object CategoryObject {
    private val MenuList = ArrayList<String>()
    fun selectedCategory(): List<String> {
        return MenuList.toList()
    }
    fun addCategory(food: String) {
        MenuList.add(food)
    }
    fun removeCategory(food: String) {
        MenuList.remove(food)
    }
}