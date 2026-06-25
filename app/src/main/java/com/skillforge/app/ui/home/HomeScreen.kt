package com.skillforge.app.ui.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.skillforge.app.data.model.ApiResponse
import com.skillforge.app.navigation.Screen
import com.skillforge.app.ui.components.CategoryChip
import com.skillforge.app.ui.components.CourseCard
import com.skillforge.app.ui.components.HeaderSection
import com.skillforge.app.ui.components.SearchSection
import com.skillforge.app.utils.UiState
import com.skillforge.app.viewmodel.HomeViewModel

@Composable
fun HomeScreen(
    navController: NavHostController,
    viewModel: HomeViewModel = viewModel()
) {
    val state by viewModel.uiState.collectAsState()

    when (state) {
        is UiState.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

        is UiState.Error<*> -> {
            val message = (state as UiState.Error<*>).message

            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(message)
            }
        }

        is UiState.Success -> {
            val data = (state as UiState.Success<ApiResponse>).data
            LazyColumn {
                item {
                    HeaderSection()
                }
                item {
                    Spacer(Modifier.height(12.dp))
                    SearchSection()
                }
                item {
                    Spacer(Modifier.height(20.dp))
                    Text(
                        "Categories",
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.padding(horizontal = 20.dp)
                    )
                    Spacer(Modifier.height(4.dp))
                }
                item {
                    LazyRow {
                        items(data.categories) {
                            CategoryChip(it)
                        }
                    }
                }
                item {
                    Spacer(Modifier.height(20.dp))
                    Text(
                        "Popular Courses",
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.padding(horizontal = 20.dp)
                    )
                }
                data.categories.forEach { category ->
                    items(category.courses) { course ->
                        CourseCard(
                            course = course,
                            onClick = {
                                navController.navigate(
                                    Screen.Detail.createRoute(course.id)
                                )
                            }
                        )
                    }
                }
            }
        }
    }
}
