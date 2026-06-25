package com.skillforge.app.ui.lesson

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.skillforge.app.data.model.Course
import com.skillforge.app.data.model.Lesson
import com.skillforge.app.navigation.Screen
import com.skillforge.app.ui.components.LessonPlaylistCard
import com.skillforge.app.ui.components.VideoPlayerHeader

@Composable
fun LessonContent(
    navController: NavHostController,
    course: Course,
    lesson: Lesson
    ) {
    LazyColumn() {
        item {
            VideoPlayerHeader(navController, course)
        }

        item {
            Column(
                modifier = Modifier.padding(20.dp)
            ) {
                Text(
                    lesson.title,
                    style = MaterialTheme.typography.titleMedium
                )

                Spacer(Modifier.height(8.dp))

                Text(lesson.content)
            }
        }

        item {
            HorizontalDivider()

            Text(
                "Lessons",
                modifier = Modifier.padding(20.dp)
            )
        }

        items(course.lessons) { currentLesson ->
            LessonPlaylistCard(
                lesson = currentLesson,
                selected = currentLesson.id == lesson.id,
                onClick = {
                    navController.navigate(
                        Screen.Lesson.createRoute(
                            course.id, currentLesson.id
                        )
                    )
                }
            )
        }
    }
}