package com.example.composenavigationseatwork.screens

sealed class Screen(val route:String) {
    data object Home: Screen("Home")

    data object Details: Screen("Details"){
    }
}