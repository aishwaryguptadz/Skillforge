package com.skillforge.app.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.content.contentReceiver
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.PauseCircle
import androidx.compose.material.icons.filled.PlayCircle
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.skillforge.app.data.model.Lesson

@Composable
fun LessonPlaylistCard(
    lesson: Lesson,
    selected: Boolean,
    onClick: () -> Unit
    ) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 6.dp),
        colors = CardDefaults.elevatedCardColors(
            containerColor = if (selected) Color(0x5532CD32) else Color.White
        ),
        border = BorderStroke(1.dp, if (selected) Color(0xFF32CD32) else Color(0xFFC4C4C4)),
        onClick = onClick
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                if (lesson.isFree) if (selected) Icons.Default.PauseCircle else Icons.Default.PlayCircle else Icons.Default.Lock, null
            )

            Spacer(Modifier.width(12.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(lesson.title, color = if (selected) Color(0xFF32CD32) else Color.Black)
                Text("${lesson.durationMinutes} min", color = if (selected) Color(0xFF32CD32) else Color.Gray)
            }

            if (lesson.isFree) {
                if (!selected) {
                    AssistChip(
                        onClick = {},
                        label = { Text("FREE", color = Color(0xFF32CD32)) }
                    )
                }
            }
        }
    }
}