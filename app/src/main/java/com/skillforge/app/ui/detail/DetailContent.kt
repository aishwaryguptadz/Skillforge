package com.skillforge.app.ui.detail

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBackIos
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(260.dp)
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
                        .background(Color.Black.copy(alpha = 0.20f))
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .align(Alignment.TopCenter),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Surface(
                        modifier = Modifier.size(42.dp),
                        shape = CircleShape,
                        color = Color.Black.copy(alpha = 0.35f)
                    ) {
                        IconButton(
                            onClick = {
                                navController.popBackStack()
                            }
                        ) {
                            Icon(
                                Icons.AutoMirrored.Filled.ArrowBackIos,
                                contentDescription = "Back",
                                tint = Color.White
                            )
                        }
                    }

                    Surface(
                        modifier = Modifier.size(42.dp),
                        shape = CircleShape,
                        color = Color.Black.copy(alpha = 0.35f)
                    ) {
                        IconButton(
                            onClick = {}
                        ) {
                            Icon(
                                Icons.Default.BookmarkBorder,
                                contentDescription = "Bookmark",
                                tint = Color.White
                            )
                        }
                    }
                }
            }
        }

        item {
            Column(
                modifier = Modifier.padding(20.dp)
            ) {
                LazyRow() {
                    items(course.tags) { item ->
                        Card(
                            Modifier.padding(4.dp),
                            colors = CardColors(
                                Color(0x5532CD32),
                                Color(0x5532CD32),
                                Color(0x5532CD32),
                                Color(0x5532CD32)
                            ),
                            shape = RoundedCornerShape(8.dp),
                            border = BorderStroke(1.dp, Color(0xFF32CD32))
                        ) {
                            Text(
                                text = item,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(4.dp)
                                    .background(Color.Transparent),
                                color = Color(0xFF32CD32)
                            )
                        }
                    }
                }

                Spacer(Modifier.height(12.dp))

                Text(
                    course.title,
                    style = MaterialTheme.typography.titleLarge
                )

                Spacer(Modifier.height(8.dp))

                Text(course.subtitle, color = Color.Gray)

                Spacer(Modifier.height(12.dp))

                Row(
                    Modifier.fillMaxWidth()
                ) {
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
            Card(
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .fillMaxWidth()
                    .background(Color.White),
                border = BorderStroke(1.dp, Color.LightGray)
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

                    Spacer(Modifier.weight(1f))

                    Row(
                        Modifier.fillMaxHeight(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Follow",
                            color = Color(0xFF32CD32)
                        )
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
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            ) {
                Text(
                    "Course content",
                    style = MaterialTheme.typography.titleMedium
                )

                Spacer(Modifier.weight(1f))

                Text(
                    "${course.lessons.size} lessons · ${course.lessons.sumOf{it.durationMinutes}}min",
                    color = Color.Gray,
                    softWrap = false,
                    maxLines = 1
                )
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