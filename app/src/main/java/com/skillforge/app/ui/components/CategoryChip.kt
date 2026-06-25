package com.skillforge.app.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.skillforge.app.data.model.Category

@Composable
fun CategoryChip(category: Category) {
    ElevatedCard(
        modifier = Modifier
            .width(140.dp)
            .height(100.dp)
            .padding(horizontal = 20.dp)
    ) {
            Column(
                Modifier
                    .fillMaxSize()
                    .background(Color.White)
                    .padding(12.dp),
                Arrangement.Center,
                Alignment.Start
            ) {
                Box(
                    modifier = Modifier.background(Color.Green).padding(4.dp)
                ) {
                    Spacer(Modifier
                        .height(12.dp)
                        .width(12.dp)
                        .background(Color(0xFF32CD32)))
                }

                Spacer(Modifier.height(4.dp))

                Text(
                    text = category.name,
                    style = MaterialTheme.typography.labelLarge
                )

                Spacer(Modifier.height(4.dp))

                Text(
                    text = category.courseCount.toString() + " courses",
                    color = Color.LightGray,
                    style = MaterialTheme.typography.labelMedium
                )
            }
        }
    }
