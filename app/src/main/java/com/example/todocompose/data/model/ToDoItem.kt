package com.example.todocompose.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todoItems")
data class TodoItem(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val description: String,
    val dueDate: String,
    val priority: String,
    val isArchived: Boolean = false
)
