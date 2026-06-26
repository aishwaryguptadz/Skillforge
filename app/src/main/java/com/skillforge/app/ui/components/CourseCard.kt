package com.skillforge.app.ui.components

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.skillforge.app.data.model.Course

@Composable
fun CourseCard(course: Course, onClick: () -> Unit) {
    Card(
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp, horizontal = 20.dp),
        onClick = onClick,
        border = BorderStroke(1.dp, Color(0xFFC4C4C4))
    ) {
        Row (
            modifier = Modifier.background(Color.White).padding(8.dp)
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(course.thumbnailUrl)
                    .crossfade(true)
                    .build(),
                contentDescription = null,
                modifier = Modifier
                    .height(125.dp)
                    .width(150.dp)
                    .clip(RoundedCornerShape(16.dp)),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier.padding(16.dp).fillMaxWidth()
            ) {
                Text(
                    course.level.uppercase(),
                    color = if (course.level.uppercase() == "BEGINNER") Color(0xFF32CD32) else Color.Yellow,
                    style = MaterialTheme.typography.labelMedium
                )

                Spacer(Modifier.height(8.dp))
                
                Text(
                    course.title,
                    style = MaterialTheme.typography.titleMedium
                )

                Spacer(Modifier.height(4.dp))

                Text(
                    course.instructor.name,
                    color = Color.Gray,
                    style = MaterialTheme.typography.bodySmall
                )

                Spacer(Modifier.height(8.dp))

                Row() {
                    Text("⭐ ${course.rating}")
                    Spacer(Modifier.width(16.dp))
                    Icon(Icons.Default.AccessTime, null)
                    Text(" ${course.durationHours}h")
                }
            }
        }
    }
}