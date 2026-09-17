package com.example.composenavigationseatwork.screens

sealed class Screen(val route:String) {
    data object Home: Screen("Home")

    data object Details: Screen("Details/{studentId}/{name}/{course}/{year}"){
        fun createRoute(studentId: String, name: String, course: String, year: String): String{
            return "Details/$studentId/$name/$course/$year"
        }
    }
}