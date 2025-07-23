package com.example.appsecurity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.appsecurity.ui.theme.AppSecurityTheme
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppSecurityTheme {
                val navController = rememberNavController()
                NavGraph(navController)
            }
        }
    }
}