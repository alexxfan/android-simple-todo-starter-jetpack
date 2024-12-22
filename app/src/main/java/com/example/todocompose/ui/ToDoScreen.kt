package com.example.todocompose.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults.cardElevation
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
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.todocompose.R
import com.example.todocompose.data.model.Category
import com.example.todocompose.data.model.TodoItem


@Composable
fun TodoScreen(
    category: Category,
    onBack: () -> Unit,
    todoViewModel: TodoViewModel = viewModel(factory = TodoViewModel.Factory)
) {

    val todos = todoViewModel.todos.value.filter { it.categoryId == category.id }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(dimensionResource(R.dimen.padding_big))
    ) {
        Button(onClick = onBack) {
            Text(stringResource(R.string.back_button))
        }

        Text(
            text = "Tasks in ${category.name}",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(vertical = dimensionResource(R.dimen.padding_small))
        )

        TodoInput(
            onAddTodo = { title, description, dueDate, priority, category ->
                todoViewModel.addTodo(title, description, dueDate, priority, category)
            },
            category = category
        )

        val archivedTodos = todos.filter { it.isArchived }

        if (archivedTodos.isNotEmpty()) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = dimensionResource(R.dimen.padding_small)),
                verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_very_small))
            ) {
                Button(
                    onClick = {
                        archivedTodos.forEach { todoViewModel.deleteTodo(it) }
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Delete Archived Todos")
                }
            }
        }

        TodoList(todos, onTodoClick = todoViewModel::toggleTodoStatus)
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
fun TodoItemRow(todo: TodoItem, onTodoClick: (TodoItem) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .graphicsLayer(alpha = if (todo.isArchived) 0.5f else 1f)
            .padding(vertical = dimensionResource(R.dimen.padding_very_small)),

        elevation = cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(dimensionResource(R.dimen.padding_medium)),
            verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small))
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = todo.title,
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.weight(1f)
                )
                Checkbox(
                    checked = todo.isArchived,
                    onCheckedChange = { isChecked ->
                        onTodoClick(todo.copy(isArchived = isChecked))
                    }
                )
            }
            Text(
                text = "Description: ${todo.description}",
                style = MaterialTheme.typography.bodyMedium,
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Priority: ${todo.priority}",
                    style = MaterialTheme.typography.bodySmall
                )
                Text(
                    text = "Due: ${todo.dueDate}",
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}





@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodoInput(onAddTodo:(String, String, String, String, Category) -> Unit , category: Category) {
//    var task by remember { mutableStateOf("") }
    var title by rememberSaveable { mutableStateOf("") }
    var description by rememberSaveable { mutableStateOf("") }
    var dueDate  by rememberSaveable { mutableStateOf("") }
    var priority by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(dimensionResource(R.dimen.padding_small))
    ) {
        TextField(
            value = title,
            onValueChange = { title = it },
            label = { Text(stringResource(R.string.title)) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = dimensionResource(R.dimen.padding_very_small))
        )

        TextField(
            value = description,
            onValueChange = { description = it },
            label = { Text(stringResource(R.string.description)) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = dimensionResource(R.dimen.padding_very_small))
        )

        TextField(
            value = dueDate,
            onValueChange = { dueDate = it },
            label = { Text(stringResource(R.string.due_date)) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = dimensionResource(R.dimen.padding_very_small))
        )

        TextField(
            value = priority,
            onValueChange = { priority = it },
            label = { Text(stringResource(R.string.priority)) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = dimensionResource(R.dimen.padding_small))
        )

        Button(
            onClick = {
                if (title.isNotEmpty() && description.isNotEmpty() && dueDate.isNotEmpty() && priority.isNotEmpty()) {
                    onAddTodo(title, description, dueDate, priority, category)
                    title = ""
                    description = ""
                    dueDate = ""
                    priority = ""
                }
            },
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(stringResource(R.string.add_button))
        }
    }
}
