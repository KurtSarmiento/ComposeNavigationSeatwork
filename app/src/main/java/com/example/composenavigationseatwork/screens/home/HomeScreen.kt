package com.example.composenavigationseatwork.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composenavigationseatwork.ui.theme.ForestGreen40
import com.example.composenavigationseatwork.ui.theme.ForestGreen80

@Composable
fun HomeScreen(onNavigate: (studentId: String, name: String, course: String, year: String) -> Unit) {
    var loginAttempts by rememberSaveable { mutableIntStateOf(0) }
    var studentId by rememberSaveable { mutableStateOf("") }
    var name by rememberSaveable { mutableStateOf("") }
    var course by rememberSaveable { mutableStateOf("") }
    var year by rememberSaveable { mutableStateOf("") }
    var errorMessage by rememberSaveable { mutableStateOf("") }
    var showDialog by rememberSaveable { mutableStateOf(false) }
    //changed remember to rememberSaveable para po pag bumalik from deets, litaw parin sila po

    val textFieldColors = OutlinedTextFieldDefaults.colors(
        focusedBorderColor = MaterialTheme.colorScheme.primary,
        unfocusedBorderColor = MaterialTheme.colorScheme.secondary,
        focusedLabelColor = MaterialTheme.colorScheme.primary,
        unfocusedLabelColor = MaterialTheme.colorScheme.secondary
    )

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically)
    ) {
        Text(
            text = "Student Information",
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.Bold
        )
        OutlinedTextField(
            value = studentId,
            onValueChange = { studentId = it },
            label = { Text("Student ID:") },
            modifier = Modifier.fillMaxWidth(),
            colors = textFieldColors
        )
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name:") },
            modifier = Modifier.fillMaxWidth(),
            colors = textFieldColors
        )
        OutlinedTextField(
            value = course,
            onValueChange = { course = it },
            label = { Text("Course:") },
            modifier = Modifier.fillMaxWidth(),
            colors = textFieldColors
        )
        OutlinedTextField(
            value = year,
            onValueChange = { year = it },
            label = { Text("Year Level:") },
            modifier = Modifier.fillMaxWidth(),
            colors = textFieldColors
        )

        if (errorMessage.isNotEmpty()) {
            Text(
                text = errorMessage,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall
            )
        }

        Text(
            text = "Login Attempts: $loginAttempts",
            color = MaterialTheme.colorScheme.secondary,
            fontWeight = FontWeight.Medium
        )
        Row(
            modifier = Modifier.fillMaxWidth().height(IntrinsicSize.Max).padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally)
        ) {
            val gradientBrush = Brush.linearGradient(colors = listOf(ForestGreen40, ForestGreen80)
            )

            Button(
                onClick = { loginAttempts++ },
                modifier = Modifier.weight(1f).fillMaxHeight().background(brush = gradientBrush, shape = ButtonDefaults.shape),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                contentPadding = PaddingValues()
            ) {
                Text(
                    text = "Add\nAttempt",
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.labelLarge
                )
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
                },
                modifier = Modifier.weight(1f).fillMaxHeight().background(brush = gradientBrush, shape = ButtonDefaults.shape),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                contentPadding = PaddingValues()
            ) {
                Text(
                    text = "View\nDetails",
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.labelLarge
                )
            }
            Button(
                onClick = {
                    loginAttempts = 0
                    studentId = ""
                    name = ""
                    course = ""
                    year = ""
                },
                modifier = Modifier.weight(1f).fillMaxHeight().background(brush = gradientBrush, shape = ButtonDefaults.shape),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                contentPadding = PaddingValues()
            ) {
                Text(
                    text = "Clear",
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.labelLarge
                )
            }
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
                        },
                        modifier = Modifier.background(
                            brush = Brush.linearGradient(colors = listOf(ForestGreen40, ForestGreen80)),
                            shape = ButtonDefaults.shape
                        ),
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
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

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(onNavigate = { _, _, _, _ -> })
}