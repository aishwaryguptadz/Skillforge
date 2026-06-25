package com.skillforge.app.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.AssistChip
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.innerShadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.skillforge.app.data.model.Lesson

@Composable
fun LessonCard(
    lesson: Lesson,
    onClick: () -> Unit
) {

    ElevatedCard(
        modifier = Modifier
            .padding(
                horizontal = 16.dp,
                vertical = 6.dp
            )
            .fillMaxWidth(),
        onClick = onClick
    ) {

        Row(
            modifier = Modifier.fillMaxWidth().background(Color.White).padding(16.dp),
            horizontalArrangement =
                Arrangement.SpaceBetween
        ) {

            Column {

                Text(lesson.title, color = if (lesson.isFree) Color.Black else Color.Gray)

                Text("${lesson.durationMinutes} min", color = Color.Gray)

            }

            if (lesson.isFree) {

                AssistChip(
                    onClick = {},
                    label = {
                        Text("FREE", color = Color(0xFF32CD32))
                    }
                )

            } else {

                Icon(
                    Icons.Default.Lock,
                    contentDescription = null,
                    modifier = Modifier.size(20.dp),
                    tint = Color.Gray
                )

            }

        }

    }

}