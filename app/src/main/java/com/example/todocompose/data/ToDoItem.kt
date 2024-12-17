package com.example.todocompose.data

data class TodoItem(
    val id: Int,
    val title: String,
    val description: String,
    val dueDate: String,
    val priority: String,
    val isArchived: Boolean = false
)
