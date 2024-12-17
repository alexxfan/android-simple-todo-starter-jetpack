package com.example.todocompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.todocompose.data.Category
import com.example.todocompose.data.seedCategoryStore
import com.example.todocompose.ui.CategoryScreen
import com.example.todocompose.ui.TodoScreen
import com.example.todocompose.ui.theme.ToDoComposeTheme

//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            ToDoComposeTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    TodoScreen()
//                }
//            }
//        }
//    }
//}


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ToDoComposeTheme {
                var currentScreen by rememberSaveable { mutableStateOf("home") }
                var selectedCategory by rememberSaveable { mutableStateOf<Category?>(null) }
                val categoryStore = seedCategoryStore()

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    when (currentScreen) {
                        "home" -> {
                            CategoryScreen(
                                categoryStore = categoryStore,
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
                                    onBack = { currentScreen = "home" }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
