package com.example.composenavigationseatwork.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
@Composable
fun HomeScreen(onNavigate: () -> Unit) {
    var loginAttempts by remember {
        mutableStateOf(0)
    }
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically)
    ) {
        Text(
            text = "Student Information",
            style = MaterialTheme.typography.headlineLarge
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
        Text(
            text = "Login Attempts: $loginAttempts"
        )
        Button(
            onClick = { loginAttempts++ }
        ) {
            Text("Add Attempt")
        }
        Button(
            onClick = onNavigate
        ) {
            Text("View Details")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(onNavigate = {})
}