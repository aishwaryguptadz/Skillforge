package com.skillforge.app.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.PlayCircle
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
    Card(
        modifier = Modifier
            .padding(
                horizontal = 16.dp,
                vertical = 6.dp
            )
            .fillMaxWidth(),
        onClick = onClick,
        border = BorderStroke(1.dp, Color(0xFFC4C4C4))
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().background(Color.White).padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (lesson.isFree) {
                Icon(
                    Icons.Default.PlayArrow,
                    null,
                    modifier = Modifier.fillMaxHeight(),
                    tint = Color(0xFF32CD32),
                )
            } else {
                Icon(
                    Icons.Default.Lock,
                    null,
                    modifier = Modifier.fillMaxHeight(),
                    tint = Color.LightGray
                )
            }

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
            }
        }
    }
}