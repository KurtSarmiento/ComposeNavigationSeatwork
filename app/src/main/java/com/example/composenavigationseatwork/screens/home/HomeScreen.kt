package com.example.composenavigationseatwork.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
@Composable
fun HomeScreen(onNavigate: (studentId : String, name : String, course: String, year : String) -> Unit) {
    var loginAttempts by remember { mutableIntStateOf(0) }
    var studentId by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var course by remember { mutableStateOf("") }
    var year by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf("") }
    var showDialog by remember { mutableStateOf(false) }

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
            onValueChange = { studentId = it },
            label = { Text("Student ID:") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name:") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = course,
            onValueChange = { course = it },
            label = { Text("Course:") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = year,
            onValueChange = { year = it },
            label = { Text("Year Level:") },
            modifier = Modifier.fillMaxWidth()
        )

        if (errorMessage.isNotEmpty()) {
            Text(
                text = errorMessage,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall
            )
        }

        Text(
            text = "Login Attempts: $loginAttempts"
        )
        Button(
            onClick = { loginAttempts++ }
        ) {
            Text("Add Attempt")
        }
        Button(
            onClick = {
                if (studentId.isBlank()) {
                    errorMessage = "Student ID is required."
                } else if (name.isBlank()) {
                    errorMessage = "Name is required."
                } else if (course.isBlank()) {
                    errorMessage = "Course is required."
                } else if (year.isBlank()) {
                    errorMessage = "Year Level is required"
                } else {
                    errorMessage = ""
                    showDialog = true
                }
            }
        ) {
            Text("View Details")
        }
        if(showDialog){
            AlertDialog(
                onDismissRequest = {
                    showDialog = false
                },
                title = {
                    Text("Confirm Student Information")
                },
                text = {
                    Column() {
                        Text("View Details for:")
                        Spacer(Modifier.height(4.dp))
                        Text("$name?")
                    }
                },
                confirmButton = {
                    Button(
                        onClick = {
                            showDialog = false
                            onNavigate(studentId, name, course, year)
                        }
                    ){
                        Text("Continue")
                    }
                },
                dismissButton = {
                    TextButton(
                        onClick = {
                            showDialog = false
                        }
                    ) {
                        Text("Cancel")
                    }
                }
            )
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun HomeScreenPreview() {
//    HomeScreen(onNavigate = {})
//}