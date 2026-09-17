package com.example.composenavigationseatwork.screens.details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun DetailsScreen(studentId : String?, name : String?, course: String?, year: String?, onBack: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically)
    ) {
        Text(
            text = "Student Details",
            style = MaterialTheme.typography.headlineLarge
        )
        Text(
            text = "Student ID: $studentId"
        )
        Text(
            text = "Name: $name"
        )
        Text(
            text = "Course: $course"
        )
        Text(
            text = "Year: $year"
        )
        Button(
            onClick = onBack
        ) {
            Text("Back")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailsScreenPreview() {
    DetailsScreen("1001", "Kurt Justine Sarmiento", "BS CpE", "4", onBack = {})
}