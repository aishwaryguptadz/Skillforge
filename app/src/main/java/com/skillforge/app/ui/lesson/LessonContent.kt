package com.skillforge.app.ui.lesson

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
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
            var selectedTab by rememberSaveable {
                mutableIntStateOf(0)
            }

            val tabs = listOf(
                "Lessons",
                "Notes",
                "Resources"
            )

            TabRow(
                selectedTabIndex = selectedTab,
                containerColor = Color.White,
                contentColor = Color(0xFF32CD32),
                divider = {},
                indicator = { tabPositions ->
                    TabRowDefaults.SecondaryIndicator(
                        modifier = Modifier.tabIndicatorOffset(tabPositions[selectedTab]),
                        color = Color(0xFF32CD32),
                        height = 2.dp
                    )
                }
            ) {
                tabs.forEachIndexed { index, title ->
                    Tab(
                        selected = selectedTab == index,
                        onClick = {
                            selectedTab = index
                        },
                        text = {
                            Text(
                                title,
                                fontWeight = if (selectedTab == index)
                                    FontWeight.Bold
                                else
                                    FontWeight.Normal
                            )
                        }
                    )
                }
            }
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