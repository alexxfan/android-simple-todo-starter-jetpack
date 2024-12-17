package com.example.todocompose.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.todocompose.data.Category
import com.example.todocompose.data.TodoItem
import kotlin.reflect.KFunction4


@Composable
fun TodoScreen(
    category: Category,
    onBack: () -> Unit,
    todoViewModel: TodoViewModel = viewModel(factory = TodoViewModel.Factory)
) {
    val todos = todoViewModel.todos

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Button(onClick = onBack) {
            Text("Back to Categories")
        }

        Text(
            text = "Tasks in ${category.name}",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(vertical = 8.dp)
        )

        TodoInput(onAddTodo = todoViewModel::addTodo)
        TodoList(todos = todos.value, onTodoClick = todoViewModel::toggleTodoStatus)
    }
}


@Composable
fun TodoList(todos: List<TodoItem>, onTodoClick: (TodoItem) -> Unit) {
    LazyColumn {
        items(todos) { todo ->
            TodoItemRow(todo = todo, onTodoClick = { onTodoClick(todo) })
        }
    }
}

@Composable
fun TodoItemRow(todo: TodoItem, onTodoClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onTodoClick() }
    ) {
        Text(text = todo.title, modifier = Modifier.weight(1f))
        Checkbox(checked = todo.isArchived, onCheckedChange = null)
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodoInput(onAddTodo: KFunction4<String, String, String, String, Unit>) {
//    var task by remember { mutableStateOf("") }
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var dueDate  by remember { mutableStateOf("") }
    var priority by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
    ) {
        TextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("Enter title") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 4.dp)
        )

        TextField(
            value = description,
            onValueChange = { description = it },
            label = { Text("Enter description") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 4.dp)
        )

        TextField(
            value = dueDate,
            onValueChange = { dueDate = it },
            label = { Text("Enter due date") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 4.dp)
        )

        TextField(
            value = priority,
            onValueChange = { priority = it },
            label = { Text("Enter priority") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )

        Button(
            onClick = {
                onAddTodo(title, description, dueDate, priority)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Add")
        }
    }
}
