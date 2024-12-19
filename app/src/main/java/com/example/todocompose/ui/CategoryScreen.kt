package com.example.todocompose.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.todocompose.R
import com.example.todocompose.data.model.Category
import com.example.todocompose.data.seedCategoryStore

@Composable
fun CategoryApp(
    categoryViewModel: CategoryViewModel = viewModel(
        factory = CategoryViewModel.Factory
    ),
    onCategoryClick: (Category) -> Unit = {}
) {
    val uiState = categoryViewModel.uiState.collectAsState().value

    CategoryScreen(
        isLinearLayout = uiState.isLinearLayout,
        toggleContentDescription = uiState.toggleContentDescription,
        toggleIcon = uiState.toggleIcon,
        onToggleLayout = { categoryViewModel.selectLayout(!uiState.isLinearLayout) },
        onCategoryClick = onCategoryClick
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun CategoryScreen(
    isLinearLayout: Boolean,
    toggleContentDescription: Int,
    toggleIcon: Int,
    onToggleLayout: () -> Unit,
    onCategoryClick: (Category) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.top_bar_name)) },
                actions = {
                    IconButton(onClick = onToggleLayout) {
                        Icon(
                            painter = painterResource(id = toggleIcon),
                            contentDescription = stringResource(id = toggleContentDescription)
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        if (isLinearLayout) {
            CategoryLinearLayout(
                categories = seedCategoryStore().categories,
                onCategoryClick = onCategoryClick,
                contentPadding = innerPadding
            )
        } else {
            CategoryGridLayout(
                categories = seedCategoryStore().categories,
                onCategoryClick = onCategoryClick,
                contentPadding = innerPadding
            )
        }
    }
}

@Composable
fun CategoryLinearLayout(
    categories: List<Category>,
    onCategoryClick: (Category) -> Unit,
    contentPadding: PaddingValues = PaddingValues(0.dp)
) {
    LazyColumn(
        contentPadding = contentPadding,
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small))
    ) {
        items(categories) { category ->
            CategoryCard(category = category, onCategoryClick = onCategoryClick)
        }
    }
}

@Composable
fun CategoryGridLayout(
    categories: List<Category>,
    onCategoryClick: (Category) -> Unit,
    contentPadding: PaddingValues
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = contentPadding,
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small)),
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_big))
    ) {
        items(categories) { category ->
            CategoryCard(category = category, onCategoryClick = onCategoryClick)
        }
    }
}

@Composable
fun CategoryCard(category: Category, onCategoryClick: (Category) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .padding(dimensionResource(R.dimen.padding_small))
            .clickable { onCategoryClick(category) },
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),
        shape = MaterialTheme.shapes.medium
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = dimensionResource(R.dimen.padding_small))
        ) {
            Text(
                text = category.name,
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.onPrimary,
                textAlign = TextAlign.Center
            )
        }
    }
}

