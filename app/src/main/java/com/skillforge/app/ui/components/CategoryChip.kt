package com.skillforge.app.ui.components

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.material3.Card
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
    Card(
        modifier = Modifier
            .width(150.dp)
            .padding(start = 10.dp),
        border = BorderStroke(1.dp, Color(0xFFC4C4C4))
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
                    modifier = Modifier.background(Color(0x5532CD32)).padding(4.dp)
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
    Spacer(Modifier.width(10.dp))
}
