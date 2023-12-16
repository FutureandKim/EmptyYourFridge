object CategoryObject {
    private val MenuList = ArrayList<String>()

    fun selectedCategory(): List<String> {
        return MenuList.toList()
    }

    fun addCategory(category: String) {
        MenuList.add(category)
    }

    fun removeCategory(category: String) {
        MenuList.remove(category)
    }

    fun removeAllCategories() {
        MenuList.clear()
    }
}
