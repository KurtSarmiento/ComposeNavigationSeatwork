package com.example.composenavigationseatwork.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
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
        mutableIntStateOf(0)
    }
    var studentId by remember{
        mutableStateOf("1001")
    }
    var name by remember{
        mutableStateOf("Juan Dela Cruz")
    }
    var course by remember{
        mutableStateOf("BS Computer Engineering")
    }
    var year by remember{
        mutableStateOf("4")
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
        OutlinedTextField(
            value = studentId,
            onValueChange = {studentId = it},
            label = {Text("Student ID:")},
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = name,
            onValueChange = {name = it},
            label = {Text("Name:")},
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = course,
            onValueChange = {course = it},
            label = {Text("Course:")},
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = year,
            onValueChange = {year = it},
            label = {Text("Year Level:")},
            modifier = Modifier.fillMaxWidth()
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