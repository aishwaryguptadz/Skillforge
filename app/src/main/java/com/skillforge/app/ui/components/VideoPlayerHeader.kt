package com.skillforge.app.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.PlayCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
            .background(Color.Black)
    ) {
        AsyncImage(
            model = course.thumbnailUrl,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(240.dp),
            contentScale = ContentScale.Crop
        )
        IconButton(
            onClick = {
                navController.popBackStack()
            },
            modifier = Modifier.padding(12.dp)
        ) {
            Icon(Icons.Default.ArrowBackIosNew, "back", tint = Color.White)
        }

        Icon(
            Icons.Default.PlayCircle,
            null,
            Modifier.size(80.dp).align(Alignment.Center),
            Color.White,
        )
    }
}