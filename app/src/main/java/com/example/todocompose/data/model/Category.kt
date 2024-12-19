package com.example.todocompose.data.model

class Category (
    val name: String,
    val toDos: MutableList<TodoItem> = mutableListOf()
)