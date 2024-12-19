package com.example.todocompose.data

import com.example.todocompose.data.model.Category

class CategoryStore(val categories: List<Category> = mutableListOf())

fun seedCategoryStore(): CategoryStore {
    val categories = mutableListOf(
        Category(name = "Work", toDos = mutableListOf()),
        Category(name = "Personal", toDos = mutableListOf()),
        Category(name = "Study", toDos = mutableListOf()),
        Category(name = "Gym", toDos = mutableListOf()),
        Category(name = "Nutrition", toDos = mutableListOf()),
        Category(name = "Shopping", toDos = mutableListOf()),
        Category(name = "Family", toDos = mutableListOf()),
        Category(name = "Hobbies", toDos = mutableListOf()),
        Category(name = "Travel", toDos = mutableListOf()),
        Category(name = "Other", toDos = mutableListOf()),
    )

    return CategoryStore(categories = categories)
}
