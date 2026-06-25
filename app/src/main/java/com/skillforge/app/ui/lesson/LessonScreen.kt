package com.skillforge.app.ui.lesson

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.skillforge.app.data.model.ApiResponse
import com.skillforge.app.utils.UiState
import com.skillforge.app.viewmodel.HomeViewModel

@Composable
fun LessonScreen(
    navController: NavHostController,
    courseId: String,
    lessonId: String,
    viewModel: HomeViewModel = viewModel()
    ) {
    val state by viewModel.uiState.collectAsState()

    when (state) {
        is UiState.Success -> {
            val data = (state as UiState.Success<ApiResponse>).data
            val course = data.categories
                .flatMap { it.courses }
                .first { it.id == courseId }
            val lesson = course.lessons
                .first { it.id == lessonId }

            LessonContent(navController, course, lesson)
        }

        is UiState.Loading -> {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }
        else -> {}
    }
}