package com.example.todocompose.data

class Category (
    val name: String,
    val toDos: MutableList<TodoItem> = mutableListOf()
)