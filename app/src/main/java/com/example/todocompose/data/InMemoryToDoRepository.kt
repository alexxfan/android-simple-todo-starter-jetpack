package com.example.todocompose.data

import com.example.todocompose.data.model.TodoItem

class InMemoryTodoRepository : TodoRepository {
    private var todoList = mutableListOf<TodoItem>()

    override fun getTodos(): List<TodoItem> = todoList.toList()

    override fun addTodo(todo: TodoItem) {
        todoList.add(todo)
    }

    override fun updateTodo(todo: TodoItem) {
        val index = todoList.indexOfFirst { it.id == todo.id }
        if (index != -1) {
            todoList[index] = todo
        }
    }

    override fun deleteTodo(todo: TodoItem) {
        todoList.removeIf { it.id == todo.id }
    }
}