package com.skillforge.app.ui.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.skillforge.app.data.model.ApiResponse
import com.skillforge.app.ui.components.EnrollBottomBar
import com.skillforge.app.utils.UiState
import com.skillforge.app.viewmodel.HomeViewModel

@Composable
fun DetailScreen(
    navController: NavHostController,
    courseId: String,
    viewModel: HomeViewModel = viewModel()
) {
    val state by viewModel.uiState.collectAsState()
    when (state) {
        is UiState.Success -> {
            val response = (state as UiState.Success<ApiResponse>).data

            val course = response.categories
                    .flatMap { it.courses }
                    .first { it.id == courseId }

            Scaffold(
                bottomBar = {
                    EnrollBottomBar()
                }
            ) { padding ->
            DetailContent(
                course,
                navController,
                modifier = Modifier.padding(padding)
            )}
        }

        else -> {
            CircularProgressIndicator()
        }

    }

}