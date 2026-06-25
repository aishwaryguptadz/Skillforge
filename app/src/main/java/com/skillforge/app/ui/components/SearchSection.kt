package com.skillforge.app.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SearchSection() {
    OutlinedTextField(
        value = "",
        onValueChange = {},
        modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp),
        placeholder = {
            Text("Search courses, topics, etc.", color = Color.Gray)
        },
        leadingIcon = {
            Icon(
                Icons.Default.Search, null, tint = Color.Gray
            )
        },
        shape = RoundedCornerShape(16.dp),
        singleLine = true,
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color.LightGray,
            disabledBorderColor = Color.LightGray,
            unfocusedBorderColor = Color.LightGray
        )
    )
}

@Preview(showBackground = true)
@Composable
fun SearchPreview() {
    SearchSection()
}