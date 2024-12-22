package com.example.todocompose.data.model

import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class CategoryTest {

    @BeforeEach
    fun setUp() {
    }

    @AfterEach
    fun tearDown() {
    }

    @Test
    fun getId() {
        val category = Category(1, "football")
        assertEquals(1, category.id)
    }

    @Test
    fun getName() {
        val category = Category(1, "football")
        assertEquals("football", category.name)

    }

    @Test
    fun getToDos() {
        val todo1 = TodoItem(id = 1, title = "hello", description = "yes", dueDate = "1/1/23", priority = "high", isArchived = false, categoryId = 1)
        val todo2 = TodoItem(id = 2, title = "world", description = "sir", dueDate = "1/2/24", priority = "medium", isArchived = true, categoryId = 1)

        val category = Category(1, "Work", mutableListOf(todo1, todo2))

        assertEquals(2, category.toDos.size)
        assertTrue(category.toDos.contains(todo1))
        assertTrue(category.toDos.contains(todo2))
    }
}