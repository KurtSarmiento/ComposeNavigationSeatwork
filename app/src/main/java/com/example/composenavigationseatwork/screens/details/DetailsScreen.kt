package com.example.composenavigationseatwork.screens.details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
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

        ElevatedCard(
            modifier = Modifier.padding(4.dp).fillMaxWidth(),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            )) {
            Column(
                modifier = Modifier.fillMaxWidth().padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text("Student Id:")
                Text("$studentId")
                Spacer(Modifier.height(4.dp))
                Text("Name:")
                Text("$name")
                Spacer(Modifier.height(4.dp))
                Text("Course:")
                Text("$course")
                Spacer(Modifier.height(4.dp))
                Text("Year Level:")
                Text("$year")
            }
        }
        Button(
            onClick = onBack
        ) {
            Text("Edit Information")
        }
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