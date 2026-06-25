package com.skillforge.app.ui.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.skillforge.app.data.model.Course
import com.skillforge.app.navigation.Screen
import com.skillforge.app.ui.components.LessonCard

@Composable
fun DetailContent(
    course: Course,
    navController: NavHostController,
    modifier: Modifier = Modifier
) {

    LazyColumn(
        modifier = modifier.fillMaxSize()
    ) {
        item {
            AsyncImage(
                model = course.thumbnailUrl,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(240.dp),
                contentScale = ContentScale.Crop
            )
        }

        item {
            Column(
                modifier = Modifier.padding(20.dp)
            ) {
                LazyRow() {
                    items(course.tags) { item ->
                        Text(text = item + ", ", modifier = Modifier.fillMaxWidth(), color = Color.Gray)
                    }
                }

                Text(
                    course.title,
                    style = MaterialTheme.typography.titleLarge
                )

                Spacer(Modifier.height(8.dp))

                Text(course.subtitle, color = Color.Gray)

                Spacer(Modifier.height(12.dp))

                Row() {
                    Text("⭐ ${course.rating}")

                    Spacer(Modifier.width(20.dp))

                    Text(course.studentsEnrolled.toString())

                    Spacer(Modifier.width(20.dp))

                    Icon(Icons.Default.AccessTime, null, modifier = Modifier.size(20.dp))

                    Spacer(Modifier.width(4.dp))

                    Text("${course.durationHours}h")

                    Spacer(Modifier.width(20.dp))

                    Text(course.level, color = if (course.level.uppercase() == "BEGINNER") Color(0xFF32CD32) else Color.Yellow)
                }
            }
        }

        item {
            ElevatedCard(
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .fillMaxWidth()
                    .background(Color.White)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White)
                        .padding(16.dp)
                ) {
                    AsyncImage(
                        model = course.instructor.avatarUrl,
                        contentDescription = null,
                        modifier = Modifier.size(40.dp)
                    )

                    Spacer(Modifier.width(12.dp))

                    Column {
                        Text(course.instructor.name)
                        Text(course.instructor.title, color = Color.Gray)
                    }
                }
            }
        }

        item() {
            Spacer(Modifier.height(12.dp))

            Text(course.description, Modifier.padding(horizontal = 20.dp), color = Color.Gray)

            Spacer(Modifier.height(12.dp))
        }

        item {
            Row(
                Modifier.fillMaxWidth().padding(horizontal = 20.dp)
            ) {
                Text(
                    "Course content",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.fillMaxWidth().weight(1f)
                )

                Text("${course.lessons.size} lessons · ${course.lessons.sumOf{it.durationMinutes}}min", color = Color.Gray, modifier = Modifier.weight(1f))
            }
        }
        items(course.lessons) { lesson ->
            LessonCard(
                lesson = lesson,
                onClick = {
                    navController.navigate(
                        Screen.Lesson.createRoute(
                            course.id,
                            lesson.id)

                    )
                }
            )
        }
    }
}