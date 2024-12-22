package com.example.todocompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.todocompose.data.model.Category
import com.example.todocompose.ui.CategoryApp
//import com.example.todocompose.ui.CategoryScreen
import com.example.todocompose.ui.TodoScreen
import com.example.todocompose.ui.theme.ToDoComposeTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ToDoComposeTheme {
                var currentScreen by rememberSaveable { mutableStateOf("home") }
                var selectedCategory by rememberSaveable { mutableStateOf<Category?>(null) }
//                val categoryStore = seedCategoryStore()

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    when (currentScreen) {
                        "home" -> {
                            CategoryApp(
//                                categoryStore = categoryStore,
                                onCategoryClick = { category ->
                                    selectedCategory = category
                                    currentScreen = "categoryDetails"
                                }
                            )
                        }
                        "categoryDetails" -> {
                            selectedCategory?.let { category ->
                                TodoScreen(
                                    category = category,
                                    onBack = { currentScreen = "home" },
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
