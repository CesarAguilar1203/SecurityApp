package com.example.appsecurity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController

// Data class representing a detection record
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SecureCamTheme {
                val navController = rememberNavController()
                NavGraph(navController)
            }
        }
    }
}