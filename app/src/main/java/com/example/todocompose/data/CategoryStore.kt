package com.example.todocompose.data

class CategoryStore(val categories: List<Category> = mutableListOf())

fun seedCategoryStore(): CategoryStore {
    val categories = mutableListOf(
        Category(name = "Work", toDos = mutableListOf()),
        Category(name = "Personal", toDos = mutableListOf()),
        Category(name = "Study", toDos = mutableListOf()),
        Category(name = "Gym", toDos = mutableListOf())
    )

    return CategoryStore(categories = categories)
}
