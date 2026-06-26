package com.skillforge.app.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Fullscreen
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.skillforge.app.data.model.Course

@Composable
fun VideoPlayerHeader(
    navController: NavHostController,
    course: Course
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(240.dp)
    ) {

        AsyncImage(
            model = course.thumbnailUrl,
            contentDescription = course.title,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.35f))
        )

        Surface(
            modifier = Modifier
                .padding(16.dp)
                .size(42.dp)
                .align(Alignment.TopStart),
            shape = CircleShape,
            color = Color.Black.copy(alpha = 0.35f)
        ) {
            IconButton(
                onClick = { navController.popBackStack() }
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBackIosNew,
                    contentDescription = "Back",
                    tint = Color.White
                )
            }
        }

        Surface(
            modifier = Modifier
                .size(88.dp)
                .align(Alignment.Center),
            shape = CircleShape,
            color = Color.Black.copy(alpha = 0.45f)
        ) {
            Icon(
                Icons.Default.PlayArrow,
                contentDescription = "Play",
                tint = Color.White,
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxSize()
            )
        }

        Surface(
            modifier = Modifier
                .padding(16.dp)
                .size(42.dp)
                .align(Alignment.TopEnd),
            shape = CircleShape,
            color = Color.Black.copy(alpha = 0.35f)
        ) {
            IconButton(
                onClick = {}
            ) {
                Icon(
                    imageVector = Icons.Default.Fullscreen,
                    contentDescription = "Fullscreen",
                    tint = Color.White
                )
            }
        }
    }
}