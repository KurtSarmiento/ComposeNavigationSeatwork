package com.example.composenavigationseatwork

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composenavigationseatwork.ui.theme.ComposeNavigationSeatworkTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeNavigationSeatworkTheme {
                    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                        HomeScreen(Modifier.padding(innerPadding))
                    }
            }
        }
    }
}

@Composable
fun HomeScreen(modifier: Modifier = Modifier){
    Column(
        modifier = modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Student Information"
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
            Text("View Details")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(){
    HomeScreen(modifier = Modifier.padding(16.dp))
}

//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    ComposeNavigationSeatworkTheme {
//        Greeting("Android")
//    }
//}