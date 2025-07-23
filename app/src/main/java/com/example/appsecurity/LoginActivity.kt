package com.example.appsecurity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.appsecurity.ui.LoginScreen
import com.example.appsecurity.ui.theme.AppSecurityTheme
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : ComponentActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FirebaseApp.initializeApp(this)
        auth = Firebase.auth

        if (isLoggedIn()) {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
            return
        }

        setContent {
            AppSecurityTheme {
                LoginScreen(
                    onLogin = { e, p -> signIn(e, p) },
                    onRegister = { /* TODO launch register */ },
                    onRecover = { /* TODO launch recover */ }
                )
            }
        }
    }

    private fun signIn(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                saveSession()
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, task.exception?.localizedMessage, Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun isLoggedIn(): Boolean {
        val prefs = getSharedPreferences("session", MODE_PRIVATE)
        return prefs.getBoolean("logged_in", false) && auth.currentUser != null
    }

    private fun saveSession() {
        val prefs = getSharedPreferences("session", MODE_PRIVATE)
        prefs.edit().putBoolean("logged_in", true).apply()
    }
}
