package com.example.composenavigationseatwork

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun DetailsScreen(){
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Student Details"
        )
        Text(
            text = "Student ID: 1001"
        )
        Text(
            text = "Name: Juan Dela Cruz"
        )
        Text(
            text = "Course: BS Computer Engineering"
        )
        Text(
            text = "Year: 4"
        )
        Button(
            onClick = {}
        ) {
            Text("Back")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailsScreenPreview(){
    DetailsScreen()
}