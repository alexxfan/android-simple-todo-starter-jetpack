package com.example.todocompose.data

import com.example.todocompose.data.model.Category

class CategoryStore(val categories: List<Category> = mutableListOf())

fun seedCategoryStore(): CategoryStore {
    val categories = mutableListOf(
        Category(id = 1, name = "Work", toDos = mutableListOf()),
        Category(id = 2, name = "Personal", toDos = mutableListOf()),
        Category(id = 3, name = "Study", toDos = mutableListOf()),
        Category(id = 4, name = "Gym", toDos = mutableListOf()),
        Category(id = 5, name = "Nutrition", toDos = mutableListOf()),
        Category(id = 6, name = "Shopping", toDos = mutableListOf()),
        Category(id = 7, name = "Family", toDos = mutableListOf()),
        Category(id = 8, name = "Hobbies", toDos = mutableListOf()),
        Category(id = 9, name = "Travel", toDos = mutableListOf()),
        Category(id = 10, name = "Other", toDos = mutableListOf()),
    )

    return CategoryStore(categories = categories)
}
