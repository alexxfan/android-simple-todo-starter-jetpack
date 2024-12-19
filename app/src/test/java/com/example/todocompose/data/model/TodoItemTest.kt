package com.example.todocompose.data.model

import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test


class TodoItemTest {

    @BeforeEach
    fun setUp() {
    }

    @AfterEach
    fun tearDown() {
    }

    @Test
    fun getId() {
        val test = TodoItem(1, "title", "description", "1/1/2000", "high", false)
        assertEquals(1, test.id,)
    }

    @Test
    fun getTitle() {
        val test = TodoItem(1, "title", "description", "1/1/2000", "high", false)
        assertEquals("title", test.title)
    }

    @Test
    fun getDescription() {
        val test = TodoItem(1, "title", "description", "1/1/2000", "high", false)
        assertEquals("description", test.description)
    }

    @Test
    fun getDueDate() {
        val test = TodoItem(1, "title", "description", "1/1/2000", "high", false)
        assertEquals("1/1/2000", test.dueDate)
    }

    @Test
    fun getPriority() {
        val test = TodoItem(1, "title", "description", "1/1/2000", "high", false)
        assertEquals("high", test.priority)
    }

    @Test
    fun isArchived() {
        val test = TodoItem(1, "title", "description", "1/1/2000", "high", false)
        assertEquals(false, test.isArchived)
    }
}