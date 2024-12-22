package com.example.todocompose.data

import com.example.todocompose.data.model.TodoItem

interface TodoRepository {
    fun getTodos(): List<TodoItem>
    fun addTodo(todo: TodoItem)
    fun updateTodo(todo: TodoItem)
    fun deleteTodo(todo: TodoItem)
}